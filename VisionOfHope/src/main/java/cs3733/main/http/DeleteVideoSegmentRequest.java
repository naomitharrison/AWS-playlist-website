package cs3733.main.http;

public class DeleteVideoSegmentRequest {
	String url;
	
	public String getURL() {return url; }
	
	public DeleteVideoSegmentRequest () {
		
	}
	
	public DeleteVideoSegmentRequest (String link) {
		this.url = link;
	}

}
