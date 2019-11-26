package cs3733.main;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.http.VideoSegmentSearchRequest;
import cs3733.main.http.VideoSegmentSearchResponse;

public class VideoSegmentSearchHandler implements RequestHandler<VideoSegmentSearchRequest,VideoSegmentSearchResponse>{

	@Override
	public VideoSegmentSearchResponse handleRequest(VideoSegmentSearchRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}


}
