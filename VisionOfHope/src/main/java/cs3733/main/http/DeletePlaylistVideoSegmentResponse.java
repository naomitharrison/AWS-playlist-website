package cs3733.main.http;

public class DeletePlaylistVideoSegmentResponse {
	public String playlistName;
	public int statusCode;
	public String error;

	public DeletePlaylistVideoSegmentResponse() {
		
	}
	
	public DeletePlaylistVideoSegmentResponse(String name, int statusCode) {
		this.playlistName = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public DeletePlaylistVideoSegmentResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.playlistName = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "DeletePlaylistVideoSegmentResponse(" + playlistName + ")";
		} else {
			return "DeletePlaylistVideoSegmentErrorResult(" + playlistName + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}
}
