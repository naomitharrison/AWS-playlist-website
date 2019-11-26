package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import main.http.NewVideoSegmentsRequest;
import main.http.NewVideoSegmentsResponse;

public class NewVideoSegmentsHandler implements RequestHandler<NewVideoSegmentsRequest,NewVideoSegmentsResponse>{

	@Override
	public NewVideoSegmentsResponse handleRequest(NewVideoSegmentsRequest arg0, Context arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
