package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import main.DB.VideoSegmentsDAO;
import main.http.ListVideoSegmentsRequest;
import main.http.ListVideoSegmentsResponse;
import main.model.VideoSegment;

public class ListVideoSegmentsHandler implements RequestHandler<Object,ListVideoSegmentsResponse>{

	public LambdaLogger logger;

	/** 
	 * find video segment in RDS
	 * @throws Exception 
	 */
	List<VideoSegment> getVideoSegments() throws Exception {
		logger.log("in getVideoSegments");
		VideoSegmentsDAO dao = new VideoSegmentsDAO();

		logger.log("DAO Created");
		return dao.getAllVideoSegments();
	}
	
	private AmazonS3 s3 = null;
	
	/**
	 * find video segment in S3 (if not in RDS)
	 * @throws Exception
	 */
	List<VideoSegment> s3VideoSegments() throws Exception {
		logger.log("in s3VideoSegments");
		if (s3 == null) {
			logger.log("attach to S3 request");
			s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			logger.log("attach to S3 succeed");
		}
		
		ArrayList<VideoSegment> s3VideoSegments = new ArrayList<>();
	    
		// list of all objects in s3 bucket video folder
		ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request()
				  .withBucketName("cs3733visionofhopesurpassed")    // bucket name
				  .withPrefix("videos");       						// folder name
		
		logger.log("process request");
		ListObjectsV2Result result = s3.listObjectsV2(listObjectsRequest);
		logger.log("process request succeeded");
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		
		for (S3ObjectSummary os: objects) {
	      String title = os.getKey();
		  logger.log("S3 found:" + title); // the key of the s3 bucket object is the title

	      // If name ends with slash it is the 'constants/' bucket itself so you skip
	      if (title.endsWith("/")) { continue; }
			
	      S3Object obj = s3.getObject("cs3733visionofhopesurpassed", title);
	    	
	    	try (S3ObjectInputStream VideoSegmentStream = obj.getObjectContent()) {
				Scanner sc = new Scanner(VideoSegmentStream);
				String character = sc.nextLine(); // the first line of the s3 bucket object content is the character
				String url = sc.nextLine(); // the next line of the s3 bucket object content is the url
				sc.close(); // tell it to stop
				
				// just grab name *after* the slash. Note this is a SYSTEM constant
				int postSlash = title.indexOf('/');
				s3VideoSegments.add(new VideoSegment(title.substring(postSlash+1), character, url));
			} catch (Exception e) {
				logger.log("Unable to parse contents of " + title);
			}
	    }
		
		return s3VideoSegments;
	}
	
	@Override
	public ListVideoSegmentsResponse handleRequest(Object input, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all video segments");

		ListVideoSegmentsResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<VideoSegment> list = getVideoSegments();
			for (VideoSegment vs : s3VideoSegments()) {
				if (!list.contains(vs)) {
					list.add(vs);
				}
			}
			response = new ListVideoSegmentsResponse(list, 200);
		} catch (Exception e) {
			response = new ListVideoSegmentsResponse(403, e.getMessage());
		}
		
		return response;
	}
 }
