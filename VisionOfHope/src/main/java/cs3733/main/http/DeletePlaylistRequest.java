package cs3733.main.http;

public class DeletePlaylistRequest {
	final String name;
	
	public String getName() {return name; }
	
	public DeletePlaylistRequest (String n) {
		this.name = n;
	}
}
