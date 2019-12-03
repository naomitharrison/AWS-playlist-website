package cs3733.main.http;

public class AppendPlaylistResponse {
	public  String playlistName;
	public  int statusCode;
	public  String error;
	
	public AppendPlaylistResponse() {
		
	}
	
	public AppendPlaylistResponse(String name, int statusCode) {
		this.playlistName = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public AppendPlaylistResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.playlistName = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "AppendPlaylistResponse(" + playlistName + ")";
		} else {
			return "AppendPlaylistErrorResult(" + playlistName + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}


}
