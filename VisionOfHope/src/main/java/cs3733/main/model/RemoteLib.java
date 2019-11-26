package cs3733.main.model;

public class RemoteLib extends AbstractLibrary {
	
	String url;

	public RemoteLib(String name, String url) {
		super(name);
		this.url =url;		
	}
	
	public String getName() {
		return this.name;
	}
	
}
