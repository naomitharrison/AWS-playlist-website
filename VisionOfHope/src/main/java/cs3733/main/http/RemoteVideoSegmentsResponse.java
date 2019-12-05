package cs3733.main.http;

import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.VideoSegment;

public class RemoteVideoSegmentsResponse {

	public  List<VideoSegment> list;
	public  int statusCode;
	public  String error;
	
	public RemoteVideoSegmentsResponse() {
		
	}
	
	public RemoteVideoSegmentsResponse(List<VideoSegment> list, int code) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}

	public RemoteVideoSegmentsResponse(int code, String errorMessage) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<VideoSegment>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if(list==null) {
			return "EmptyRemoteVideoSegments";
		}
		return "RemoteVideoSegments(" + list.size() + ")";
	}

}
