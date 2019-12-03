package cs3733.main.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.Playlist;
import cs3733.main.model.VideoSegment;

public class PlaylistsDAO {

	java.sql.Connection conn;

	public PlaylistsDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}

	/**
	 * returns list of all the playlists
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Playlist> listAllPlaylists() throws Exception {

		try {
			List<Playlist> playlists = new ArrayList<Playlist>();

			PreparedStatement ps = conn.prepareStatement("SELECT distinct playlistname FROM playlists");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Playlist p = generatePlaylist(resultSet);
				playlists.add(p);
			}
			resultSet.close();
			ps.close();

			for (Playlist playlist : playlists) {
				ps = conn.prepareStatement("SELECT * FROM playlists where playlistname = '" + playlist.getName() + "'");
				resultSet = ps.executeQuery();

				while (resultSet.next()) {
					VideoSegment vs = generateVideoSegment(resultSet);
					if(vs!=null)
						playlist.appendEntry(vs);
				}
				resultSet.close();
				ps.close();
			}
			return playlists;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting playlists: " + e.getMessage());
		}
	}

	/**
	 * creates video segment given resultset from playlist
	 * 
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	private VideoSegment generateVideoSegment(ResultSet resultSet) throws Exception {
		
		String URL = resultSet.getString("videoURL");
		if(URL == null) {
			return null;
		}
		//System.out.println("SELECT * FROM library where videoURL = '" + URL + "'");
		PreparedStatement p = conn.prepareStatement("SELECT * FROM innodb.library where videoURL = '" + URL + "';");
		ResultSet result = p.executeQuery();
		String title = "y";
		String character = "y";

		while (result.next()) {
			title = result.getString("videoName");
			character = result.getString("videoCharacter");
		}

		result.close();
		p.close();

		return new VideoSegment(title, character, URL);
	}

	/**
	 * creats a playlist with empty video list
	 * 
	 * @param resultSet
	 * @return
	 */
	private Playlist generatePlaylist(ResultSet resultSet) throws Exception {
		return new Playlist(resultSet.getString("playlistname"));
	}

	/**
	 * returns playlist with given name
	 * 
	 * @param playlistName
	 * @return
	 */
	public Playlist getPlaylist(String playlistName) throws Exception {
		try {
			Playlist playlist = new Playlist(playlistName);

			// all playlist names are unique
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM playlists where playlistname = '" + playlist.getName() + "'");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				VideoSegment vs = generateVideoSegment(resultSet);
				if(vs!=null)
					playlist.appendEntry(vs);
			}
			resultSet.close();
			ps.close();

			return playlist;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting playlist: " + e.getMessage());
		}
	}

	/**
	 * returns list of videos in given playlist
	 * 
	 * @param playlistName
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> getPlaylistVideoSegments(String playlistName) throws Exception {
		Playlist p = getPlaylist(playlistName);

		return p.getPlaylistVideos();
	}

	public boolean addPlaylist(String name) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM playlists where playlistName = '" + name + "'");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			while (resultSet.next()) {
				// return false if there is something returned
				return false;
			}
			ps.close();
			resultSet.close();

			// add video segment
			ps = conn.prepareStatement("INSERT INTO playlists VALUES ('', '" + name + "', '' );");
			ps.execute();

			ps.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in adding playlist: " + e.getMessage());
		}
	}

	public boolean deletePlaylist(String name) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM playlists where playlistName = '" + name + "'");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			while (resultSet.next()) {
				ps.close();
				resultSet.close();

				// add video segment
				PreparedStatement ps2 = conn.prepareStatement("delete from playlists where playlistName = '" + name + "';");
				ps2.executeUpdate();

				ps2.close();
				ps.close();
				resultSet.close();
				
				return true;
			}
			ps.close();
			resultSet.close();
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in deleting playlist: " + e.getMessage());
		}
	}

	public boolean addVideoToPlaylist(String playlistName, String videoURL) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM playlists where playlistName = '" + playlistName
					+ "' and videoURL = '" + videoURL + "'");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			while (resultSet.next()) {
				// return false if there is something returned
				return false;
			}
			ps.close();
			resultSet.close();

			// add video segment
			ps = conn.prepareStatement(
					"INSERT INTO playlists VALUES ( '" + videoURL + "', '" + playlistName + "', null );");
			ps.execute();

			ps.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in adding video: " + e.getMessage());
		}
	}

	public boolean deleteVideoFromPlaylist(String playlistName, String videoURL) throws Exception {
		try {
			// get videos in where urls are equal
			System.out.println(videoURL);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM playlists where playlistName = '" + playlistName
					+ "' and videoURL = '" + videoURL + "';");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			while (resultSet.next()) {
				PreparedStatement ps2 = conn.prepareStatement(
						"DELETE FROM playlists where videoURL =  '" + videoURL + "' and playlistName =  '" + playlistName + "';");
				ps2.executeUpdate();

				ps2.close();
				ps.close();
				resultSet.close();
				return true;
			}
			ps.close();
			resultSet.close();
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in deleting video: " + e.getMessage());
		}
	}

}
