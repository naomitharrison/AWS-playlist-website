package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.DeletePlaylistRequest;
import main.http.DeletePlaylistResponse;

public class DeletePlaylistHandler implements RequestHandler<DeletePlaylistRequest,DeletePlaylistResponse>{

	@Override
	public DeletePlaylistResponse handleRequest(DeletePlaylistRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
