package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListRemoteLibraryHandler;
import cs3733.main.RemoteLibraryAddHandler;
import cs3733.main.RemoteLibraryRemoveHandler;
import cs3733.main.http.ListRemoteLibrariesRequest;
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
    	
    	ListRemoteLibraryHandler handler = new ListRemoteLibraryHandler();
    	ListRemoteLibrariesRequest req = new ListRemoteLibrariesRequest();
    	ListRemoteLibrariesResponse resp = handler.handleRequest(req, createContext("list"));
        
        boolean hasLib = false;
        System.out.println("list: "+resp.list);
        for (RemoteLib rl : resp.list) {
        	if (rl.getName().equals("test")) { hasLib = true; break; }
        }
        assertTrue(hasLib);
        assertEquals(200, resp.statusCode);
        
    }

}
