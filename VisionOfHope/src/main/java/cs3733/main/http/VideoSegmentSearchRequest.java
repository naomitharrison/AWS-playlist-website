package cs3733.main.http;

public class VideoSegmentSearchRequest {
	String character;
	String string;
	
	public String getCharacter() {return character; }
	public String getString() {return string; }
	public String getSearch() { 
		String response;
		response = character + " , " + string;
		return response;
	}
	
	public VideoSegmentSearchRequest () {
		
	}
	
	public VideoSegmentSearchRequest (String ch, String st) {
		this.character = ch;
		this.string = st;
	}

}
