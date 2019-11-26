package main;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.VideoSegmentSearchRequest;
import main.http.VideoSegmentSearchResponse;

public class VideoSegmentSearchHandler implements RequestHandler<VideoSegmentSearchRequest,VideoSegmentSearchResponse>{

	@Override
	public VideoSegmentSearchResponse handleRequest(VideoSegmentSearchRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}


}
