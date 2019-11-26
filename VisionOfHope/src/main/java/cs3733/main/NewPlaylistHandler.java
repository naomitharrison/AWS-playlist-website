package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.model.Playlist;


public class NewPlaylistHandler implements RequestHandler<NewPlaylistRequest,NewPlaylistResponse>{
	//need to make sure that playlist names are unique

	public LambdaLogger logger = null;
	
	@Override
	public NewPlaylistResponse handleRequest(NewPlaylistRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to delete");

		NewPlaylistResponse response = null;
		logger.log(req.toString());

		PlaylistsDAO dao = new PlaylistsDAO();

		// See how awkward it is to call delete with an object, when you only
		// have one part of its information?
		Playlist playlist = new Playlist(req.getName());
		try {
			if (dao.addPlaylist(playlist)) {
				response = new NewPlaylistResponse(req.name, 200);
			} else {
				response = new NewPlaylistResponse(req.name, 422, "Unable to delete constant.");
			}
		} catch (Exception e) {
			response = new NewPlaylistResponse(req.name, 403, "Unable to delete constant: " + req.name + "(" + e.getMessage() + ")");
		}

		return response;
	}
}
