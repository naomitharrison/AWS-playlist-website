package cs3733.main.http;

public class DeletePlaylistVideoSegmentRequest {
	String name;
	String url;
	
	public String getName() {return name; }
	public String getUrl() {return url; }
	
	public DeletePlaylistVideoSegmentRequest () {
		
	}
	
	public DeletePlaylistVideoSegmentRequest (String name, String url) {
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
