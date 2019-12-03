package cs3733.main.http;

import java.util.List;

import cs3733.main.model.VideoSegment;

public class VideoSegmentSearchResponse {
	List<VideoSegment> searchResult;
	public  int statusCode;
	public String error;
	
	public VideoSegmentSearchResponse() {
		
	}

	public VideoSegmentSearchResponse(List<VideoSegment> s, int statusCode) {
		this.searchResult = s;
		this.statusCode = statusCode;
		this.error = "";
	}

	public VideoSegmentSearchResponse(List<VideoSegment> s, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.searchResult = s;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "RemoteLibraryAddResponse(" + searchResult + ")";
		} else {
			return "RemoteLibraryAddResponseError(" + searchResult + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}
}
