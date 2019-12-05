function appendPlaylist() {
	var currentPlaylist = document.getElementById('playlistTitleHeader').innerHTML;
	var videoSegmentSelection = document.getElementsByTagName('input');
	
	var data = {};
	data["name"] = currentPlaylist;
	for (var i = 0; i < videoSegmentSelection.length; i++) {
		if (videoSegmentSelection[i].type == "radio"
				&& videoSegmentSelection[i].name == "videoSegment") {

			if (videoSegmentSelection[i].checked) {
				data["videoUrl"] = videoSegmentSelection[i].value;

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", appendPlaylist_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processAppendPlaylistResponse(
								req.responseText);
					} else {
						processAppendPlaylistResponse(
								 "N/A");
					}
				};

			}
		}
	}

}

function processAppendPlaylistResponse(result) {
	refreshCurrentPlaylistVideoSegments();
}