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
	public String getUrl() {
		return url;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof RemoteLib))
			return false;
		RemoteLib other = (RemoteLib) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
}
