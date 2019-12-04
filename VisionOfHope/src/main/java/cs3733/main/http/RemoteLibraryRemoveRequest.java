package cs3733.main.http;

public class RemoteLibraryRemoveRequest {
	 String name;
	 String url;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {return name; }
	public String getUrl() {return url; }
	
	public RemoteLibraryRemoveRequest() {
		
	}
	
	public RemoteLibraryRemoveRequest (String name, String url) {
		this.name = name;
		this.url = url;
	}

}
