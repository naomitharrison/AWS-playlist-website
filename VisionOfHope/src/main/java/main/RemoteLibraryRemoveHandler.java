package main;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.RemoteLibraryRemoveRequest;
import main.http.RemoteLibraryRemoveResponse;

public class RemoteLibraryRemoveHandler implements RequestHandler<RemoteLibraryRemoveRequest,RemoteLibraryRemoveResponse>{

	@Override
	public RemoteLibraryRemoveResponse handleRequest(RemoteLibraryRemoveRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
