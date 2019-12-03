package cs3733.main.http;

public class RemoteLibraryAddRequest {
	 String name;
	 String URL;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getName() {return name; }
	public String getURL() {return URL; }
	
	public RemoteLibraryAddRequest() {
		
	}
	
	public RemoteLibraryAddRequest (String name, String url) {
		this.name = name;
		this.URL = url;
	}

}
