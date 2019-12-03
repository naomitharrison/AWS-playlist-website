package cs3733.main.http;

public class RemoteLibraryAddResponse {
	public  String name;
	public  int statusCode;
	public  String error;

	public RemoteLibraryAddResponse() {
		
	}
	
	public RemoteLibraryAddResponse(String name, int statusCode) {
		this.name = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public RemoteLibraryAddResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.name = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "RemoteLibraryAddResponse(" + name + ")";
		} else {
			return "RemoteLibraryAddResponseError(" + name + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}


}
