package main.model;

import java.util.ArrayList;
import java.util.Iterator;

public class LocalLib extends AbstractLibrary {
	static String name = "LocalLibrary";
	ListOfPlaylist playlists;

	public LocalLib() {
		super(name);
		this.playlists = new ListOfPlaylist();
	}

	public boolean addVideo(VideoSegment vs) {
		if (this.VideoSegments.contains(vs)) {
			return false;
		} else {
			return this.VideoSegments.add(vs);
		}
	}

	public boolean removeVideo(VideoSegment vs) {
		Iterator<Playlist> playlists = this.playlists.playlists.iterator();
		while (playlists.hasNext()) {
			Playlist current = playlists.next();
			if (current.playlistVideos.contains(vs))
				current.removeEntry(vs);
		}
		return this.VideoSegments.remove(vs);
	}

	// toggles remote availability of a specified VideoSegment in LocalLib
	public void markVideo(VideoSegment vs) {
		Iterator<VideoSegment> videos = this.VideoSegments.iterator();
		while (videos.hasNext()) {
			VideoSegment current = videos.next();
			if (current == vs) {
				current.setAvaliability();
			}
		}
	}

	public ArrayList<VideoSegment> getVideos() {
		return this.VideoSegments;
	}
}
