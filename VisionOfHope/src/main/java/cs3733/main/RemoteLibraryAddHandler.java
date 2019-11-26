package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.DB.RemoteLibrariesDAO;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.http.RemoteLibraryAddRequest;
import cs3733.main.http.RemoteLibraryAddResponse;

public class RemoteLibraryAddHandler implements RequestHandler<RemoteLibraryAddRequest,RemoteLibraryAddResponse>{

	//need to make sure that playlist names are unique

	public LambdaLogger logger = null;
	
	@Override
	public RemoteLibraryAddResponse handleRequest(RemoteLibraryAddRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to create remote lib");

		RemoteLibraryAddResponse response = null;
		logger.log(req.toString());

		RemoteLibrariesDAO dao = new RemoteLibrariesDAO();

		try {
			if (dao.addRemoteLib(req.getName(), req.getURL())) {
				response = new RemoteLibraryAddResponse(req.getName(), 200);
			} else {
				response = new RemoteLibraryAddResponse(req.getName(), 422, "Unable to create remote lib.");
			}
		} catch (Exception e) {
			response = new RemoteLibraryAddResponse(req.getName(), 403, "Unable to create remote lib: " + req.getName() + "(" + e.getMessage() + ")");
		}

		return response;
	}

}
