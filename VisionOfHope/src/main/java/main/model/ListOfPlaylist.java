package main.model;

import java.util.ArrayList;

public class ListOfPlaylist {
	
	ArrayList<Playlist> playlists;
	
	public ListOfPlaylist() {
		this.playlists = new ArrayList<Playlist>();
	}
	
	public boolean addPlaylist(Playlist playlist) {
		return this.playlists.add(playlist);
	}
	
	public boolean removePlaylist(Playlist playlist) {
		return this.playlists.remove(playlist);
	}
	
	public ArrayList<Playlist> getPlaylists() {
		return this.playlists;
	}

}
