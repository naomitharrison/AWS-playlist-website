package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.ListPlaylistsHandler;
import cs3733.main.ListVideoSegmentsHandler;
import cs3733.main.NewPlaylistHandler;
import cs3733.main.NewVideoSegmentsHandler;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.http.ListVideoSegmentsResponse;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.http.NewVideoSegmentsRequest;
import cs3733.main.http.NewVideoSegmentsResponse;
import cs3733.main.model.*;

public class AddAndDelete extends LambdaTest {

	@Test
	public void VideoSegment() {
    	NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
    	
    	for (VideoSegment vs : listResp.list) {
        	System.out.println(vs.toString());
        }
    	
        boolean hasVideo = false;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { hasVideo = true; break; }
        }
        
        assertEquals(200, addResp.statusCode);
        assertEquals(200, listResp.statusCode);
        assertTrue(hasVideo);
        
        
        NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
    	
        boolean noLongerHasVideo = true;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { noLongerHasVideo = false; break; }
        }

        assertEquals(200, deleteResp.statusCode);
        assertEquals(200, listResp2.statusCode);
        assertTrue(noLongerHasVideo);       
    }
	
	@Test
	public void Playlist() {
    	NewPlaylistHandler addHandler = new NewPlaylistHandler();

    	NewPlaylistRequest addRequest = new NewPlaylistRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
        
    	ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
    	ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));
    	
    	for (Playlist p : listResp.list) {
        	System.out.println(p.toString());
        }
    	
        boolean hasVideo = false;
    	for (Playlist p : listResp.list) {
        	if (p.getName().equals("testTitle")) { hasVideo = true; break; }
        }
        
        assertEquals(200, addResp.statusCode);
        assertEquals(200, listResp.statusCode);
        assertTrue(hasVideo);
        
        
        NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
    	
        boolean noLongerHasVideo = true;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { noLongerHasVideo = false; break; }
        }

        assertEquals(200, deleteResp.statusCode);
        assertEquals(200, listResp2.statusCode);
        assertTrue(noLongerHasVideo);       
    }
	
	@Test
	public void PlaylistVideoSegment() {
    	NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
    	
    	for (VideoSegment vs : listResp.list) {
        	System.out.println(vs.toString());
        }
    	
        boolean hasVideo = false;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { hasVideo = true; break; }
        }
        
        assertEquals(200, addResp.statusCode);
        assertEquals(200, listResp.statusCode);
        assertTrue(hasVideo);
        
        
        NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
    	
        boolean noLongerHasVideo = true;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { noLongerHasVideo = false; break; }
        }

        assertEquals(200, deleteResp.statusCode);
        assertEquals(200, listResp2.statusCode);
        assertTrue(noLongerHasVideo);       
    }
	
	@Test
	public void RemoteLibs() {
    	NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
    	
    	for (VideoSegment vs : listResp.list) {
        	System.out.println(vs.toString());
        }
    	
        boolean hasVideo = false;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { hasVideo = true; break; }
        }
        
        assertEquals(200, addResp.statusCode);
        assertEquals(200, listResp.statusCode);
        assertTrue(hasVideo);
        
        
        NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

    	NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
    	NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
        
    	ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
    	ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
    	
        boolean noLongerHasVideo = true;
        for (VideoSegment vs : listResp.list) {
        	if (vs.getTitle().equals("testTitle")) { noLongerHasVideo = false; break; }
        }

        assertEquals(200, deleteResp.statusCode);
        assertEquals(200, listResp2.statusCode);
    }

}
