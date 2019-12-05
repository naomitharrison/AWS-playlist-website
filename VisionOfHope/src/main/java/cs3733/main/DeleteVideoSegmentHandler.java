package cs3733.main;

import java.io.ByteArrayInputStream;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.DeletePlaylistResponse;
import cs3733.main.http.DeleteVideoSegmentRequest;
import cs3733.main.http.DeleteVideoSegmentResponse;
import cs3733.main.model.Playlist;
import cs3733.main.model.VideoSegment;

public class DeleteVideoSegmentHandler implements RequestHandler<DeleteVideoSegmentRequest,DeleteVideoSegmentResponse>{
	public LambdaLogger logger = null;
	private AmazonS3 s3 = null;

	boolean deleteFromS3(String url) throws Exception {
		
if (logger != null) { logger.log("in delete from s3"); }
		
		if (s3 == null) {
			logger.log("attach to S3 request");
			s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			logger.log("attach to S3 succeed");
		}

		String name = url;
		name = name.substring(60,name.length()-4);
		//System.out.println(name);
		
		s3.deleteObject("cs3733visionofhopesurpassed","videos/" + name + ".ogg");
		

		return true;
		
	}
	
	@Override
	public DeleteVideoSegmentResponse handleRequest(DeleteVideoSegmentRequest req, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to delete video segment");

		DeleteVideoSegmentResponse response = null;
		logger.log(req.toString());

		VideoSegmentsDAO dao = new VideoSegmentsDAO();
		
		try {
			if (dao.deleteVideo(req.getURL())&&deleteFromS3(req.getURL())) {
				response = new DeleteVideoSegmentResponse(req.getURL(), 200);
			} else {
				response = new DeleteVideoSegmentResponse(req.getURL(), 422, "Unable to delete video segment");
			}
		} catch (Exception e) {
			response = new DeleteVideoSegmentResponse(req.getURL(), 403, "Unable to delete video segment: " + req.getURL() + "(" + e.getMessage() + ")");
		}

		return response; 
	}

}
