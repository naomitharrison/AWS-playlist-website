package cs3733.main.http;

public class AppendPlaylistRequest {
	
	

	String name;
	String videoUrl;
	
	public AppendPlaylistRequest() {
		
	}
	
	public String getName() {return name; }
	public String getVideoUrl() {return videoUrl; }
	
	public AppendPlaylistRequest (String name, String videoUrl) {
		this.name = name;
		this.videoUrl = videoUrl;
	}

	public void setPlaylistName(String name) {
		this.name = name;
	}

	public void setVideoURL(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}
