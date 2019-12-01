function addRemoteLibrary() {
	var libraryName = document.getElementById('remoteLibraryName').value;
	var libraryUrl = document.getElementById('remoteLibraryUrl').value;

	var data = {};
	data["url"] = libraryUrl;
	data["name"] = libraryName;

	var js = JSON.stringify(data);
	console.log("JS:" + js);

	var req = new XMLHttpRequest();
	req.open("POST", playlistVideoSegments_url, true);
	req.send(js);
	req.onloadend = function() {
		console.log(req);
		console.log(req.request);

		if (req.readyState == XMLHttpRequest.DONE) {
			console.log("XHR:" + req.responseText);
			processPlaylistVideoSegmentsListResponse(data.name,
					req.responseText);
		} else {
			processPlaylistVideoSegmentsListResponse(data.name, "N/A");
		}

	}
}

function processPlaylistVideoSegmentsListResponse(name, result) {
	var js = JSON.parse(result);
	var playlist = document.getElementById('playlist');

	var output = '';

	output += '<div class="row"><h5>' + name
			+ '<h5></div><div class="row"><ul style="list-style-type:none;">';
	for (var k = 0; k < js.listOfSegments.length; k++) {
		var videoIterate = js.listOfSegments[k];
		var ctitle = videoIterate["title"];
		var ccharacter = videoIterate["character"];
		var curl = videoIterate["url"];

		output += '<li><input type="checkbox" name="playlist" value="' + curl
				+ '"><video width="320" height="240" controls><source src="'
				+ curl + '" type="video/ogg"></video><br> Line:' + ctitle
				+ '<br> Character: ' + ccharacter + '</li><br><br>'
	}
	output += '</ul></div>'

	console.log("final HTML: " + output);
	playlist.innerHTML = output;

}