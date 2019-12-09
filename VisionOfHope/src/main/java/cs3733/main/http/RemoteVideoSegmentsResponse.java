package cs3733.main.http;

import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.VideoSegment;

public class RemoteVideoSegmentsResponse {

	public  List<VideoSegment> segments;
	public  int statusCode;
	public  String error;
	
	public RemoteVideoSegmentsResponse() {
		
	}
	
	public RemoteVideoSegmentsResponse(List<VideoSegment> segments, int code) {
		// TODO Auto-generated constructor stub
		this.segments = segments;
		this.statusCode = code;
		this.error = "";
	}

	public RemoteVideoSegmentsResponse(int code, String errorMessage) {
		// TODO Auto-generated constructor stub
		this.segments = new ArrayList<VideoSegment>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if(segments==null) {
			return "EmptyRemoteVideoSegments";
		}
		return "RemoteVideoSegments(" + segments.size() + ")";
	}

}
