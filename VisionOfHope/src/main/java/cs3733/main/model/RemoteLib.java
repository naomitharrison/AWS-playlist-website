package cs3733.main.model;

import java.util.ArrayList;

public class RemoteLib {
	
	String url;
	String name;

	public RemoteLib(String name, String url) {
		this.name = name;
		this.url =url;		
	}
	
	public String getName() {
		return this.name;
	}
	public String getUrl() {
		return url;
	}
	

	
	
}
