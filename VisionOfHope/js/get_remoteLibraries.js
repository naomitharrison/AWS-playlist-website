function refreshRemoteLibraries() {
	let request = new XMLHttpRequest();
	request.open('GET', remoteLibraries_url, true);
	request.send();

	console.log("sent");

	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);
			processRemoteLibrariesListResponse(request.responseText);
		} else {
			processRemoteLibrariesListResponse("N/A");
		}
	};
}

function getRemoteLibrariesForSearch(characterSearch, titleSearch) {
	let request = new XMLHttpRequest();
	request.open('GET', remoteLibraries_url, true);
	request.send();

	console.log("sent");

	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);
			getRemoteLibraryVideoSegments(request.responseText, characterSearch, titleSearch);
		} else {
			getRemoteLibraryVideoSegments("N/A", characterSearch, titleSearch);
		}
	};
}




function getRemoteVideoSegmentsForSearch(fullURL, characterSearch, titleSearch) {
	let parts = fullURL.split("?apikey=");
	console.log(parts);
	var request = new XMLHttpRequest();
	request.open("GET", parts[0], true);
	request.setRequestHeader("x-api-key", parts[1]);

	request.send();
	console.log("sent");

	request.onloadend = function () {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("XHR:" + request.responseText);
			processSearchResponse(request.responseText, characterSearch, titleSearch);
		} else {
			processSearchResponse("N/A", characterSearch, titleSearch);
		}
	}
}

function processRemoteLibrariesListResponse(result) {
	console.log("res:" + result);
	var js = JSON.parse(result);
	var remoteLibraryList = document.getElementById('remoteLibraryList');

	var output = '';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < js.list.length; i++) {
		var constantJson = js.list[i];
		console.log(constantJson);

		var cname = constantJson["name"];
		var curl = constantJson["url"];
		output += '<li><input type="radio" name="remoteLibrary" value="' + curl + '">' + cname + '</li>';
	}
	output += '</ul>';
	console.log("final HTML: " + output);
	remoteLibraryList.innerHTML = output;
}

