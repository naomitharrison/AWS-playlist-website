function deletePlaylist() {
	var playlistSegmentSelection = document.getElementsByTagName('input');
	var visiblePlaylist = document.getElementById('playlistTitleHeader').innerHTML;

	for (var i = 0; i < playlistSegmentSelection.length; i++) {
		if (playlistSegmentSelection[i].type == "radio"
				&& playlistSegmentSelection[i].name == "playlist") {

			if (playlistSegmentSelection[i].checked) {
				var data = {};
				data["name"] = playlistSegmentSelection[i].value;
				if(data["name"] === visiblePlaylist) {
					clearPlaylistVideoSegments();
					console.log("Removing displayed playlist")
				}

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", deletePlaylist_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processDeletePlaylistResponse(
								req.responseText);
					} else {
						processDeletePlaylistResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}

}

function processDeletePlaylistResponse(result) {
	refreshPlaylists();
}