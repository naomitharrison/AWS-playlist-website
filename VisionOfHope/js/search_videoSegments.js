function searchVideoSegments() {
    refreshVideoSegmentsForSearch();
}

function processSearchResponse(js) {
    var characterSearch = document.getElementById('characterSearch').value;
    var titleSearch = document.getElementById('titleSearch').value;
    // console.log("char:" + characterSearch);
    // console.log("title:" + titleSearch);
    let libraryVideos = JSON.parse(js);

    var searchResult = {};
    searchResult["list"] = [];

    if (characterSearch != "") {
        searchResult = searchByCharacter(characterSearch, searchResult, libraryVideos);
    } else {
        searchResult["list"] = libraryVideos["list"];
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
    newSearchResult["list"] = [];

    for (var i = 0; i < libraryVideos.list.length; i++) {
        var constantJson = libraryVideos.list[i];
        var ctitle = constantJson["title"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];

		if(ccharacter === character) {
		    var newEntry = {title: ctitle, character: ccharacter, url: curl};
		    newSearchResult["list"].push(newEntry);
        }
    }
    return newSearchResult;
}

function searchByTitle(title, searchResult) {
    var newSearchResult = {};
    newSearchResult["list"] = [];

    for (var i = 0; i < searchResult.list.length; i++) {
        var constantJson = searchResult.list[i];
        var ctitle = constantJson["title"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];

		if(ctitle.includes(title)) {
		    var newEntry = {title: ctitle, character: ccharacter, url: curl};
		    newSearchResult["list"].push(newEntry);
        }
    }
    return newSearchResult;
}

function processSearchVideoSegmentsResponse(result) {
	//console.log("res:" + result);
	//var js = JSON.parse(result);
	var videoList = document.getElementById('videoSegmentList');
	var libraryHeader = document.getElementById('LibraryHeader');

	var output = '';
	output += '<div class="row"><input type="button" id="switchToLibrary" value="Open Local Library" onclick="refreshVideoSegments()"></div>';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < result.list.length; i++) { // listOfSegments
		var constantJson = result.list[i];
		console.log(constantJson);

		var ctitle = constantJson["title"];
		var ccharacter = constantJson["character"];
		var curl = constantJson["url"];
		output += '<li><input type="radio" name="videoSegment" value="' + curl + '"><video width="320" height="240" controls><source src="' + curl +'" type="video/ogg"></video><br> Line:' + ctitle + '<br> Character: ' + ccharacter + '</li><br><br>';
	}
	output += '</ul>';
	videoList.innerHTML = output;
	libraryHeader.innerHTML = '<h3>Remote and Local Search</h3>';
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

