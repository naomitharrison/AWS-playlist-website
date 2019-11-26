package cs3733.main.http;

public class NewPlaylistRequest {
public String name;
	
	public void setName(String name) {this.name = name; }
	public String getName() {return name; }
	
	public NewPlaylistRequest (String n) {
		this.name = n;
	}
}
