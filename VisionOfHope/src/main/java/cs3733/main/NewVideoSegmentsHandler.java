package cs3733.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import cs3733.main.http.NewVideoSegmentsRequest;
import cs3733.main.http.NewVideoSegmentsResponse;
import edu.wpi.cs.heineman.calculator.http.CreateConstantResponse;

public class NewVideoSegmentsHandler implements RequestHandler<NewVideoSegmentsRequest,NewVideoSegmentsResponse>{

	@Override
	public NewVideoSegmentsResponse handleRequest(NewVideoSegmentsRequest req, Context context) {
		logger = context.getLogger();
		logger.log(req.toString());

		NewVideoSegmentsResponse response;
		try {
			byte[] encoded = java.util.Base64.getDecoder().decode(req.base64EncodedValue);
			if (req.system) {
				if (createSystemConstant(req.name, encoded)) {
					response = new NewVideoSegmentsResponse(req.name);
				} else {
					response = new NewVideoSegmentsResponse(req.name, 422);
				}
			} else {
				String contents = new String(encoded);
				double value = Double.valueOf(contents);
				
				if (createConstant(req.name, value)) {
					response = new NewVideoSegmentsResponse(req.name);
				} else {
					response = new NewVideoSegmentsResponse(req.name, 422);
				}
			}
		} catch (Exception e) {
			response = new NewVideoSegmentsResponse("Unable to create constant: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}
	}

}
