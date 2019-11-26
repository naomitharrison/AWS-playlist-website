package main.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractLibrary {
	
	String name;
	ArrayList<VideoSegment> VideoSegments;
	
	public AbstractLibrary(String name) {
		this.name = name;
		this.VideoSegments = new ArrayList<VideoSegment>();
	}

	public ArrayList<VideoSegment> searchbyTitle(String Title) {
		Iterator<VideoSegment> vs = this.VideoSegments.iterator();
		ArrayList<VideoSegment> results = new ArrayList<VideoSegment>();
		while(vs.hasNext()) {
			VideoSegment current = vs.next();
			if(current.title.contains(Title)) {
				results.add(current);
			}
		}
		return results;
	}
	
	public ArrayList<VideoSegment> searchbyCharacter(String Char) {
		Iterator<VideoSegment> vs = this.VideoSegments.iterator();
		ArrayList<VideoSegment> results = new ArrayList<VideoSegment>();
		while(vs.hasNext()) {
			VideoSegment current = vs.next();
			if(current.character.equals(Char)) {
				results.add(current);
			}
		}
		return results;
	}
	
	public ArrayList<VideoSegment> searchbyBoth(String Title ,String Char) {
		Iterator<VideoSegment> vs = this.VideoSegments.iterator();
		ArrayList<VideoSegment> results = new ArrayList<VideoSegment>();
		while(vs.hasNext()) {
			VideoSegment current = vs.next();
			if(current.character.equals(Char) && current.title.contains(Title)) {
				results.add(current);
			}
		}
		return results;
	}

}
