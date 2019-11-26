package cs3733.main.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.RemoteLib;
import cs3733.main.model.VideoSegment;

public class RemoteLibrariesDAO {
	
	java.sql.Connection conn;

	public RemoteLibrariesDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}

	public List<RemoteLib> getAllRemoteLibraries() throws Exception {
		try {
			List<RemoteLib> remotes = new ArrayList<RemoteLib>();
			
			PreparedStatement ps = conn.prepareStatement("SELECT distinct remoteURL, name FROM innodb.remoteLibraries");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				RemoteLib rl = generateRemoteLibrary(resultSet);
				remotes.add(rl);
			}
			resultSet.close();
			ps.close();
			
			for(RemoteLib remote: remotes) {
				ps = conn.prepareStatement("SELECT * FROM innodb.remoteLibraries where remoteURL = '" + remote.getUrl() + "'");
				resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					VideoSegment vs = generateVideoSegment(resultSet);
					remote.addVideo(vs);
				}
				resultSet.close();
				ps.close();
			}

			return remotes;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}

	}

	private RemoteLib generateRemoteLibrary(ResultSet resultSet) throws SQLException {
		String name = "";
		String URL = "";
		
		name = resultSet.getString("name");
		URL = resultSet.getString("remoteURL");
		
		return new RemoteLib(name,URL);
	}

	private VideoSegment generateVideoSegment(ResultSet resultSet) throws Exception {
		String URL = resultSet.getString("videoURL");
		PreparedStatement p = conn.prepareStatement("SELECT * FROM innodb.remoteLibraries where videoURL = '" + URL + "'");
        ResultSet result = p.executeQuery();
        String title = "";
        String character = "";
        
        while (result.next()) {
        	title = result.getString("videoTitle");
        	character = result.getString("videoCharacter");
        }
        
        result.close();
        p.close();
		
		return new VideoSegment(title,character,URL);
	}
}
