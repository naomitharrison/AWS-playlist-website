package cs3733.main;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.VideoSegmentSearchRequest;
import cs3733.main.http.VideoSegmentSearchResponse;
import cs3733.main.model.VideoSegment;

public class VideoSegmentSearchHandler implements RequestHandler<VideoSegmentSearchRequest, VideoSegmentSearchResponse> {
	public LambdaLogger logger = null;

	@Override
	public VideoSegmentSearchResponse handleRequest(VideoSegmentSearchRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to search for video segment");

		VideoSegmentSearchResponse response = null;
		logger.log(req.toString());

		VideoSegmentsDAO dao = new VideoSegmentsDAO();

		boolean videos = false;

		try {
			List<VideoSegment> searchResult = null;
			searchResult = dao.searchVideos(req.getCharacter(), req.getString());
			if (searchResult != null) { videos = true; }
		} catch (Exception e) {
			response = new VideoSegmentSearchResponse(req.getSearch(), 403,"Unable to search: " + req.getSearch() + "(" + e.getMessage() + ")");
		}

		if (videos) {
			response = new VideoSegmentSearchResponse(req.getSearch(), 200);
		} 
		else {
			response = new VideoSegmentSearchResponse(req.getSearch(), 422, "Unable to search");
		}

		return response;
	}

}
