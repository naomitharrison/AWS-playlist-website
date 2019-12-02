// all access driven through BASE. Must end with a SLASH
// be sure you change to accommodate your specific API Gateway entry point
var base_url = "    https://r4p7e3f5f7.execute-api.us-east-1.amazonaws.com/G_2_5/"; 

var videos_url    = base_url + "videoSegments";   // GET
var playlists_url = base_url + "playlists";     // GET
var playlistVideoSegments_url = base_url + "playlistVideoSegments"; // POST
var remoteLibraries_url = base_url + "remoteLibrary"; // GET + POST
var searchVideoSegments_url = base_url + "searchVideoSegments"; // POST

