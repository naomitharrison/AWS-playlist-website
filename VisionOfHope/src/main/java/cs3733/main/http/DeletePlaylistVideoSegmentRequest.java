package cs3733.main.http;

public class DeletePlaylistVideoSegmentRequest {
	String playlistName;
	String videoUrl;
	
	public String getplaylistName() {return playlistName; }
	public String getvideoUrl() {return videoUrl; }
	
	public DeletePlaylistVideoSegmentRequest () {
		
	}
	
	public DeletePlaylistVideoSegmentRequest (String name, String url) {
		this.playlistName = name;
		this.videoUrl = url;
	}
	public void setPlaylistName(String name) {
		this.playlistName = name;
	}
	public void setVideoURL(String url) {
		this.videoUrl = url;
	}


}
