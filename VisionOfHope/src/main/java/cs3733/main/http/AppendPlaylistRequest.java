package cs3733.main.http;

public class AppendPlaylistRequest {
	final String playlistName;
	final String videoURL;
	
	public String getPlaylistName() {return playlistName; }
	public String getVideoURL() {return videoURL; }
	
	public AppendPlaylistRequest (String name, String url) {
		this.playlistName = name;
		this.videoURL = url;
	}

}
