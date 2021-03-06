function refreshVideoSegmentsForSearch(characterSearch, titleSearch) {
	let request = new XMLHttpRequest();
	request.open('GET', videos_url, true);
	request.send();

	console.log("sent");

	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);
			processSearchResponse(request.responseText, characterSearch, titleSearch);

		} else {
			processSearchResponse("N/A", characterSearch, titleSearch);
		}
	}
}

function refreshVideoSegments() {
	let request = new XMLHttpRequest();
	request.open('GET', videos_url, true);
	request.send();

	console.log("sent");

	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);

			processVideoListResponse(request.responseText);

		} else {
			processVideoListResponse("N/A");
		}
	}
}

function refreshAdminVideoSegments() {
	let request = new XMLHttpRequest();
	request.open('GET', videos_url, true);
	request.send();

	console.log("sent");

	request.onload = function() {
		if (request.readyState == XMLHttpRequest.DONE) {
			console.log ("request:" + request.responseText);
			processVideoListAdminResponse(request.responseText);

		} else {
			processVideoListResponse("N/A");
		}
	};
}

function processVideoListResponse(result) {
	console.log("res:" + result);
	var js = JSON.parse(result);
	var videoList = document.getElementById('videoSegmentList');
	var libraryHeader = document.getElementById('LibraryHeader');

	var output = '';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < js.segments.length; i++) { // listOfSegments
		var constantJson = js.segments[i];
		console.log(constantJson);

		var ctitle = constantJson["text"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];
		output += '<li><input type="radio" name="videoSegment" value="' + curl + '"><video width="320" height="240" controls><source src="' + curl +'" type="video/ogg"></video><br> Line: ' + ctitle + '<br> Character: ' + ccharacter + '</li><br><br>';
	}
	output += '</ul>';
	videoList.innerHTML = output;
	libraryHeader.innerHTML = '<h3>Local Library</h3>';
}

function processVideoListAdminResponse(result) {
	console.log("res:" + result);
	let js = JSON.parse(result);
	let adminVideoList = document.getElementById('adminVideoSegmentList');

	let output = '';
	for (let i = 0; i < js.segments.length; i++) { // listOfSegments
		let constantJson = js.segments[i];
		console.log(constantJson);

		let ctitle = constantJson["text"];
		let ccharacter = constantJson["character"];
		let curl = constantJson["url"];
		let cavailability = constantJson["availability"];
		output += '<div class="row"><div class="col-sm-8">';
		output += '<input type="radio" name="videoSegment" value="' + curl + '"><video width="300" height="230" controls><source src="' + curl +'" type="video/ogg"></video><br> Line: ' + ctitle + '<br> Character: ' + ccharacter;
		output += '</div><div class="col"><input type="checkbox" name="remoteStatus" value="' + curl + '"';
		if(cavailability == true) {
			output += ' checked';
		}
		output += '></div></div><br><br>';
	}
	adminVideoList.innerHTML = output;
}