package cs3733.main.http;

public class NewPlaylistRequest {
	final String name;
	
	public String getName() {return name; }
	
	public NewPlaylistRequest (String n) {
		this.name = n;
	}
}
