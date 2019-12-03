package cs3733.main.http;

public class VideoSegmentSearchResponse {
	public  String search;
	public  int statusCode;
	public String error;
	
	public VideoSegmentSearchResponse() {
		
	}

	public VideoSegmentSearchResponse(String s, int statusCode) {
		this.search = s;
		this.statusCode = statusCode;
		this.error = "";
	}

	public VideoSegmentSearchResponse(String s, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.search = s;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "RemoteLibraryAddResponse(" + search + ")";
		} else {
			return "RemoteLibraryAddResponseError(" + search + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}
}
