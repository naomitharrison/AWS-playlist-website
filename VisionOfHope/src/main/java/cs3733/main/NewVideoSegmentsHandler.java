package cs3733.main;

import java.io.ByteArrayInputStream;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.NewVideoSegmentsRequest;
import cs3733.main.http.NewVideoSegmentsResponse;
import cs3733.main.model.VideoSegment;

public class NewVideoSegmentsHandler implements RequestHandler<NewVideoSegmentsRequest,NewVideoSegmentsResponse>{

	LambdaLogger logger;
	
	private AmazonS3 s3 = null;
	
	public static final String bucket = "videos/";
	
	/**
	 * adds given video to database
	 * @param vs
	 * @return
	 */
	boolean addVideo(VideoSegment vs) throws Exception{
		if (logger != null) { logger.log("in add to db"); }
		
		VideoSegmentsDAO dao = new VideoSegmentsDAO();
		
		//adds to database, returns false if its not there
		return dao.addVideo(vs);
		
	}
	
	boolean addToS3(VideoSegment vs, byte[] file) throws Exception{
if (logger != null) { logger.log("in add to s3"); }
		
		if (s3 == null) {
			logger.log("attach to S3 request");
			s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			logger.log("attach to S3 succeed");
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(file);
		ObjectMetadata omd = new ObjectMetadata();
		omd.setContentLength(file.length);
		omd.setContentType("audio/ogg");
		
		// makes the object publicly visible
		PutObjectResult res = s3.putObject(new PutObjectRequest("cs3733visionofhopesurpassed", bucket + vs.getTitle() + ".ogg", bais, omd)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		
		// if we ever get here, then whole thing was stored
		return true;
	}
	
	@Override
	public NewVideoSegmentsResponse handleRequest(NewVideoSegmentsRequest req, Context context) {
		logger = context.getLogger();
		logger.log(req.toString());

		VideoSegment vs = createVideoSegment(req);
		NewVideoSegmentsResponse response;
		try {
			byte[] encoded = java.util.Base64.getDecoder().decode(req.base64EncodedValue);
			
			if(addVideo(vs) && addToS3(vs, encoded)) {
				response = new NewVideoSegmentsResponse(req.title, 200);
			}else {
				response = new NewVideoSegmentsResponse(req.title, 422, "unable to add video to library");
			}
		} catch (Exception e) {
			response = new NewVideoSegmentsResponse("Unable to add Video: " + req.title + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

	private VideoSegment createVideoSegment(NewVideoSegmentsRequest req) {
		// TODO Auto-generated method stub
		String character = req.getCharacter();
		String title = req.getTitle();
		String url = "https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/";
		String urlTitle = title;
		urlTitle = urlTitle.replace(" ", "+");
		url = url + urlTitle + ".ogg";
		
		return new VideoSegment(title,character, url);
	}
	

}
