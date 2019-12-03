package cs3733.main.http;

public class AppendPlaylistRequest {
	
	

	String playlistName;
	String videoURL;
	
	public AppendPlaylistRequest() {
		
	}
	
	public String getPlaylistName() {return playlistName; }
	public String getVideoURL() {return videoURL; }
	
	public AppendPlaylistRequest (String name, String url) {
		this.playlistName = name;
		this.videoURL = url;
	}

}
