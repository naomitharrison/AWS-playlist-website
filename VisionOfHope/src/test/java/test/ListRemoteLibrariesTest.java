package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListPlaylistsHandler;
import cs3733.main.ListRemoteLibraryHandler;
import cs3733.main.NewPlaylistHandler;
import cs3733.main.RemoteLibraryAddHandler;
import cs3733.main.RemoteLibraryRemoveHandler;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.http.ListRemoteLibrariesRequest;
import cs3733.main.http.ListRemoteLibrariesResponse;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.http.RemoteLibraryAddRequest;
import cs3733.main.http.RemoteLibraryAddResponse;
import cs3733.main.http.RemoteLibraryRemoveRequest;
import cs3733.main.http.RemoteLibraryRemoveResponse;
import cs3733.main.model.Playlist;
import cs3733.main.model.RemoteLib;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListRemoteLibrariesTest extends LambdaTest {

	@Test
	public void testGetList() throws IOException {

		ListRemoteLibraryHandler handler = new ListRemoteLibraryHandler();
		ListRemoteLibrariesRequest req = new ListRemoteLibrariesRequest();
		ListRemoteLibrariesResponse resp = handler.handleRequest(req, createContext("list"));

		boolean hasLib = false;
		System.out.println("list: " + resp.list);
		for (RemoteLib rl : resp.list) {
			if (rl.getName().equals("test")) {
				hasLib = true;
				break;
			}
		}
		assertTrue(hasLib);
		assertEquals(200, resp.statusCode);

	}

	@Test
	public void testAddAndRemove() throws IOException {
		createRemoteLib();
		removeRemoteLib();

	}

	private void createRemoteLib() {
		RemoteLibraryAddHandler addHandler = new RemoteLibraryAddHandler();

		RemoteLibraryAddRequest addRequest = new RemoteLibraryAddRequest("testLibName", "testLibURL");
		RemoteLibraryAddResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListRemoteLibraryHandler listHandler = new ListRemoteLibraryHandler();
		ListRemoteLibrariesResponse listResp = listHandler.handleRequest(null, createContext("list"));

		boolean hasLib = false;
		for (RemoteLib rl : listResp.list) {
			if (rl.getName().equals(addRequest.getName())) {
				hasLib = true;
				break;
			}
		}

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasLib);

	}

	private void removeRemoteLib() {
		RemoteLibraryRemoveHandler removeHandler = new RemoteLibraryRemoveHandler();

		RemoteLibraryRemoveRequest removeRequest = new RemoteLibraryRemoveRequest("testLibURL");
		RemoteLibraryRemoveResponse removeResp = removeHandler.handleRequest(removeRequest, createContext("name"));

		ListRemoteLibraryHandler listHandler = new ListRemoteLibraryHandler();
		ListRemoteLibrariesResponse listResp = listHandler.handleRequest(null, createContext("list"));

		boolean noLongerHasLib = true;
		for (RemoteLib rl : listResp.list) {
			if (rl.getUrl().equals(removeRequest.getUrl())) {
				noLongerHasLib = false;
				break;
			}
		}

		assertEquals(200, removeResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertFalse(noLongerHasLib);
	}

}
