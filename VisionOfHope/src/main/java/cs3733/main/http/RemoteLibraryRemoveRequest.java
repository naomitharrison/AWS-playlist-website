package cs3733.main.http;

public class RemoteLibraryRemoveRequest {
	 String name;
	 String URL;
	
	public String getName() {return name; }
	public String getURL() {return URL; }
	
	public RemoteLibraryRemoveRequest() {
		
	}
	
	public RemoteLibraryRemoveRequest (String name, String url) {
		this.name = name;
		this.URL = url;
	}

}
