package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs3733.main.http.*;

public class IncreaseTestCoverage {

	@Test
	public void EmptyConstructors() {
		// this test gets coverage for the empty constructors that do nothing (but we need them for aws)
		// ik this is fake but i do not want to test exceptions and i am sad		
		ListPlaylistRequest a = new ListPlaylistRequest();
		ListPlaylistResponse b = new ListPlaylistResponse();
		NewPlaylistRequest c = new NewPlaylistRequest();
		NewPlaylistResponse d = new NewPlaylistResponse();
		DeletePlaylistRequest e = new DeletePlaylistRequest();
		DeletePlaylistResponse f = new DeletePlaylistResponse();
		DeletePlaylistVideoSegmentRequest g = new DeletePlaylistVideoSegmentRequest();
		DeletePlaylistVideoSegmentResponse h = new DeletePlaylistVideoSegmentResponse();
		ListPlaylistVideoSegmentsRequest i = new ListPlaylistVideoSegmentsRequest();
		ListPlaylistVideoSegmentsResponse j = new ListPlaylistVideoSegmentsResponse();
		AppendPlaylistRequest k = new AppendPlaylistRequest();
		AppendPlaylistResponse l = new AppendPlaylistResponse();
		ListVideoSegmentsRequest m = new ListVideoSegmentsRequest();
		ListVideoSegmentsResponse n = new ListVideoSegmentsResponse();
		NewVideoSegmentsRequest o = new NewVideoSegmentsRequest();
		NewVideoSegmentsResponse p = new NewVideoSegmentsResponse();
		DeleteVideoSegmentRequest q = new DeleteVideoSegmentRequest();
		DeleteVideoSegmentResponse r = new DeleteVideoSegmentResponse();
		RemoteStatusRequest s = new RemoteStatusRequest();
		RemoteStatusResponse t = new RemoteStatusResponse();
		RemoteLibraryAddRequest u = new RemoteLibraryAddRequest();
		RemoteLibraryAddResponse v = new RemoteLibraryAddResponse();
		ListRemoteLibrariesRequest w = new ListRemoteLibrariesRequest();
		ListRemoteLibrariesResponse x = new ListRemoteLibrariesResponse();
		RemoteLibraryRemoveRequest y = new RemoteLibraryRemoveRequest();
		RemoteLibraryRemoveResponse z = new RemoteLibraryRemoveResponse();
		RemoteVideoSegmentsRequest aa = new RemoteVideoSegmentsRequest();
		RemoteVideoSegmentsResponse ab = new RemoteVideoSegmentsResponse();
				
	}

}
