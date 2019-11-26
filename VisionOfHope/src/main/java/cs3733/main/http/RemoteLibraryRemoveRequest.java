package cs3733.main.http;

public class RemoteLibraryRemoveRequest {
	final String name;
	final String URL;
	
	public String getName() {return name; }
	public String getURL() {return URL; }
	
	public RemoteLibraryRemoveRequest (String name, String url) {
		this.name = name;
		this.URL = url;
	}

}
