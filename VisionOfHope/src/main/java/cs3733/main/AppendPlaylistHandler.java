package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.http.AppendPlaylistRequest;
import cs3733.main.http.AppendPlaylistResponse;

public class AppendPlaylistHandler implements RequestHandler<AppendPlaylistRequest,AppendPlaylistResponse>{

	@Override
	public AppendPlaylistResponse handleRequest(AppendPlaylistRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
