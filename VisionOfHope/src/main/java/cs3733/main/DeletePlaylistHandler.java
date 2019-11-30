package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.http.DeletePlaylistRequest;
import cs3733.main.http.DeletePlaylistResponse;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.model.Playlist;

public class DeletePlaylistHandler implements RequestHandler<DeletePlaylistRequest,DeletePlaylistResponse>{
public LambdaLogger logger = null;
	
	@Override
	public DeletePlaylistResponse handleRequest(DeletePlaylistRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to delete playlist");

		DeletePlaylistResponse response = null;
		logger.log(req.toString());

		PlaylistsDAO dao = new PlaylistsDAO();
		
		try {
			if (dao.deletePlaylist(req.getName())) {
				response = new DeletePlaylistResponse(req.getName(), 200);
			} else {
				response = new DeletePlaylistResponse(req.getName(), 422, "Unable to delete playlist");
			}
		} catch (Exception e) {
			response = new DeletePlaylistResponse(req.getName(), 403, "Unable to delete playlist: " + req.getName() + "(" + e.getMessage() + ")");
		}

		return response; 
	}
}
