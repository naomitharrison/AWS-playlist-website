package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.RemoteVideoSegmentsHandler;
import cs3733.main.http.RemoteVideoSegmentsRequest;
import cs3733.main.http.RemoteVideoSegmentsResponse;

public class RemoteVideoSegmentsTest extends LambdaTest {

	
	@Test
	public void testRemote() {
		
		
		RemoteVideoSegmentsHandler handle = new RemoteVideoSegmentsHandler();
		RemoteVideoSegmentsRequest req = new RemoteVideoSegmentsRequest();
		RemoteVideoSegmentsResponse res = handle.handleRequest(req,createContext("list"));
		System.out.println("hello");
		System.out.println(res.toString());
		
		//System.out.println(res.segments);
	}
}
