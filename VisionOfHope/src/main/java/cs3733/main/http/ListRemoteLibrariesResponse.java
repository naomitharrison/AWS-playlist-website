package cs3733.main.http;

import java.util.ArrayList;
import java.util.List;

import cs3733.main.model.Playlist;
import cs3733.main.model.RemoteLib;
import cs3733.main.model.VideoSegment;

public class ListRemoteLibrariesResponse {

	public  List<RemoteLib> list;
	public  int statusCode;
	public  String error;
	
	public String toString() {
		if(list==null) {
			return "EmptyRemoteLib";
		}
		return "AllRemoteLib(" + list.size() + ")";
	}
	public ListRemoteLibrariesResponse() {
		
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
