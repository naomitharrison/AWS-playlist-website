package main.http;

import java.util.ArrayList;
import java.util.List;

import main.model.VideoSegment;

public class ListVideoSegmentsResponse {

	public final List<VideoSegment> list;
	public final int statusCode;
	public final String error;
	
	
	public ListVideoSegmentsResponse(List<VideoSegment> list, int code) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}

	public ListVideoSegmentsResponse(int code, String errorMessage) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<VideoSegment>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if(list==null) {
			return "EmptyVideoSegments";
		}
		return "AllVideoSegments(" + list.size() + ")";
	}

}
