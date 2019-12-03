package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.DeletePlaylistHandler;
import cs3733.main.DeleteVideoSegmentHandler;
import cs3733.main.ListPlaylistsHandler;
import cs3733.main.ListVideoSegmentsHandler;
import cs3733.main.NewPlaylistHandler;
import cs3733.main.NewVideoSegmentsHandler;
import cs3733.main.http.AppendPlaylistRequest;
import cs3733.main.http.DeletePlaylistRequest;
import cs3733.main.http.DeletePlaylistResponse;
import cs3733.main.http.DeleteVideoSegmentRequest;
import cs3733.main.http.DeleteVideoSegmentResponse;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.http.ListVideoSegmentsResponse;
import cs3733.main.http.NewPlaylistRequest;
import cs3733.main.http.NewPlaylistResponse;
import cs3733.main.http.NewVideoSegmentsRequest;
import cs3733.main.http.NewVideoSegmentsResponse;
import cs3733.main.model.*;

public class AddAndDelete extends LambdaTest {

/*	@Test
	public void VideoSegment() {
		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));

		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}

		boolean hasVideo = false;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = true;
			}
		}

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);

		DeleteVideoSegmentHandler deleteHandler = new DeleteVideoSegmentHandler();

		DeleteVideoSegmentRequest deleteRequest = new DeleteVideoSegmentRequest(
				"https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle.ogg");
		DeleteVideoSegmentResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));

		for (VideoSegment vs : listResp2.list) {
			System.out.println(vs.toString());
		}

		boolean noLongerHasVideo = true;
		for (VideoSegment vs : listResp2.list) {
			if (vs.getTitle().equals("testTitle")) {
				noLongerHasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp2.statusCode);
		assertTrue(noLongerHasVideo);
	}

	@Test
	public void Playlist() {
		NewPlaylistHandler addHandler = new NewPlaylistHandler();

		NewPlaylistRequest addRequest = new NewPlaylistRequest("testPlaylist");
		NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
		ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));

		for (Playlist p : listResp.list) {
			System.out.println(p.toString());
		}

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

		DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();

		DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testPlaylist");
		DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListPlaylistsHandler listHandler2 = new ListPlaylistsHandler();
		ListPlaylistResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));

		for (Playlist p : listResp2.list) {
			System.out.println(p.toString());
		}

		boolean noLongerHasVideo = true;
		for (Playlist p : listResp.list) {
			if (p.getName().equals("testPlaylist")) {
				hasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp2.statusCode);
		assertTrue(noLongerHasVideo);
	}

	@Test
	public void PlaylistVideoSegment() {
		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		AppendPlaylistRequest appendRequest = new AppendPlaylistRequest("https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle.ogg", );
		
		boolean hasVideo = false;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = true;
				break;
			}
		}

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);

		NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));

		boolean noLongerHasVideo = true;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				noLongerHasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp2.statusCode);
		assertTrue(noLongerHasVideo);
	}

	@Test
	public void RemoteLibs() {
		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));

		for (VideoSegment vs : listResp.list) {
			System.out.println(vs.toString());
		}

		boolean hasVideo = false;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				hasVideo = true;
				break;
			}
		}

		assertEquals(200, addResp.statusCode);
		assertEquals(200, listResp.statusCode);
		assertTrue(hasVideo);

		NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();

		NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
				"Mi43MTgyODE4Mjg=", true);
		NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));

		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));

		boolean noLongerHasVideo = true;
		for (VideoSegment vs : listResp.list) {
			if (vs.getTitle().equals("testTitle")) {
				noLongerHasVideo = false;
				break;
			}
		}

		assertEquals(200, deleteResp.statusCode);
		assertEquals(200, listResp2.statusCode);
	}
	*/
}
