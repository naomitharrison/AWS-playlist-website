function addRemoteLibrary() {
    var libraryName = document.getElementById('remoteLibraryName').value;
    var libraryUrl = document.getElementById('remoteLibraryURL').value;

    var data = {};
    data["url"] = libraryUrl;
    data["name"] = libraryName;

    var js = JSON.stringify(data);
    console.log("JS:" + js);

    var req = new XMLHttpRequest();
    req.open("POST", remoteLibraries_url, true);
    req.send(js);
    req.onloadend = function () {
        console.log(req);
        console.log(req.request);

        if (req.readyState == XMLHttpRequest.DONE) {
            console.log("XHR:" + req.responseText);
            processAddRemoteLibraryResponse(
                req.responseText);
        } else {
            processAddRemoteLibraryResponse(
                "N/A");
        }

    }
}

function processAddRemoteLibraryResponse(result) {
    refreshRemoteLibraries();
    var libraryName = document.getElementById('remoteLibraryName');
    var libraryUrl = document.getElementById('remoteLibraryURL');

    libraryName.value = '';
    libraryUrl.value = '';
}