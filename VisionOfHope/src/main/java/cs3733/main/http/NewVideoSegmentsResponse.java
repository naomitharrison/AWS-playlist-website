package cs3733.main.http;

public class NewVideoSegmentsResponse {
	public final String name;
	public final int statusCode;
	public final String error;

	public NewVideoSegmentsResponse(String name, int statusCode) {
		this.name = name;
		this.statusCode = statusCode;
		this.error = "";
	}

	public NewVideoSegmentsResponse(String name, int statusCode, String errorMessage) {
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
