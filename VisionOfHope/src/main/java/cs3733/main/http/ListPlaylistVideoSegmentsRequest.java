package cs3733.main.http;

public class ListPlaylistVideoSegmentsRequest {

	String name;
	
	public String getName( ) { return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ListPlaylistVideoSegmentsRequest (String name) {
		this.name = name;
	}
	
	public ListPlaylistVideoSegmentsRequest() {
		
	}

	public String toString() {
		return "ListPlaylistVideoSegments(" + name  + ")";
	}
}
