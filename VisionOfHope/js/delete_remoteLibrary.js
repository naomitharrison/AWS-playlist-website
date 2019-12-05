function deleteRemoteLibrary() {
    var remoteLibrarySelection = document.getElementsByTagName('input');

	for (var i = 0; i < remoteLibrarySelection.length; i++) {
		if (remoteLibrarySelection[i].type == "radio"
				&& remoteLibrarySelection[i].name == "remoteLibrary") {

			if (remoteLibrarySelection[i].checked) {
				var data = {};
				data["url"] = remoteLibrarySelection[i].value;

				var js = JSON.stringify(data);
				console.log("JS:" + js);
				var req = new XMLHttpRequest();
				req.open("POST", removeRemoteLibrary_url, true);
				req.send(js);
				req.onloadend = function() {
					console.log(req);
					console.log(req.request);

					if (req.readyState == XMLHttpRequest.DONE) {
						console.log("XHR:" + req.responseText);
						processDeleteLibraryResponse(
								req.responseText);
					} else {
						processDeleteLibraryResponse(
								data.name, "N/A");
					}
				};

			}
		}
	}
}

function processDeleteLibraryResponse() {
    refreshRemoteLibraries();
}