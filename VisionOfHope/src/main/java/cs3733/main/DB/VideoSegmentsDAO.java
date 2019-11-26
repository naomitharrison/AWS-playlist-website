package cs3733.main.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.VideoSegment;

public class VideoSegmentsDAO {

	java.sql.Connection conn;

	public VideoSegmentsDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}

	/**
	 * lists all videos in local library
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> getAllVideoSegments() throws Exception {

		try {
			List<VideoSegment> videos = new ArrayList<VideoSegment>();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM innodb.library");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				VideoSegment vs = generateVideoSegment(resultSet);
				videos.add(vs);
			}
			resultSet.close();
			ps.close();

			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}

	}

	/**
	 * lists all videos with specified title in local library
	 * 
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> listAllVideosWithTitle(String title) throws Exception {

		try {
			List<VideoSegment> videos = new ArrayList<VideoSegment>();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where title = '" + title + "'");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				VideoSegment vs = generateVideoSegment(resultSet);
				videos.add(vs);
			}
			resultSet.close();
			ps.close();

			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}

	}

	/**
	 * lists all videos by specified character in local library
	 * 
	 * @param character
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> listAllVideosByCharacter(String character) throws Exception {

		try {
			List<VideoSegment> videos = new ArrayList<VideoSegment>();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where character = '" + character + "'");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				VideoSegment vs = generateVideoSegment(resultSet);
				videos.add(vs);
			}
			resultSet.close();
			ps.close();

			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}

	}

	/**
	 * lists all videos by specified character and with specified title in local
	 * library
	 * 
	 * @param character
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> searchVideos(String character, String title) throws Exception {
		try {
			List<VideoSegment> videos = new ArrayList<VideoSegment>();

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM library where character = '" + character + "' title = '" + title + "'");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				VideoSegment vs = generateVideoSegment(resultSet);
				videos.add(vs);
			}
			resultSet.close();
			ps.close();

			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}
	}

	public boolean addVideo(VideoSegment vs) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where videoURL = '" + vs.getUrl() + "'");
			ResultSet resultSet = ps.executeQuery();
			
			// check if there is a returned row
			while(resultSet.next()) {
				// return false if there is something returned
				return false;
			}
			ps.close();
			resultSet.close();
			
			// add video segment
			ps = conn.prepareStatement("INSERT INTO library VALUES ('" + vs.getTitle() +"','" + vs.getCharacter() + "','" + vs.getUrl() + "','" + vs.getAvaiability() + "');");
			resultSet = ps.executeQuery();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting videos: " + e.getMessage());
		}
	}

	/**
	 * creates video segment given resultset from library
	 * 
	 * @param resultSet
	 * @return
	 * @throws Exception
	 */
	private VideoSegment generateVideoSegment(ResultSet resultSet) throws Exception {

		String URL = "";
		String title = "";
		String character = "";

		title = resultSet.getString("videoName");
		character = resultSet.getString("videoCharacter");
		URL = resultSet.getString("videoURL");

		return new VideoSegment(title, character, URL);
	}

}
