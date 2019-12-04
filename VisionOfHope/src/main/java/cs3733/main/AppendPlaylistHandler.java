package cs3733.main;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.http.AppendPlaylistRequest;
import cs3733.main.http.AppendPlaylistResponse;
import cs3733.main.http.ListPlaylistVideoSegmentsRequest;
import cs3733.main.http.ListPlaylistVideoSegmentsResponse;
import cs3733.main.model.Playlist;
import cs3733.main.model.VideoSegment;

public class AppendPlaylistHandler implements RequestHandler<AppendPlaylistRequest,AppendPlaylistResponse>{
	public LambdaLogger logger;

	/** 
	 * find playlist video segments in RDS
	 * @throws Exception 
	 */
	boolean appendPlaylist(String playlistName, String videoURL) throws Exception {
		logger.log("in appendPlaylist");
		PlaylistsDAO dao = new PlaylistsDAO();
		
		// check if playlist exists
		Playlist playlist = dao.getPlaylist(playlistName);
		logger.log("dao.getPlaylist"+playlist);
		if(playlist != null) {
			logger.log("if playlist != null");
			return dao.addVideoToPlaylist(playlistName, videoURL);
		}
		else {
			logger.log("if playlist == null");
			return false;
		}
	}
	
	@Override
	public AppendPlaylistResponse handleRequest(AppendPlaylistRequest req, Context context) {

		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all playlist video segments");

		AppendPlaylistResponse response;
		try {
			// get all video segments associated with a playlist in the database
			appendPlaylist(req.getName(), req.getVideoUrl());
			response = new AppendPlaylistResponse(req.getName(), 200);
		} catch (Exception e) {
			response = new AppendPlaylistResponse(req.getName(), 403, e.getMessage());
		}		
		return response;
	}

}
