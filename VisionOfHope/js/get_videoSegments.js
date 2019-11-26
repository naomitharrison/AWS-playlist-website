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
	};
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

	var output = '';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < js.listOfSegments.length; i++) {
		var constantJson = js.listOfSegments[i];
		console.log(constantJson);

		var ctitle = constantJson["title"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];
		output += '<li><input type="checkbox" name="' + curl + '"><video width="320" height="240" controls><source src="' + curl +'" type="video/ogg"></video><br> Line:' + ctitle + '<br> Character: ' + ccharacter + '</li><br><br>';
	}
	output += '</ul>';
	videoList.innerHTML = output;
}

function processVideoListAdminResponse(result) {
	console.log("res:" + result);
	let js = JSON.parse(result);
	let adminVideoList = document.getElementById('adminVideoSegmentList');

	let output = '';
	for (let i = 0; i < js.listOfSegments.length; i++) {
		let constantJson = js.listOfSegments[i];
		console.log(constantJson);

		let ctitle = constantJson["title"];
		let ccharacter = constantJson["character"];
		let curl = constantJson["url"];
		output += '<div class="row"><div class="col-sm-8">';
		output += '<input type="checkbox" name="' + curl + '"><video width="300" height="230" controls><source src="' + curl +'" type="video/ogg"></video><br> Line:' + ctitle + '<br> Character: ' + ccharacter;
		output += '</div><div class="col"><input type="checkbox" name="rem1"></div></div><br><br>';
	}
	adminVideoList.innerHTML = output;
}