package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs3733.main.ListPlaylistVideoSegmentHandler;
import cs3733.main.http.ListPlaylistVideoSegmentsRequest;
import cs3733.main.http.ListPlaylistVideoSegmentsResponse;
import cs3733.main.model.VideoSegment;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListPlaylistVideoSegmentsTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListPlaylistVideoSegmentHandler handler = new ListPlaylistVideoSegmentHandler();

    	ListPlaylistVideoSegmentsRequest request = new ListPlaylistVideoSegmentsRequest("test");
    	ListPlaylistVideoSegmentsResponse resp = handler.handleRequest(request, createContext("list"));
       
        boolean hasVideo = false;
        
        for (VideoSegment vs : resp.list) {
        	System.out.println(vs.toString());
        }
        for (VideoSegment vs : resp.list) {
        	if (vs.getTitle().equals("Only a god can breathe life into the dead")) { hasVideo = true; break; }
        }
        assertTrue(hasVideo);
        assertEquals(200, resp.statusCode);
    }
    
    @Test
    public void testGetListBadVideo() throws IOException {
    	ListPlaylistVideoSegmentHandler handler = new ListPlaylistVideoSegmentHandler();

    	ListPlaylistVideoSegmentsRequest request = new ListPlaylistVideoSegmentsRequest("test");
    	ListPlaylistVideoSegmentsResponse resp = handler.handleRequest(request, createContext("list"));
       
        boolean hasVideo = false;
        
        for (VideoSegment vs : resp.list) {
        	System.out.println(vs.toString());
        }
        for (VideoSegment vs : resp.list) {
        	if (vs.getTitle().equals("nonexistantTitle")) { hasVideo = true; break; }
        }
        assertFalse(hasVideo);
    }
    
    @Test
    public void testGetListBadPlaylist() throws IOException {
    	ListPlaylistVideoSegmentHandler handler = new ListPlaylistVideoSegmentHandler();

    	ListPlaylistVideoSegmentsRequest request = new ListPlaylistVideoSegmentsRequest("nonexistantPlaylist");
    	ListPlaylistVideoSegmentsResponse resp = handler.handleRequest(request, createContext("list"));
       
        boolean hasVideo = false;
        
        for (VideoSegment vs : resp.list) {
        	System.out.println(vs.toString());
        }
        for (VideoSegment vs : resp.list) {
        	if (vs.getTitle().equals("Only a god can breathe life into the dead")) { hasVideo = true; break; }
        }
        assertFalse(hasVideo);
    }
    

}
