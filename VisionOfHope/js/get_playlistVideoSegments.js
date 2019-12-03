function refreshPlaylistVideoSegments() {
	var playlistListSelection = document.getElementsByTagName('input');

	for (var i = 0; i < playlistListSelection.length; i++) {
		if (playlistListSelection[i].type == "radio"
				&& playlistListSelection[i].name == "playlist") {

			if (playlistListSelection[i].checked) {
				var data = {};
				data["name"] = playlistListSelection[i].value;

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
						processPlaylistVideoSegmentsListResponse(
								data.name,
								req.responseText);
					} else {
						processPlaylistVideoSegmentsListResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}

}

function refreshCurrentPlaylistVideoSegments() {
	var currentPlaylist = document.getElementsByTagName('playlist').value;

				var data = {};
				data["name"] = currentPlaylist;

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
						processPlaylistVideoSegmentsListResponse(
								data.name,
								req.responseText);
					} else {
						processPlaylistVideoSegmentsListResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}

}
function processPlaylistVideoSegmentsListResponse(name, result) {
	var js = JSON.parse(result);
	var playlist = document.getElementById('playlist');

	var output = '';

	output += '<div class="row"><h5>' + name
			+ '<h5></div><div class="row"><ul style="list-style-type:none;">';
	for (var k = 0; k < js.list.length; k++) {
		var videoIterate = js.list[k];
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