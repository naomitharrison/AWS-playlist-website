package cs3733.main;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.RemoteLibrariesDAO;
import cs3733.main.http.RemoteLibraryAddRequest;
import cs3733.main.http.RemoteLibraryAddResponse;
import cs3733.main.http.RemoteLibraryRemoveRequest;
import cs3733.main.http.RemoteLibraryRemoveResponse;

public class RemoteLibraryRemoveHandler implements RequestHandler<RemoteLibraryRemoveRequest,RemoteLibraryRemoveResponse>{

	//need to make sure that playlist names are unique

	public LambdaLogger logger = null;
	
	@Override
	public RemoteLibraryRemoveResponse handleRequest(RemoteLibraryRemoveRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to create remote lib");

		RemoteLibraryRemoveResponse response = null;
		logger.log(req.toString());

		RemoteLibrariesDAO dao = new RemoteLibrariesDAO();

		try {
			if (dao.deleteRemoteLib(req.getUrl())) {
				response = new RemoteLibraryRemoveResponse(req.getUrl(), 200);
			} else {
				response = new RemoteLibraryRemoveResponse(req.getUrl(), 422, "Unable to create remote lib.");
			}
		} catch (Exception e) {
			response = new RemoteLibraryRemoveResponse(req.getUrl(), 403, "Unable to create remote lib: " + req.getUrl() + "(" + e.getMessage() + ")");
		}

		return response;
	}


}
