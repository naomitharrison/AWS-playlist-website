function addVideoSegment() {
    var videoTitle = document.getElementById('videoSegmentTitle').value;
    var videoCharacter = document.getElementById('videoSegmentCharacter').value;
    var videoBase64 = document.getElementById('Base64').value.split(',');;

    var data = {};
    data["title"] = videoTitle;
    data["character"] = videoCharacter;
    data["base64EncodedValue"] = videoBase64[1];
    

    var js = JSON.stringify(data);
    console.log("JS:" + js);

    var req = new XMLHttpRequest();
    req.open("POST", videos_url, true);
    req.send(js);
    req.onloadend = function () {
        console.log(req);
        console.log(req.request);

        if (req.readyState == XMLHttpRequest.DONE) {
            console.log("XHR:" + req.responseText);
            processaddVideoSegmentResponse(
                req.responseText);
        } else {
        	processaddVideoSegmentResponse(
                "N/A");
        }

    }
}

function processaddVideoSegmentResponse(result) {
    refreshVideoSegments();
    var videoTitle = document.getElementById('videoSegmentTitle').value;
    var videoCharacter = document.getElementById('videoSegmentCharacter').value;
    var videoBase64 = document.getElementById('Base64').value.split(',');
    document.getElementById('videoFile').value = '';

    videoTitle.value = '';
    videoCharacter.value = '';
    videoBase64.value = '';
}