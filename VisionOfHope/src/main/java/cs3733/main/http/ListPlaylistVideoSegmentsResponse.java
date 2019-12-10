package cs3733.main.http;

import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.VideoSegment;

public class ListPlaylistVideoSegmentsResponse {
	public  List<String> list;
	public  int statusCode;
	public  String error;
	
	public ListPlaylistVideoSegmentsResponse() {
		
	}
	
	public ListPlaylistVideoSegmentsResponse(List<String> list, int code) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}

	public ListPlaylistVideoSegmentsResponse(int code, String errorMessage) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<String>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if(list==null) {
			return "EmptyPlaylistVideoSegments";
		}
		return "AllPlaylistVideoSegments(" + list.size() + ")";
	}


}
