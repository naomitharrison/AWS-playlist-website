package cs3733.main.http;

public class NewVideoSegmentsRequest {
	public String title;
	public String character;
	public String base64EncodedValue;
	public boolean remoteAvailability;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getBase64EncodedValue() {
		return base64EncodedValue;
	}

	public void setBase64EncodedValue(String base64EncodedValue) {
		this.base64EncodedValue = base64EncodedValue;
	}

	public boolean isRemoteAvailability() {
		return remoteAvailability;
	}

	public void setRemoteAvailability(boolean remoteAvailability) {
		this.remoteAvailability = remoteAvailability;
	}

	public NewVideoSegmentsRequest() {

	}

	public NewVideoSegmentsRequest(String t, String c, String encode, boolean avail) {
		title = t;
		character = c;
		base64EncodedValue = encode;
		remoteAvailability = avail;
	}

	@Override
	public String toString() {
		return "NewVideoSegmentsRequest (" + title + "," + character + "," + base64EncodedValue + "," + remoteAvailability + ")";
	}
	
}
