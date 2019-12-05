
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.AppendPlaylistHandler;
import cs3733.main.DeletePlaylistHandler;
import cs3733.main.DeletePlaylistVideoSegmentHandler;
import cs3733.main.DeleteVideoSegmentHandler;
import cs3733.main.ListPlaylistVideoSegmentHandler;
import cs3733.main.ListPlaylistsHandler;
import cs3733.main.ListVideoSegmentsHandler;
import cs3733.main.NewPlaylistHandler;
import cs3733.main.NewVideoSegmentsHandler;
import cs3733.main.http.AppendPlaylistRequest;
import cs3733.main.http.AppendPlaylistResponse;
import cs3733.main.http.DeletePlaylistRequest;
import cs3733.main.http.DeletePlaylistResponse;
import cs3733.main.http.DeletePlaylistVideoSegmentRequest;
import cs3733.main.http.DeletePlaylistVideoSegmentResponse;
import cs3733.main.http.DeleteVideoSegmentRequest;
import cs3733.main.http.DeleteVideoSegmentResponse;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.http.ListPlaylistVideoSegmentsRequest;
import cs3733.main.http.ListPlaylistVideoSegmentsResponse;
import cs3733.main.http.ListVideoSegmentsResponse;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.http.NewVideoSegmentsRequest;
import cs3733.main.http.NewVideoSegmentsResponse;
import cs3733.main.model.*;

public class AddDeleteVideoPlaylist extends LambdaTest {

	@Test
	public void VideoSegment() {
		
		createVideo();
		createVidAgain();
		createPlaylist();
		createPlayAgain();
		addToPlaylist();
		deleteFromPlaylist();
		//deleteFromPlaylistAgain();
		deletePlaylist();
		deletePlaylistAgain();
		deleteVideo();
		deleteVideoAgain();
					
	}

	private void deleteVideoAgain() {
		DeleteVideoSegmentHandler deleteHandler = new DeleteVideoSegmentHandler();

		DeleteVideoSegmentRequest deleteRequest = new DeleteVideoSegmentRequest(
				"https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/testTitle.ogg");
		DeleteVideoSegmentResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
		
		assertEquals(422, deleteResp.statusCode);
		
	}

	private void deleteFromPlaylistAgain() {
DeletePlaylistVideoSegmentHandler deleteHandler = new DeletePlaylistVideoSegmentHandler();
		
		DeletePlaylistVideoSegmentRequest deleteRequest = new DeletePlaylistVideoSegmentRequest("testPlaylist","https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/testTitle.ogg");
		DeletePlaylistVideoSegmentResponse deleteResponse = deleteHandler.handleRequest(deleteRequest,createContext("name"));
		
		assertEquals(422, deleteResponse.statusCode);
	}

	private void deletePlaylistAgain() {
		DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();

		DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testPlaylist");
		DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
		
		assertEquals(422, deleteResp.statusCode);
		
	}

	private void deleteVideo() {
		DeleteVideoSegmentHandler deleteHandler = new DeleteVideoSegmentHandler();

		DeleteVideoSegmentRequest deleteRequest = new DeleteVideoSegmentRequest(
				"https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/testTitle.ogg");
		DeleteVideoSegmentResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));

		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}

		boolean noLongerHasVideo = true;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				noLongerHasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(noLongerHasVideo);		
	}

	private void deletePlaylist() {
		DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();

		DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testPlaylist");
		DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
		ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));

		for (Playlist p : listResp.list) {
			System.out.println(p.toString());
		}

		boolean noLongerHasVideo = true;
		for (Playlist p : listResp.list) {
			if (p.getName().equals("testPlaylist")) {
				noLongerHasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(noLongerHasVideo);		
	}

	private void deleteFromPlaylist() {
		DeletePlaylistVideoSegmentHandler deleteHandler = new DeletePlaylistVideoSegmentHandler();
		
		DeletePlaylistVideoSegmentRequest deleteRequest = new DeletePlaylistVideoSegmentRequest("testPlaylist","https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/testTitle.ogg");
		DeletePlaylistVideoSegmentResponse deleteResponse = deleteHandler.handleRequest(deleteRequest,createContext("name"));
		
		ListPlaylistVideoSegmentsRequest listRequest = new ListPlaylistVideoSegmentsRequest("testPlaylist");
		ListPlaylistVideoSegmentHandler listHandler = new ListPlaylistVideoSegmentHandler();
		ListPlaylistVideoSegmentsResponse listResp = listHandler.handleRequest(listRequest, createContext("list"));
		
		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}

		boolean hasVideo = true;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = false;
			}
		}
		
		assertEquals(200, deleteResponse.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);	
		
	}

	private void addToPlaylist() {
		AppendPlaylistHandler appendHandler = new AppendPlaylistHandler();
		
		AppendPlaylistRequest appendRequest = new AppendPlaylistRequest("testPlaylist","https://cs3733visionofhopesurpassed.s3.amazonaws.com/videos/testTitle.ogg");
		AppendPlaylistResponse appendResponse = appendHandler.handleRequest(appendRequest,createContext("name"));
		
		ListPlaylistVideoSegmentsRequest listRequest = new ListPlaylistVideoSegmentsRequest("testPlaylist");
		ListPlaylistVideoSegmentHandler listHandler = new ListPlaylistVideoSegmentHandler();
		ListPlaylistVideoSegmentsResponse listResp = listHandler.handleRequest(listRequest, createContext("list"));
		
		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}

		boolean hasVideo = false;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = true;
			}
		}
		
		assertEquals(200, appendResponse.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);	
	}

	private void createPlaylist() {
		NewPlaylistHandler addHandler = new NewPlaylistHandler();

		NewPlaylistRequest addRequest = new NewPlaylistRequest("testPlaylist");
		NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
		ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));

		/*for (Playlist p : listResp.list) {
			System.out.println(p.toString());
		}*/

		boolean hasVideo = false;
		for (Playlist p : listResp.list) {
			if (p.getName().equals("testPlaylist")) {
				hasVideo = true;
				break;
			}
		}

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);		
	}
	
	private void createPlayAgain(){
		NewPlaylistHandler addHandler = new NewPlaylistHandler();

		NewPlaylistRequest addRequest = new NewPlaylistRequest("testPlaylist");
		NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		assertEquals(422, addResp.statusCode);
	}
	
	private void createVidAgain() {
		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));	
		
		assertEquals(422, addResp.statusCode);

	}

	private void createVideo() {
		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));

		System.out.println("********************");

		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}
		System.out.println("**********************");

		boolean hasVideo = false;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = true;
			}
		}
		System.out.println("they get here");

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);		
	}

}
