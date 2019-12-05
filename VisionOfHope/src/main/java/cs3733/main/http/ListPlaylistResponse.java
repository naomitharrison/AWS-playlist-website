package cs3733.main.http;

import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.Playlist;

public class ListPlaylistResponse {
	public  List<Playlist> list;
	public  int statusCode;
	public  String error;
	
	public ListPlaylistResponse() {
		
	}

	public ListPlaylistResponse(List<Playlist> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}

	public ListPlaylistResponse(int code, String errorMessage) {
		this.list = new ArrayList<Playlist>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyConstants"; }
		return "AllConstants(" + list.size() + ")";
	}
	
}
