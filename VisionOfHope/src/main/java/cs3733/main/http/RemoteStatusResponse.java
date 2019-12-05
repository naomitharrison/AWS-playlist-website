package cs3733.main.http;

public class RemoteStatusResponse {
	
	public int statusCode;
	public String error;
	public String[] urls;

	public RemoteStatusResponse() {
		
	}
	
	public RemoteStatusResponse(String[] urls, int statusCode) {
		this.urls = urls;
		this.statusCode = statusCode;
		this.error = "";
	}

	public RemoteStatusResponse(String[] urls, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.urls = urls;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "RemoteStatusResponse(" + urls + ")";
		} else {
			return "RemoteStatusResponseError(" + urls + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}

}
