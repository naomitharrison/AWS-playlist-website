package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.RemoteLibraryAddRequest;
import main.http.RemoteLibraryAddResponse;

public class RemoteLibraryAddHandler implements RequestHandler<RemoteLibraryAddRequest,RemoteLibraryAddResponse>{

	@Override
	public RemoteLibraryAddResponse handleRequest(RemoteLibraryAddRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
