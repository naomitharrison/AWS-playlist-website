package cs3733.main.http;

public class AppendPlaylistRequest {
	
	

	String name;
	String url;
	
	public AppendPlaylistRequest() {
		
	}
	
	public String getName() {return name; }
	public String getUrl() {return url; }
	
	public AppendPlaylistRequest (String name, String url) {
		this.name = name;
		this.url = url;
	}

	public void setPlaylistName(String name) {
		this.name = name;
	}

	public void setVideoURL(String url) {
		this.url = url;
	}

}
