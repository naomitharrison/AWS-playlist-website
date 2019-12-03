function removeVideoPlaylist() {
	var currentPlaylist = document.getElementsByTagName('playlist').value;
	var playlistVideoSegmentSelection = document.getElementsByTagName('input');
	
	var data = {};
	data["name"] = currentPlaylist;
	for (var i = 0; i < playlistVideoSegmentSelection.length; i++) {
		if (playlistVideoSegmentSelection[i].type == "radio"
				&& playlistVideoSegmentSelection[i].name == "videoSegment") {

			if (playlistVideoSegmentSelection[i].checked) {
				data["videoUrl"] = playlistVideoSegmentSelection[i].value;

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", removeVideoPlaylist_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processRemoveVideoPlaylistResponse(
								req.responseText);
					} else {
						processRemoveVideoPlaylistResponse(
								 "N/A");
					}
				};

			}
		}
	}

}

function processRemoveVideoPlaylistResponse(result) {
	refreshCurrentPlaylistVideoSegments();
}