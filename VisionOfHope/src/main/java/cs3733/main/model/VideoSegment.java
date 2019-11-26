package cs3733.main.model;

public class VideoSegment {

	

	String title;
	String character;
	// Is the ogg filename
	String url;
	Boolean remoteAvailability;
	
	public VideoSegment(String title, String character, String url) {
		this.title = title;
		this.character = character;
		this.url = url;
		this.remoteAvailability = true;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getCharacter() {
		return this.character;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public Boolean getAvailability(){
		return this.remoteAvailability;
	}
	
	public Boolean equalsVideoSegment(VideoSegment vs) {
		return this.equals(vs);
	}
	
	// toggles remote availability of videos
	public void setAvailability() {
		if(this.remoteAvailability = true) {
			this.remoteAvailability = false;
		}
		else {
			this.remoteAvailability = true;
		}
	}
	
	@Override
	public String toString() {
		return "VideoSegment [title=" + title + ", character=" + character + ", url=" + url
				+ ", remoteAvailability=" + remoteAvailability + "]";
	}
}
