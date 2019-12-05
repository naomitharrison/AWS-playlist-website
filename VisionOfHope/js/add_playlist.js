function addPlaylist() {
	var playlistName = document.getElementById('playlistName').value;

	var data = {};
	data["name"] = playlistName;

	var js = JSON.stringify(data);
	console.log("JS:" + js);

	var req = new XMLHttpRequest();
	req.open("POST", playlists_url, true);
	req.send(js);
	req.onloadend = function() {
		console.log(req);
		console.log(req.request);

		if (req.readyState == XMLHttpRequest.DONE) {
			console.log("XHR:" + req.responseText);
			processAddPlaylistResponse(req.responseText);
		} else {
			processAddPlaylistResponse("N/A");
		}

	}
}

function processAddPlaylistResponse(result) {
	refreshPlaylists();
	var playlistName = document.getElementById('playlistName');

	playlistName.value = '';
}