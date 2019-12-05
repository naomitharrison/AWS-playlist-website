//package test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//<<<<<<< HEAD
//import cs3733.main.AppendPlaylistHandler;
//import cs3733.main.DeletePlaylistHandler;
//import cs3733.main.DeleteVideoSegmentHandler;
//import cs3733.main.ListPlaylistVideoSegmentHandler;
//=======
//import cs3733.main.DeletePlaylistHandler;
//import cs3733.main.DeleteVideoSegmentHandler;
//>>>>>>> refs/heads/master
//import cs3733.main.ListPlaylistsHandler;
//import cs3733.main.ListRemoteLibraryHandler;
//import cs3733.main.ListVideoSegmentsHandler;
//import cs3733.main.NewPlaylistHandler;
//import cs3733.main.NewVideoSegmentsHandler;
//<<<<<<< HEAD
//import cs3733.main.RemoteLibraryAddHandler;
//import cs3733.main.RemoteLibraryRemoveHandler;
//import cs3733.main.http.AppendPlaylistRequest;
//import cs3733.main.http.AppendPlaylistResponse;
//=======
//import cs3733.main.http.AppendPlaylistRequest;
//>>>>>>> refs/heads/master
//import cs3733.main.http.DeletePlaylistRequest;
//import cs3733.main.http.DeletePlaylistResponse;
//import cs3733.main.http.DeleteVideoSegmentRequest;
//import cs3733.main.http.DeleteVideoSegmentResponse;
//import cs3733.main.http.ListPlaylistResponse;
//import cs3733.main.http.ListPlaylistVideoSegmentsRequest;
//import cs3733.main.http.ListPlaylistVideoSegmentsResponse;
//import cs3733.main.http.ListRemoteLibrariesResponse;
//import cs3733.main.http.ListVideoSegmentsResponse;
//import cs3733.main.http.NewPlaylistRequest;
//import cs3733.main.http.NewPlaylistResponse;
//import cs3733.main.http.NewVideoSegmentsRequest;
//import cs3733.main.http.NewVideoSegmentsResponse;
//import cs3733.main.http.RemoteLibraryAddRequest;
//import cs3733.main.http.RemoteLibraryAddResponse;
//import cs3733.main.http.RemoteLibraryRemoveRequest;
//import cs3733.main.http.RemoteLibraryRemoveResponse;
//import cs3733.main.model.*;
//
//public class AddAndDelete extends LambdaTest {
//
///*	@Test
//	public void VideoSegment() {
//		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();
//
//<<<<<<< HEAD
//    	NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater", "Mi43MTgyODE4Mjg=", true);
//    	NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//        
//    	ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
//    	ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
//    	
//    	for (VideoSegment vs : listResp.list) {
//        	System.out.println(vs.toString());
//        }
//    	
//        boolean hasVideo = false;
//        for (VideoSegment vs : listResp.list) {
//        	if (vs.getTitle().equals("testTitle")) { hasVideo = true; break; }
//        }
//        
//        assertEquals(200, addResp.statusCode);
//        assertEquals(200, listResp.statusCode);
//        assertTrue(hasVideo);
//        
//        
//        DeleteVideoSegmentHandler deleteHandler = new DeleteVideoSegmentHandler();
//=======
//		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
//				"Mi43MTgyODE4Mjg=", true);
//		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//        DeleteVideoSegmentRequest deleteRequest = new DeleteVideoSegmentRequest("https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle");
//        DeleteVideoSegmentResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("link"));
//        
//    	ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
//    	ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//    	
//        boolean noLongerHasVideo = true;
//        for (VideoSegment vs : listResp2.list) {
//        	if (vs.getUrl().equals("https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle")) { noLongerHasVideo = false; break; }
//        }
//=======
//		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
//		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
//>>>>>>> refs/heads/master
//
//		for (VideoSegment vs : listResp.list) {
//			System.out.println(vs.toString());
//		}
//
//		boolean hasVideo = false;
//		for (VideoSegment vs : listResp.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				hasVideo = true;
//			}
//		}
//
//		assertEquals(200, addResp.statusCode);
//		assertEquals(200, listResp.statusCode);
//		assertTrue(hasVideo);
//
//		DeleteVideoSegmentHandler deleteHandler = new DeleteVideoSegmentHandler();
//
//		DeleteVideoSegmentRequest deleteRequest = new DeleteVideoSegmentRequest(
//				"https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle.ogg");
//		DeleteVideoSegmentResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//
//		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
//		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//
//		for (VideoSegment vs : listResp2.list) {
//			System.out.println(vs.toString());
//		}
//
//		boolean noLongerHasVideo = true;
//		for (VideoSegment vs : listResp2.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				noLongerHasVideo = false;
//				break;
//			}
//		}
//
//		assertEquals(200, deleteResp.statusCode);
//		assertEquals(200, listResp2.statusCode);
//		assertTrue(noLongerHasVideo);
//	}
//
//	@Test
//	public void Playlist() {
//		NewPlaylistHandler addHandler = new NewPlaylistHandler();
//
//<<<<<<< HEAD
//    	NewPlaylistRequest addRequest = new NewPlaylistRequest("testTitle");
//    	NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//        
//    	ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
//    	ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));
//    	
//    	for (Playlist p : listResp.list) {
//        	System.out.println(p.toString());
//        }
//    	
//        boolean hasVideo = false;
//    	for (Playlist p : listResp.list) {
//        	if (p.getName().equals("testTitle")) { hasVideo = true; break; }
//        }
//        
//        assertEquals(200, addResp.statusCode);
//        assertEquals(200, listResp.statusCode);
//        assertTrue(hasVideo);
//        
//        
//        DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();
//=======
//		NewPlaylistRequest addRequest = new NewPlaylistRequest("testPlaylist");
//		NewPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//        DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testName");
//        DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//        
//    	ListPlaylistsHandler listHandler2 = new ListPlaylistsHandler();
//    	ListPlaylistResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//    	
//        boolean noLongerHasVideo = true;
//    	for (Playlist p : listResp2.list) {
//        	if (p.getName().equals("testName")) { noLongerHasVideo = false; break; }
//        }
//=======
//		ListPlaylistsHandler listHandler = new ListPlaylistsHandler();
//		ListPlaylistResponse listResp = listHandler.handleRequest(null, createContext("list"));
//>>>>>>> refs/heads/master
//
//		for (Playlist p : listResp.list) {
//			System.out.println(p.toString());
//		}
//
//		boolean hasVideo = false;
//		for (Playlist p : listResp.list) {
//			if (p.getName().equals("testPlaylist")) {
//				hasVideo = true;
//				break;
//			}
//		}
//
//		assertEquals(200, addResp.statusCode);
//		assertEquals(200, listResp.statusCode);
//		assertTrue(hasVideo);
//
//		DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();
//
//		DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testPlaylist");
//		DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//
//		ListPlaylistsHandler listHandler2 = new ListPlaylistsHandler();
//		ListPlaylistResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//
//		for (Playlist p : listResp2.list) {
//			System.out.println(p.toString());
//		}
//
//		boolean noLongerHasVideo = true;
//		for (Playlist p : listResp.list) {
//			if (p.getName().equals("testPlaylist")) {
//				hasVideo = false;
//				break;
//			}
//		}
//
//		assertEquals(200, deleteResp.statusCode);
//		assertEquals(200, listResp2.statusCode);
//		assertTrue(noLongerHasVideo);
//	}
//
//	@Test
//	public void PlaylistVideoSegment() {
//<<<<<<< HEAD
//    	AppendPlaylistHandler addHandler = new AppendPlaylistHandler();
//=======
//		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//    	AppendPlaylistRequest addRequest = new AppendPlaylistRequest("testPlaylistTitle", "testURL");
//    	AppendPlaylistResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//        
//    	ListPlaylistVideoSegmentHandler listHandler = new ListPlaylistVideoSegmentHandler();
//    	ListPlaylistVideoSegmentsRequest listRequest = new ListPlaylistVideoSegmentsRequest("testPlaylistTitle");
//    	ListPlaylistVideoSegmentsResponse listResp = listHandler.handleRequest(listRequest, createContext("list"));
//
//    	for (VideoSegment vs : listResp.list) {
//        	System.out.println(vs.toString());
//        }
//    	
//        boolean hasVideo = false;
//    	for (VideoSegment vs : listResp.list) {
//        	if (vs.getUrl().equals("testURL")) { hasVideo = true; break; }
//        }
//        
//        assertEquals(200, addResp.statusCode);
//        assertEquals(200, listResp.statusCode);
//        assertTrue(hasVideo);
//        
//        
//        DeletePlaylistHandler deleteHandler = new DeletePlaylistHandler();
//=======
//		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
//				"Mi43MTgyODE4Mjg=", true);
//		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//        DeletePlaylistRequest deleteRequest = new DeletePlaylistRequest("testName");
//        DeletePlaylistResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//
//        ListPlaylistVideoSegmentHandler listHandler2 = new ListPlaylistVideoSegmentHandler();
//    	ListPlaylistVideoSegmentsRequest listRequest2 = new ListPlaylistVideoSegmentsRequest("testPlaylistTitle");
//    	ListPlaylistVideoSegmentsResponse listResp2 = listHandler2.handleRequest(listRequest2, createContext("list"));
//    	
//        boolean noLongerHasVideo = true;
//    	for (VideoSegment vs : listResp2.list) {
//        	if (vs.getTitle().equals("testName")) { noLongerHasVideo = false; break; }
//        }
//=======
//		AppendPlaylistRequest appendRequest = new AppendPlaylistRequest("https://cs3733visionofhopesurpassed.s3.anazonaws.com/videos/testTitle.ogg", );
//		
//		boolean hasVideo = false;
//		for (VideoSegment vs : listResp.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				hasVideo = true;
//				break;
//			}
//		}
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//        assertEquals(200, deleteResp.statusCode);
//        assertEquals(200, listResp2.statusCode);
//        assertTrue(noLongerHasVideo);
//	}
//	
//=======
//		assertEquals(200, addResp.statusCode);
//		assertEquals(200, listResp.statusCode);
//		assertTrue(hasVideo);
//
//		NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();
//
//		NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
//				"Mi43MTgyODE4Mjg=", true);
//		NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//
//		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
//		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//
//		boolean noLongerHasVideo = true;
//		for (VideoSegment vs : listResp.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				noLongerHasVideo = false;
//				break;
//			}
//		}
//
//		assertEquals(200, deleteResp.statusCode);
//		assertEquals(200, listResp2.statusCode);
//		assertTrue(noLongerHasVideo);
//	}
//
//>>>>>>> refs/heads/master
//	@Test
//	public void RemoteLibs() {
//<<<<<<< HEAD
//    	RemoteLibraryAddHandler addHandler = new RemoteLibraryAddHandler();
//=======
//		NewVideoSegmentsHandler addHandler = new NewVideoSegmentsHandler();
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//    	RemoteLibraryAddRequest addRequest = new RemoteLibraryAddRequest("testTitle", "testURL");
//    	RemoteLibraryAddResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//        
//    	ListRemoteLibraryHandler listHandler = new ListRemoteLibraryHandler();
//    	ListRemoteLibrariesResponse listResp = listHandler.handleRequest(null, createContext("list"));
//    	
//    	for (RemoteLib l : listResp.list) {
//        	System.out.println(l.toString());
//        }
//    	
//        boolean hasLib = false;
//    	for (RemoteLib l : listResp.list) {
//        	if (l.getName().equals("testTitle")) { hasLib = true; break; }
//        }
//        
//        assertEquals(200, addResp.statusCode);
//        assertEquals(200, listResp.statusCode);
//        assertTrue(hasLib);
//        
//        
//        RemoteLibraryRemoveHandler removeHandler = new RemoteLibraryRemoveHandler();
//=======
//		NewVideoSegmentsRequest addRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
//				"Mi43MTgyODE4Mjg=", true);
//		NewVideoSegmentsResponse addResp = addHandler.handleRequest(addRequest, createContext("name"));
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//    	RemoteLibraryRemoveRequest removeRequest = new RemoteLibraryRemoveRequest("testTitle", "testURL");
//    	RemoteLibraryRemoveResponse removeResp = removeHandler.handleRequest(removeRequest, createContext("name"));
//        
//    	ListRemoteLibraryHandler listHandler2 = new ListRemoteLibraryHandler();
//    	ListRemoteLibrariesResponse listResp2 = listHandler.handleRequest(null, createContext("list"));
//    	
//        boolean noLongerHasVideo = true;
//    	for (RemoteLib l : listResp2.list) {
//        	if (l.getName().equals("testName")) { noLongerHasVideo = false; break; }
//        }
//=======
//		ListVideoSegmentsHandler listHandler = new ListVideoSegmentsHandler();
//		ListVideoSegmentsResponse listResp = listHandler.handleRequest(null, createContext("list"));
//>>>>>>> refs/heads/master
//
//<<<<<<< HEAD
//        assertEquals(200, removeResp.statusCode);
//        assertEquals(200, listResp2.statusCode);
//        assertTrue(noLongerHasVideo);
//	}
//=======
//		for (VideoSegment vs : listResp.list) {
//			System.out.println(vs.toString());
//		}
//>>>>>>> refs/heads/master
//
//		boolean hasVideo = false;
//		for (VideoSegment vs : listResp.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				hasVideo = true;
//				break;
//			}
//		}
//
//		assertEquals(200, addResp.statusCode);
//		assertEquals(200, listResp.statusCode);
//		assertTrue(hasVideo);
//
//		NewVideoSegmentsHandler deleteHandler = new NewVideoSegmentsHandler();
//
//		NewVideoSegmentsRequest deleteRequest = new NewVideoSegmentsRequest("testTitle", "testCharater",
//				"Mi43MTgyODE4Mjg=", true);
//		NewVideoSegmentsResponse deleteResp = deleteHandler.handleRequest(deleteRequest, createContext("name"));
//
//		ListVideoSegmentsHandler listHandler2 = new ListVideoSegmentsHandler();
//		ListVideoSegmentsResponse listResp2 = listHandler2.handleRequest(null, createContext("list"));
//
//		boolean noLongerHasVideo = true;
//		for (VideoSegment vs : listResp.list) {
//			if (vs.getTitle().equals("testTitle")) {
//				noLongerHasVideo = false;
//				break;
//			}
//		}
//
//		assertEquals(200, deleteResp.statusCode);
//		assertEquals(200, listResp2.statusCode);
//	}
//	*/
//}
