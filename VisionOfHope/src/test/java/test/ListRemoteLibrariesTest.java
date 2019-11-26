package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListRemoteLibraryHandler;
import cs3733.main.http.ListRemoteLibrariesResponse;
import cs3733.main.model.RemoteLib;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListRemoteLibrariesTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListRemoteLibraryHandler handler = new ListRemoteLibraryHandler();

    	ListRemoteLibrariesResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasLib = false;
        for (RemoteLib rl : resp.list) {
        	if (rl.getName().equals("test")) { hasLib = true; break; }
        }
        assertTrue(hasLib);
        assertEquals(200, resp.statusCode);
    }

}
