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
	 * returns video with the given URL
	 * 
	 * @param URL
	 * @return
	 * @throws Exception
	 */
	public boolean changeRemoteAvail(String URL, boolean avail) throws Exception {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where videoURL = '" + URL + "'");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				PreparedStatement ps2;
				if (avail) {
					ps2 = conn.prepareStatement(
							"Update library set videoRemoteStatus = 'Y' WHERE videoURL = '" + URL + "'");
				} else {
					ps2 = conn.prepareStatement(
							"Update library set videoRemoteStatus = 'N' WHERE videoURL = '" + URL + "'");
				}
				ps2.executeUpdate();
				ps2.close();
				
				return true;
			}
			resultSet.close();
			ps.close();

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting video: " + e.getMessage());
		}
	}

	/**
	 * adds given video segment
	 * 
	 * @param vs
	 * @return
	 * @throws Exception
	 */
	public boolean addVideo(VideoSegment vs) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM library where videoURL = '" + vs.getUrl() + "'");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			while (resultSet.next()) {
				// return false if there is something returned
				return false;
			}
			ps.close();
			resultSet.close();

			System.out.println("no duplicates");

			String avail;
			if (vs.getAvailability()) {
				avail = "Y";
			} else {
				avail = "N";
			}

			// add video segment
			ps = conn.prepareStatement("INSERT INTO library VALUES ('" + vs.getTitle() + "','" + vs.getCharacter()
					+ "','" + vs.getUrl() + "','" + avail + "');");
			ps.execute();

			System.out.println("added to db");

			ps.close();
			resultSet.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in adding video: " + e.getMessage());
		}
	}

	/**
	 * deletes given video segment
	 * 
	 * @param vs
	 * @return
	 * @throws Exception
	 */
	public boolean deleteVideo(String URL) throws Exception {
		try {
			// get videos in where urls are equal
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM library where videoURL = '" + URL + "'");
			ResultSet resultSet = ps.executeQuery();

			// check if there is a returned row
			if (resultSet.next()) {
				// delete video segment
				PreparedStatement ps2 = conn.prepareStatement("delete from library where videoURL = '" + URL + "';");
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
		String avail = "";
		boolean isAvail;

		title = resultSet.getString("videoName");
		character = resultSet.getString("videoCharacter");
		URL = resultSet.getString("videoURL");
		avail = resultSet.getString("videoRemoteStatus");

		if(avail.equals("Y")) {
			isAvail = true;
		}else {
			isAvail = false;
		}

		VideoSegment vs = new VideoSegment(title, character, URL);
		vs.setAvailability(isAvail);
		
		return vs;
	}

}
