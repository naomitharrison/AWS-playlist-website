package cs3733.main;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.http.RemoteLibraryRemoveRequest;
import cs3733.main.http.RemoteLibraryRemoveResponse;

public class RemoteLibraryRemoveHandler implements RequestHandler<RemoteLibraryRemoveRequest,RemoteLibraryRemoveResponse>{

	@Override
	public RemoteLibraryRemoveResponse handleRequest(RemoteLibraryRemoveRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
