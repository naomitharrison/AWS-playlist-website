package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.http.AppendPlaylistRequest;
import cs3733.main.http.AppendPlaylistResponse;
import cs3733.main.http.DeletePlaylistVideoSegmentRequest;
import cs3733.main.http.DeletePlaylistVideoSegmentResponse;
import cs3733.main.model.Playlist;

public class DeletePlaylistVideoSegmentHandler implements RequestHandler<DeletePlaylistVideoSegmentRequest,DeletePlaylistVideoSegmentResponse>{
	public LambdaLogger logger;

	/** 
	 * find playlist video segments in RDS
	 * @throws Exception 
	 */
	boolean deletePlaylistVideo(String playlistName, String videoURL) throws Exception {
		logger.log("in appendPlaylist");
		PlaylistsDAO dao = new PlaylistsDAO();
		
		// check if playlist exists
		Playlist playlist = dao.getPlaylist(playlistName);
		if(playlist != null) {
			return dao.deleteVideoFromPlaylist(playlistName, videoURL);
		}
		else {
			return false;
		}
	}
	
	@Override
	public DeletePlaylistVideoSegmentResponse handleRequest(DeletePlaylistVideoSegmentRequest req, Context context) {

		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all playlist video segments");

		DeletePlaylistVideoSegmentResponse response;
		try {
			// get all video segments associated with a playlist in the database
			deletePlaylistVideo(req.getName(), req.getUrl());
			response = new DeletePlaylistVideoSegmentResponse(req.getName(), 200);
		} catch (Exception e) {
			response = new DeletePlaylistVideoSegmentResponse(req.getName(), 403, e.getMessage());
		}		
		return response;
	}
}
