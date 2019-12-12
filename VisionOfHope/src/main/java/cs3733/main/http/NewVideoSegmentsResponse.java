package cs3733.main.http;

public class NewVideoSegmentsResponse {
	public String name;
	public int statusCode;
	public String error;

	public NewVideoSegmentsResponse() {}
	
	public NewVideoSegmentsResponse(String name, int statusCode) {
		this.statusCode = 0;
		this.name = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public NewVideoSegmentsResponse(String name, int statusCode, String errorMessage) {
		this.statusCode = 0;
		this.statusCode = statusCode;
		this.error = errorMessage;
		this.name = name;
	}

	public String toString() {
		if (statusCode / 100 == 2) { // too cute?
			return "NewVideoSegmentsResponse(" + name + ")";
		} else {
			return "NewVideoSegmentsResponse(" + name + ", statusCode=" + statusCode + ", err=" + error + ")";
		}
	}
}
