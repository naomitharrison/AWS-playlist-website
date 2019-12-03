package cs3733.main.http;

public class NewPlaylistResponse {

	public  String name;
	public int statusCode;
	public  String error;
	
	public NewPlaylistResponse() {
		
	}

	public NewPlaylistResponse(String name, int statusCode) {
		this.name = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public NewPlaylistResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.name = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "NewPlaylistResponse(" + name + ")";
		} else {
			return "NewPlaylistErrorResult(" + name + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}

}
