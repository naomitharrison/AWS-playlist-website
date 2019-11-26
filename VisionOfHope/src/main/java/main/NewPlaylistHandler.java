package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.NewPlaylistRequest;
import main.http.NewPlaylistResponse;


public class NewPlaylistHandler implements RequestHandler<NewPlaylistRequest,NewPlaylistResponse>{
	//need to make sure that playlist names are unique

	@Override
	public NewPlaylistResponse handleRequest(NewPlaylistRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
