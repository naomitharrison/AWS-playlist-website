package cs3733.main.http;

public class ListPlaylistVideoSegmentsRequest {

	public String playlistName;
	
	public String getPlaylistName( ) { return playlistName; }
	
	public ListPlaylistVideoSegmentsRequest (String name) {
		this.playlistName = name;
	}

	public String toString() {
		return "CreateConstant(" + playlistName  + ")";
	}
}
