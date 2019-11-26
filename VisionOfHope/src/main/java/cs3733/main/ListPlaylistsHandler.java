package cs3733.main;

import java.util.List;

import com.amazonaws.services.lambda.runtime.*;

import cs3733.main.DB.PlaylistsDAO;
import cs3733.main.http.ListPlaylistRequest;
import cs3733.main.http.ListPlaylistResponse;
import cs3733.main.model.Playlist;

public class ListPlaylistsHandler implements RequestHandler<ListPlaylistRequest,ListPlaylistResponse>{
	
	public LambdaLogger logger;

	List<Playlist> getPlaylists() throws Exception {
		logger.log("in getPlaylists");
		PlaylistsDAO dao = new PlaylistsDAO();
		
		return dao.listAllPlaylists();
	}

	@Override
	public ListPlaylistResponse handleRequest(ListPlaylistRequest input, Context context) {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all playlists");

		ListPlaylistResponse response;
		try {
			List<Playlist> list = getPlaylists();
			response = new ListPlaylistResponse(list, 200);
		} catch (Exception e) {
			response = new ListPlaylistResponse(403, e.getMessage());
		}
		
		return response;
	}

}
