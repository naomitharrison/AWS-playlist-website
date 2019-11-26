package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.http.DeletePlaylistVideoSegmentRequest;
import cs3733.main.http.DeletePlaylistVideoSegmentResponse;

public class DeletePlaylistVideoSegmentHandler implements RequestHandler<DeletePlaylistVideoSegmentRequest,DeletePlaylistVideoSegmentResponse>{

	@Override
	public DeletePlaylistVideoSegmentResponse handleRequest(DeletePlaylistVideoSegmentRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
