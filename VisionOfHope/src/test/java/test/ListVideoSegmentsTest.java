package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import main.ListVideoSegmentsHandler;
import main.http.ListVideoSegmentsResponse;
import main.model.VideoSegment;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListVideoSegmentsTest extends LambdaTest {
	
    @Test
    public void testGetListDatabase() throws IOException {
    	ListVideoSegmentsHandler handler = new ListVideoSegmentsHandler();

    	ListVideoSegmentsResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasVideo = false;
        
        for (VideoSegment vs : resp.list) {
        	System.out.println(vs.toString());
        }
        for (VideoSegment vs : resp.list) {
        	if (vs.getTitle().equals("It will be out secret")) { hasVideo = true; break; }
        }
        assertTrue(hasVideo);
        assertEquals(200, resp.statusCode);
    }
    
    @Test
    public void testGetListS3() throws IOException {
    	ListVideoSegmentsHandler handler = new ListVideoSegmentsHandler();

    	ListVideoSegmentsResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasVideo = false;
        
        for (VideoSegment vs : resp.list) {
        	System.out.println(vs.toString());
        }
        for (VideoSegment vs : resp.list) {
        	if (vs.getTitle().equals("definitely not humanoid, Captain.ogg")) { hasVideo = true; break; }
        }
        assertTrue(hasVideo);
        assertEquals(200, resp.statusCode);
    }

}
