package cs3733.main;

import java.sql.Array;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.RemoteLibrariesDAO;
import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.RemoteLibraryAddResponse;
import cs3733.main.http.RemoteStatusRequest;
import cs3733.main.http.RemoteStatusResponse;
import cs3733.main.model.VideoSegment;

public class RemoteStatusHandler implements RequestHandler<RemoteStatusRequest,RemoteStatusResponse>{

	public LambdaLogger logger = null;
	
	@Override
	public RemoteStatusResponse handleRequest(RemoteStatusRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to change remote availability: " + req.getVideoUrls());

//		RemoteLibraryAddResponse response = null;
//		logger.log(req.toString());

		VideoSegmentsDAO dao = new VideoSegmentsDAO();

		RemoteStatusResponse response;
		
		try {
			boolean working = true;
			for(int i =0; i<req.getVideoUrls().length; i++) {
				String url = req.getVideoUrls()[i];
				boolean available = req.getCheckboxes()[i];
				boolean changed = dao.changeRemoteAvail(url,available);	
				if (changed == false) {working = false; break;}
			}
			if (working) {
				response = new RemoteStatusResponse(req.getVideoUrls(), 200);
			} else {
				response = new RemoteStatusResponse(req.getVideoUrls(), 422, "Unable to create remote lib.");
			}
		} catch (Exception e) {
			response = new RemoteStatusResponse(req.getVideoUrls(), 403,
					"Unable to create remote lib: " + req.getVideoUrls() + "(" + e.getMessage() + ")");
		}

		return response;
	}
}


