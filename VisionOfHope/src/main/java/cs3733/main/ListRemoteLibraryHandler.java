package cs3733.main;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.RemoteLibrariesDAO;
import cs3733.main.http.ListRemoteLibrariesRequest;
import cs3733.main.http.ListRemoteLibrariesResponse;
import cs3733.main.model.RemoteLib;


public class ListRemoteLibraryHandler implements RequestHandler<ListRemoteLibrariesRequest,ListRemoteLibrariesResponse>{
	
	public LambdaLogger logger;

	List<RemoteLib> getRemoteLibraries() throws Exception {
		logger.log("in getRemoteLibraries");
		RemoteLibrariesDAO dao = new RemoteLibrariesDAO();
		
		return dao.getAllRemoteLibraries();
	}

	@Override
	public ListRemoteLibrariesResponse handleRequest(ListRemoteLibrariesRequest input, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all playlists");

		ListRemoteLibrariesResponse response;
		try {
			List<RemoteLib> list = getRemoteLibraries();
			response = new ListRemoteLibrariesResponse(list, 200);
		} catch (Exception e) {
			response = new ListRemoteLibrariesResponse(403, e.getMessage());
		}
		
		return response;
	}

}
