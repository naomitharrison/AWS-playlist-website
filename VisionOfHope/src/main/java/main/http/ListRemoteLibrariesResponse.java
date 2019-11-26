package main.http;

import java.util.ArrayList;
import java.util.List;

import main.model.Playlist;
import main.model.RemoteLib;
import main.model.VideoSegment;

public class ListRemoteLibrariesResponse {

	public final List<RemoteLib> list;
	public final int statusCode;
	public final String error;
	
	public String toString() {
		if(list==null) {
			return "EmptyRemoteLib";
		}
		return "AllRemoteLib(" + list.size() + ")";
	}

	public ListRemoteLibrariesResponse(List<RemoteLib> list, int code) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}

	public ListRemoteLibrariesResponse(int code, String message) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<RemoteLib>();
		this.statusCode = code;
		this.error = message;
	}

}
