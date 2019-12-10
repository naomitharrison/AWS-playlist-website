package cs3733.main;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.ListVideoSegmentsResponse;
import cs3733.main.http.RemoteVideoSegmentsRequest;
import cs3733.main.http.RemoteVideoSegmentsResponse;
import cs3733.main.model.VideoSegment;

public class RemoteVideoSegmentsHandler
		implements RequestHandler<RemoteVideoSegmentsRequest, RemoteVideoSegmentsResponse> {

	public LambdaLogger logger;

	@Override
	public RemoteVideoSegmentsResponse handleRequest(RemoteVideoSegmentsRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list remote video segments");

		VideoSegmentsDAO dao = new VideoSegmentsDAO();
		logger.log("DAO Created");
		RemoteVideoSegmentsResponse response;
		try {
			List<VideoSegment> segments = dao.getRemoteVideoSegments();
			response = new RemoteVideoSegmentsResponse(segments, 200);
		} catch (Exception e) {
			response = new RemoteVideoSegmentsResponse(403, e.getMessage());
		}

		return response;
	}
}
