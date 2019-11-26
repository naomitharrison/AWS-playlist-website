function refreshPlaylists() {
	let request = new XMLHttpRequest();
	request.open('GET', playlists_url, true);
	request.send();
	
	console.log("sent");
	
	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);
			processPlaylistListResponse(request.responseText);
		} else {
			processPlaylistListResponse("N/A");
		}
	};
}

function processPlaylistListResponse(result) {
	console.log("res:" + result);
	var js = JSON.parse(result);
	var playlistList = document.getElementById('playlistList');
	
	var output = '';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < js.list.length; i++) {    // listOfPlaylists
		var constantJson = js.list[i];
		console.log(constantJson);
		
		var cname = constantJson["name"];
		output += '<li><input type="radio" name="' + cname + '">' + cname + '</li>';
	}
	output += '</ul>';
	console.log("final HTML: " + output);
	playlistList.innerHTML = output;
}

function getPlaylist(){
	

	
}