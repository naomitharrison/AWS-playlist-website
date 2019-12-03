package cs3733.main.http;

public class RemoteLibraryRemoveResponse {
	public final String name;
	public final int statusCode;
	public final String error;

	public RemoteLibraryRemoveResponse(String name, int statusCode) {
		this.name = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public RemoteLibraryRemoveResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.name = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "RemoteLibraryRemoveResponse(" + name + ")";
		} else {
			return "RemoteLibraryRemoveErrorResult(" + name + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}
}
