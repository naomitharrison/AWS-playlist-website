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

function processSearchVideoSegmentsResponse(result) {
	console.log("res:" + result);
	var js = JSON.parse(result);
	var videoList = document.getElementById('videoSegmentList');

	var output = '';
	output +='<ul style="list-style-type:none;">';
	for (var i = 0; i < js.listOfSegments.length; i++) { // listOfSegments
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