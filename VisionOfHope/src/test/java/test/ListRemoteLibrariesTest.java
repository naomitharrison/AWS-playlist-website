package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListRemoteLibraryHandler;
import cs3733.main.RemoteLibraryAddHandler;
import cs3733.main.RemoteLibraryRemoveHandler;
import cs3733.main.http.ListRemoteLibrariesResponse;
import cs3733.main.http.RemoteLibraryAddRequest;
import cs3733.main.http.RemoteLibraryAddResponse;
import cs3733.main.http.RemoteLibraryRemoveRequest;
import cs3733.main.http.RemoteLibraryRemoveResponse;
import cs3733.main.model.RemoteLib;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListRemoteLibrariesTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	
    	RemoteLibraryAddHandler addHandler = new RemoteLibraryAddHandler();
    	RemoteLibraryAddRequest addRequest = new RemoteLibraryAddRequest("test","test");
    	RemoteLibraryAddResponse addResponse = addHandler.handleRequest(addRequest, createContext("name"));
    	
    	
    	ListRemoteLibraryHandler handler = new ListRemoteLibraryHandler();

    	ListRemoteLibrariesResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasLib = false;
        for (RemoteLib rl : resp.list) {
        	if (rl.getName().equals("test")) { hasLib = true; break; }
        }
        assertTrue(hasLib);
        assertEquals(200, resp.statusCode);
        assertEquals(200, addResponse.statusCode);
        
        RemoteLibraryRemoveHandler removeHandler = new RemoteLibraryRemoveHandler();
    	RemoteLibraryRemoveRequest removeRequest = new RemoteLibraryRemoveRequest("test","test");
    	RemoteLibraryRemoveResponse removeResponse = removeHandler.handleRequest(removeRequest, createContext("name"));
    	
    	
    	ListRemoteLibraryHandler handler2 = new ListRemoteLibraryHandler();

    	ListRemoteLibrariesResponse resp2 = handler2.handleRequest(null, createContext("list"));
        
        boolean noLongerHasLib = true;
        for (RemoteLib rl : resp2.list) {
        	if (rl.getName().equals("test")) { noLongerHasLib = false; break; }
        }
        
        assertTrue(noLongerHasLib);
        assertEquals(200, resp2.statusCode);
        assertEquals(200, removeResponse.statusCode);
    }

}
