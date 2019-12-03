package cs3733.main.http;

public class DeletePlaylistVideoSegmentRequest {
	String playlistName;
	String videoURL;
	
	public String getPlaylistName() {return playlistName; }
	public String getVideoURL() {return videoURL; }
	
	public DeletePlaylistVideoSegmentRequest () {
		
	}
	
	public DeletePlaylistVideoSegmentRequest (String name, String url) {
		this.playlistName = name;
		this.videoURL = url;
	}


}
