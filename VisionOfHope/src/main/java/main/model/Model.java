package main.model;

import java.util.ArrayList;

public class Model {
	LocalLib localLibrary;
	ArrayList<RemoteLib> remoteLibraries;

	public Model() {
		this.localLibrary = new LocalLib();
		this.remoteLibraries = new ArrayList<RemoteLib>();
	}

	public boolean addRemoteLib(RemoteLib rl) {
		if (this.remoteLibraries.contains(rl)) {
			return false;
		} 
		else {
			return this.remoteLibraries.add(rl);

		}
	}

}
