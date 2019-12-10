package cs3733.main.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Playlist {

	String name;
	ArrayList<String> videoURLs;
	
	public Playlist(String name) {
		this.name = name;
		this.videoURLs = new ArrayList<String>();
	}
	
	public boolean appendEntry(String URL) {
		return this.videoURLs.add(URL);
	}
	
	public ArrayList<String> getPlaylistVideos(){
		return this.videoURLs;
	}
	
	public String getName() {
		return name;
	}

/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Playlist))
			return false;
		Playlist other = (Playlist) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playlistVideos == null) {
			if (other.playlistVideos != null)
				return false;
		} else if (!playlistVideos.equals(other.playlistVideos))
			return false;
		return true;
	}*/

	@Override
	public String toString() {
		return "Playlist [name=" + name + ", playlistVideos=" + videoURLs + "]";
	}
}
