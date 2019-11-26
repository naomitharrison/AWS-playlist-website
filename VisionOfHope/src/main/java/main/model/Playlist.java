package main.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Playlist {

	String name;
	ArrayList<VideoSegment> playlistVideos;
	
	public Playlist(String name) {
		this.name = name;
		this.playlistVideos = new ArrayList<VideoSegment>();
	}
	
	public boolean appendEntry(VideoSegment vs) {
		return this.playlistVideos.add(vs);
	}
	
	public boolean removeEntry(VideoSegment vs) {
		Iterator<VideoSegment> videos = this.playlistVideos.iterator(); 
		Boolean Success = false;
		while(videos.hasNext()) {
			VideoSegment currentVS = videos.next();
			if(currentVS.equals(vs)) {
				videos.remove();
				Success = true;
			}
		}
		return Success;
	}
	
	public ArrayList<VideoSegment> getPlaylistVideos(){
		return this.playlistVideos;
	}
	
	public String getName() {
		return name;
	}
}
