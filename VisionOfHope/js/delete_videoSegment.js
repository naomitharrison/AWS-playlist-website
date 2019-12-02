function deleteVideoSegment() {
	var videoSegmentSelection = document.getElementsByTagName('input');

	for (var i = 0; i < videoSegmentSelection.length; i++) {
		if (videoSegmentSelection[i].type == "radio"
				&& videoSegmentSelection[i].name == "videoSegment") {

			if (videoSegmentSelection[i].checked) {
				var data = {};
				data["videoUrl"] = videoSegmentSelection[i].value;

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", deleteVideoSegment_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processDeleteVideoSegmentResponse(
								req.responseText);
					} else {
						processDeleteVideoSegmentResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}

}

function adminDeleteVideoSegment() {
	var videoSegmentSelection = document.getElementsByTagName('input');

	for (var i = 0; i < videoSegmentSelection.length; i++) {
		if (videoSegmentSelection[i].type == "radio"
				&& videoSegmentSelection[i].name == "videoSegment") {

			if (videoSegmentSelection[i].checked) {
				var data = {};
				data["videoUrl"] = videoSegmentSelection[i].value;

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", deleteVideoSegment_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processAdminDeleteVideoSegmentResponse(
								req.responseText);
					} else {
						processAdminDeleteVideoSegmentResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}

}


function processDeleteVideoSegmentResponse(result) {
	refreshVideoSegments();
}

function processAdminDeleteVideoSegmentResponse(result) {
    refreshAdminVideoSegments();
}