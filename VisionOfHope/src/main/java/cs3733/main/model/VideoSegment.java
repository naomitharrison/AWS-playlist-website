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

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof VideoSegment))
			return false;
		VideoSegment other = (VideoSegment) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (remoteAvailability == null) {
			if (other.remoteAvailability != null)
				return false;
		} else if (!remoteAvailability.equals(other.remoteAvailability))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}*/
}
