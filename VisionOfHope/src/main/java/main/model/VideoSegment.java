package main.model;

public class VideoSegment {

	String title;
	String character;
	// Is the ogg filename
	String filename;
	Boolean remoteAvaliability;
	
	public VideoSegment(String title, String character, String filename) {
		this.title = title;
		this.character = character;
		this.filename = filename;
		this.remoteAvaliability = true;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getCharacter() {
		return this.character;
	}
	
	public String getFile() {
		return this.filename;
	}
	
	public Boolean getAvaiability(){
		return this.remoteAvaliability;
	}
	
	// toggles remote availability of videos
	public void setAvaliability() {
		if(this.remoteAvaliability = true) {
			this.remoteAvaliability = false;
		}
		else {
			this.remoteAvaliability = true;
		}
	}
}
