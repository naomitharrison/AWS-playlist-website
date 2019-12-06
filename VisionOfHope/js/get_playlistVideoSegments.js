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
						processPlaylistVideoSegmentsListResponse(data.name,
								req.responseText);
					} else {
						processPlaylistVideoSegmentsListResponse(data.name,
								"N/A");
					}
				};

			}
		}
	}

}

function refreshCurrentPlaylistVideoSegments() {
	var currentPlaylist = document.getElementById('playlistTitleHeader').innerHTML;

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
			processPlaylistVideoSegmentsListResponse(currentPlaylist,
					req.responseText);
		} else {
			processPlaylistVideoSegmentsListResponse(currentPlaylist, "N/A");
		}
	}

}
function processPlaylistVideoSegmentsListResponse(name, result) {
	var js = JSON.parse(result);
	var playlist = document.getElementById('playlist');
	var playlistName = document.getElementById('playlistTitle');

	var output = '';
	var outputTitle = '';

	outputTitle += '<div class="row"><h5 id="playlistTitleHeader">' + name + '</h5></div>';
	output += '<div class="row"><ul style="list-style-type:none;">';
	for (var k = 0; k < js.list.length; k++) {
		var videoIterate = js.list[k];
		var ctitle = videoIterate["title"];
		var ccharacter = videoIterate["character"];
		var curl = videoIterate["url"];

		output += '<li><input type="radio" name="playlistVideoSegment" value="' + curl
				+ '"><video width="320" height="240" controls><source src="'
				+ curl + '" type="video/ogg"></video><br> Line:' + ctitle
				+ '<br> Character: ' + ccharacter + '</li><br><br>'
	}
	output += '</ul></div>';
	
/*	output += '<script>';
	id = 0;
	for (var l = 0; l < js.list.length; l++){
		output += '<br> var num' + id + '= document.getElementById("' + id + 
				'"); <br><br> num' + id + '.addEventListener("ended", function() {num' + id++
				+ '.play();});'
		id++;
	}
	output += '</script>';

*/
	console.log("final List HTML: " + output);
	console.log("final Title HTML: " + outputTitle);
	playlist.innerHTML = output;
	playlistName.innerHTML = outputTitle;

}