package cs3733.main.http;

public class RemoteLibraryAddRequest {
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
	
	public RemoteLibraryAddRequest() {
		
	}
	
	public RemoteLibraryAddRequest (String name, String url) {
		this.name = name;
		this.url = url;
	}

}
