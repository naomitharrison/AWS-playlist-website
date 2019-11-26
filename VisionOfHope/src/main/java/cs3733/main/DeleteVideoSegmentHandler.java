package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.DeletePlaylistResponse;
import cs3733.main.http.DeleteVideoSegmentRequest;
import cs3733.main.http.DeleteVideoSegmentResponse;
import cs3733.main.model.Playlist;
import cs3733.main.model.VideoSegment;

public class DeleteVideoSegmentHandler implements RequestHandler<DeleteVideoSegmentRequest,DeleteVideoSegmentResponse>{
	public LambdaLogger logger = null;
	
	@Override
	public DeleteVideoSegmentResponse handleRequest(DeleteVideoSegmentRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to delete video segment");

		DeleteVideoSegmentResponse response = null;
		logger.log(req.toString());

		VideoSegmentsDAO dao = new VideoSegmentsDAO();
		
		try {
			if (dao.deleteVideoSegment(req.getURL())) {
				response = new DeleteVideoSegmentResponse(req.getURL(), 200);
			} else {
				response = new DeleteVideoSegmentResponse(req.getURL(), 422, "Unable to delete playlist");
			}
		} catch (Exception e) {
			response = new DeleteVideoSegmentResponse(req.getURL(), 403, "Unable to delete playlist: " + req.getURL() + "(" + e.getMessage() + ")");
		}

		return response; 
	}

}
