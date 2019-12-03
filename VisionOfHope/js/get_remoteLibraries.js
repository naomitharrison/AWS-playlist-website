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
		output += '<li><input type="radio" name="remoteLibrary" value="' + cname + '">' + cname + '</li>';
	}
	output += '</ul>';
	console.log("final HTML: " + output);
	remoteLibraryList.innerHTML = output;
}

