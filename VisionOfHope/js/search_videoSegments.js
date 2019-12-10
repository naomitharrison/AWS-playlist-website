function searchVideoSegments() {
    var videoList = document.getElementById('videoSegmentList');
    while (videoList.firstChild) {
    	videoList.removeChild(videoList.firstChild);
  	}
	videoList.innerHTML = '<div class="row"><input type="button" id="switchToLibrary" value="Open Local Library" onclick="refreshVideoSegments()"></div>';

    var libraryHeader = document.getElementById('LibraryHeader');
	libraryHeader.innerHTML = '<h3>Remote and Local Search</h3>';

	var characterSearch = document.getElementById('characterSearch').value;
    var titleSearch = document.getElementById('titleSearch').value;
    document.getElementById('characterSearch').value = '';
    document.getElementById('titleSearch').value = '';

	refreshVideoSegmentsForSearch(characterSearch, titleSearch);
	getRemoteLibrariesForSearch(characterSearch, titleSearch);
}

function getRemoteLibraryVideoSegments(remoteLibraries, characterSearch, titleSearch) {
	console.log(remoteLibraries);
	let libraries = JSON.parse(remoteLibraries);

	for(var i = 0; i < libraries.list.length; i++) {
		var library = libraries.list[i];
		getRemoteVideoSegmentsForSearch(library.url, characterSearch, titleSearch);
	}
}

function processSearchResponse(result, characterSearch, titleSearch) {
	console.log(result);

	let libraryVideos = JSON.parse(result);

    // console.log("char:" + characterSearch);
    // console.log("title:" + titleSearch);

    var searchResult = {};
    searchResult["segments"] = [];

    if (characterSearch != "") {
        searchResult = searchByCharacter(characterSearch, searchResult, libraryVideos);
    } else {
        searchResult["segments"] = libraryVideos["segments"];
    }

    // var newJs = JSON.stringify(searchResult);
    // console.log("res:" + newJs);

    if (titleSearch != "") {
        searchResult = searchByTitle(titleSearch, searchResult);
    }

    // newJs = JSON.stringify(searchResult);
    // console.log("res:" + newJs);

    processSearchVideoSegmentsResponse(searchResult);

}

function searchByCharacter(character, searchResult, libraryVideos) {
    var newSearchResult = {};
    newSearchResult["segments"] = [];

    for (var i = 0; i < libraryVideos.segments.length; i++) {
        var constantJson = libraryVideos.segments[i];
        var ctitle = constantJson["text"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];

		if(ccharacter === character) {
		    var newEntry = {text: ctitle, character: ccharacter, url: curl};
		    newSearchResult["segments"].push(newEntry);
        }
    }
    return newSearchResult;
}

function searchByTitle(title, searchResult) {
    var newSearchResult = {};
    newSearchResult["segments"] = [];

    for (var i = 0; i < searchResult.segments.length; i++) {
        var constantJson = searchResult.segments[i];
        var ctitle = constantJson["text"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];

		if(ctitle.includes(title)) {
		    var newEntry = {text: ctitle, character: ccharacter, url: curl};
		    newSearchResult["segments"].push(newEntry);
        }
    }
    return newSearchResult;
}

function processSearchVideoSegmentsResponse(result) {
	//console.log("res:" + result);
	//var js = JSON.parse(result);
	var videoList = document.getElementById('videoSegmentList');

	var output = '';

	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < result.segments.length; i++) { // listOfSegments
		var constantJson = result.segments[i];
		console.log(constantJson);

		var ctitle = constantJson["text"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];
		output += '<li><input type="radio" name="videoSegment" value="' + curl + '"><video width="320" height="240" controls><source src="' + curl +'" type="video/ogg"></video><br> Line: ' + ctitle + '<br> Character: ' + ccharacter + '</li><br><br>';
	}
	output += '</ul>';
	var newElement = document.createElement('div');
	newElement.innerHTML = output;
	videoList.appendChild(newElement);
}

/*
function searchVideoSegments() {
    var characterSearch = document.getElementById('characterSearch').value;
    var titleSearch = document.getElementById('titleSearch').value;

    var data = {};
    data["title"] = titleSearch;
    data["character"] = characterSearch;

    var js = JSON.stringify(data);
    console.log("JS:" + js);

    var req = new XMLHttpRequest();
    req.open("POST", searchVideoSegments_url, true);
    req.send(js);
    req.onloadend = function () {
        console.log(req);
        console.log(req.request);

        if (req.readyState == XMLHttpRequest.DONE) {
            console.log("XHR:" + req.responseText);
            processSearchVideoSegmentsResponse(
                req.responseText);
        } else {
            processSearchVideoSegmentsResponse(
                "N/A");
        }
    }
}
*/

