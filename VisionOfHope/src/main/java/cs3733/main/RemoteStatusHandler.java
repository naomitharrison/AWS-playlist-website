package cs3733.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Array;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.databind.JsonNode;

import cs3733.main.DB.VideoSegmentsDAO;
import cs3733.main.http.RemoteStatusRequest;
import cs3733.main.http.RemoteStatusResponse;

public class RemoteStatusHandler implements RequestStreamHandler {

	public LambdaLogger logger = null;

//	@Override
//	public RemoteStatusResponse handleRequest(RemoteStatusRequest req, Context context) {
//		logger = context.getLogger();
//		logger.log("Loading Java Lambda handler to change remote availability: " + req.getVideoUrls());
//
////		RemoteLibraryAddResponse response = null;
////		logger.log(req.toString());
//
//		VideoSegmentsDAO dao = new VideoSegmentsDAO();
//
//		RemoteStatusResponse response;
//		
//		try {
//			boolean working = true;
//			for(int i =0; i<req.getVideoUrls().length; i++) {
//				String url = req.getVideoUrls()[i];
//				boolean available = req.getCheckboxes()[i];
//				boolean changed = dao.changeRemoteAvail(url,available);	
//				if (changed == false) {working = false; break;}
//			}
//			if (working) {
//				response = new RemoteStatusResponse(req.getVideoUrls(), 200);
//			} else {
//				response = new RemoteStatusResponse(req.getVideoUrls(), 422, "Unable to change remote status.");
//			}
//		} catch (Exception e) {
//			response = new RemoteStatusResponse(req.getVideoUrls(), 403,
//					"Unable to change remote status: " + req.getVideoUrls() + "(" + e.getMessage() + ")");
//		}
//
//		return response;
//	}

	@Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
    	logger = context.getLogger();
    	if (context != null) { context.getLogger(); }
    	
    	// load entire input into a String (since it contains JSON)
    	StringBuilder incoming = new StringBuilder();
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
    		String line = null;
    		while ((line = br.readLine()) != null) {
    			incoming.append(line);
    		}
    	}
    	
    	// When coming in from Lambda function is pure JSON. When coming from API Gateway or the
    	// real thing, then is wrapped inside more complicated JSON and you only want the BODY
    	// in most cases.
        JsonNode node = Jackson.fromJsonString(incoming.toString(), JsonNode.class);
        
        if (node.has("body")) {
        	node = Jackson.fromJsonString(node.get("body").asText(), JsonNode.class);
        }
        
    	boolean[] checkboxes;
    	String[] videoUrls;
    	
    	String param = node.get("checkboxes").asText();
    	boolean error = false;
		try {
			checkboxes = Double.parseDouble(param); //yeah ok but how do i get an array of boolean?
    	}
    	
		param = node.get("videoUrls").asText();
		try {
			videoUrls = param; //turn array of strings(?? how does this output?) into multiple strings
    	}

		VideoSegmentsDAO dao = new VideoSegmentsDAO();

//		RemoteStatusResponse response;
		int statusCode;
		
		try {
			boolean working = true;
			for(int i =0; i<videoUrls.length; i++) {
				String url = videoUrls[i];
				boolean available = checkboxes[i];
				boolean changed = dao.changeRemoteAvail(url,available);	
				if (changed == false) {working = false; break;}
			}
			if (working) {
//			response = new RemoteStatusResponse(videoUrls, 200);
			statusCode = 200;
			} 
			else {
//			response = new RemoteStatusResponse(videoUrls, 422, "Unable to change remote status.");
			statusCode = 422;
			}
		} 
		catch (Exception e) {
//			response = new RemoteStatusResponse(videoUrls, 403, "Unable to change remote status: " + videoUrls + "(" + e.getMessage() + ")");
			statusCode = 403;
		}
		
	//return response;
	
	PrintWriter pw = new PrintWriter(output);

	// Needed for CORS integration...
	String response = "{ \n" + "  \"isBase64Encoded\" : false, \n" + "  \"statusCode\"      : " + statusCode + ", \n"
			+ "  \"headers\" : { \n " + "     \"Access-Control-Allow-Origin\" : \"*\", \n"
			+ "     \"Access-Control-Allow-Method\"  : \"GET,POST,OPTIONS\" \n" + "  }, \n" + "  \"body\" : \""
			+ "{ \\\"result\\\" : \\\"" + videoUrls + "\\\" }" + "\" \n" + "}"; //videoUrls seems like the wrong thing to put here

	// write out.
	pw.print(response);pw.close(); //is this gonna send the information?? i dont understand how it works
	}

}
