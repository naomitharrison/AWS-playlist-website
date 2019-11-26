package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.DeletePlaylistVideoSegmentRequest;
import main.http.DeletePlaylistVideoSegmentResponse;

public class DeletePlaylistVideoSegmentHandler implements RequestHandler<DeletePlaylistVideoSegmentRequest,DeletePlaylistVideoSegmentResponse>{

	@Override
	public DeletePlaylistVideoSegmentResponse handleRequest(DeletePlaylistVideoSegmentRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
