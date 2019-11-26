package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListPlaylistsHandler;
import cs3733.main.ListVideoSegmentsHandler;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.http.ListVideoSegmentsResponse;
import cs3733.main.model.Playlist;
import cs3733.main.model.VideoSegment;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListPlaylistsTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListPlaylistsHandler handler = new ListPlaylistsHandler();

    	ListPlaylistResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasPlaylist = false;
        for (Playlist p : resp.list) {
        	if (p.getName().equals("test name")) { hasPlaylist = true; break; }
        }
        assertTrue(hasPlaylist);
        assertEquals(200, resp.statusCode);
    }

}
