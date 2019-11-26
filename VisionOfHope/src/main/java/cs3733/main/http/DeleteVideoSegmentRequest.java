package cs3733.main.http;

public class DeleteVideoSegmentRequest {
	final String url;
	
	public String getURL() {return url; }
	
	public DeleteVideoSegmentRequest (String link) {
		this.url = link;
	}

}
