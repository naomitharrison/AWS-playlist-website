package main.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.model.VideoSegment;

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
	 * lists all videos by specified character and with specified title in local library
	 * 
	 * @param character
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public List<VideoSegment> searchVideos(String character, String title) throws Exception {
		try {
			List<VideoSegment> videos = new ArrayList<VideoSegment>();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where character = '" + character + "' title = '" + title + "'");
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
