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
		System.out.println("SELECT * FROM library where videoURL = '" + URL + "'");
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
		// TODO Auto-generated method stub
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
				playlist.appendEntry(vs);
			}
			resultSet.close();
			ps.close();

			return playlist;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting playlists: " + e.getMessage());
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
			ps = conn.prepareStatement("INSERT INTO playlists VALUES (null, '" + name + "', null );");
			resultSet = ps.executeQuery();
			
			ps.close();
			resultSet.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}
	}

	public boolean deletePlaylist(String name) throws Exception {
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
			ps = conn.prepareStatement("delete from playlists were playlist name = '" + name + "');");
			resultSet = ps.executeQuery();
			
			ps.close();
			resultSet.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}
	}

}
