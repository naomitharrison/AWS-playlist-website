function toggleRemoteStatus() {
    var remoteStatusSelection = document.getElementsByTagName('input');
    var data = {};
    data["checkboxes"] = [];
    data["videoUrls"] = [];

    for (var i = 0; i < remoteStatusSelection.length; i++) {
        if (remoteStatusSelection[i].type == "checkbox"
            && remoteStatusSelection[i].name == "remoteStatus") {
            data["checkboxes"].push({"checkbox": remoteStatusSelection[i].checked});
            data["videoUrls"].push({"url": remoteStatusSelection[i].value});
        }
    }

	var js = JSON.stringify(data);
    console.log("JS:" + js);
    var req = new XMLHttpRequest();
    req.open("POST", remoteStatusToggle_url, true);
    req.send(js);
    req.onloadend = function () {
        console.log(req);
        console.log(req.request);
        if (req.readyState == XMLHttpRequest.DONE) {
            console.log("XHR:" + req.responseText);
            processSetRemoteStatusResponse(req.responseText);
        } else {
            processSetRemoteStatusResponse("N/A");
        }
    }
}

function processSetRemoteStatusResponse() {
    refreshAdminVideoSegments();
}
