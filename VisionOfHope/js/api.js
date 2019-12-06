// all access driven through BASE. Must end with a SLASH
// be sure you change to accommodate your specific API Gateway entry point
var base_url = "  https://w0bv9ygw0b.execute-api.us-east-1.amazonaws.com/G_3_5/"; 

var videos_url    = base_url + "videoSegments";   // GET + POST
var playlists_url = base_url + "playlists";     // GET + POST
var playlistVideoSegments_url = base_url + "playlistVideoSegments"; // POST
var remoteLibraries_url = base_url + "remoteLibrary"; // GET + POST
//var searchVideoSegments_url = base_url + "searchVideoSegments"; // POST
var deleteVideoSegment_url = base_url + "videoSegmentRemove"; // POST
var deletePlaylist_url = base_url + "playlistRemove"; // POST
var appendPlaylist_url = base_url + "playlistVideoSegmentAppend"; // POST
var removeVideoPlaylist_url = base_url + "playlistVideoSegmentRemove"; // POST
var removeRemoteLibrary_url = base_url + "remoteLibraryRemove"; // POST
var remoteStatusToggle_url = base_url + "videoSegmentRemoteStatus"; // POST


