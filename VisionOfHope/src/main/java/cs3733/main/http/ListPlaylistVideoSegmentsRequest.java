package cs3733.main.http;

public class ListPlaylistVideoSegmentsRequest {

	String playlistName;
	
	public String getPlaylistName( ) { return playlistName; }
	
	public ListPlaylistVideoSegmentsRequest (String name) {
		this.playlistName = name;
	}
	
	public ListPlaylistVideoSegmentsRequest() {
		
	}

	public String toString() {
		return "CreateConstant(" + playlistName  + ")";
	}
}
