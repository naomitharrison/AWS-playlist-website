package cs3733.main.http;

public class RemoteLibraryRemoveRequest {
	 String url;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {return url; }
	
	public RemoteLibraryRemoveRequest() {
		
	}
	
	public RemoteLibraryRemoveRequest (String url) {
		this.url = url;
	}

}
