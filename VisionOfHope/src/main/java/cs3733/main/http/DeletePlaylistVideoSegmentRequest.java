package cs3733.main.http;

public class DeletePlaylistVideoSegmentRequest {
	String playlistName;
	String videoUrl;
	
	public String getPlaylistName() {return playlistName; }
	public String getVideoUrl() {return videoUrl; }
	
	public DeletePlaylistVideoSegmentRequest () {
		
	}
	
	public DeletePlaylistVideoSegmentRequest (String playlistName, String videoUrl) {
		this.playlistName = playlistName;
		this.videoUrl = videoUrl;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}


}
