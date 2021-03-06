package contract;

import modelEnities.GameList;
import modelRequests.GameListRequest;
import modelRequests.JoinGameRequest;
import modelRequests.MoveRequest;
import modelRequests.NewGameRequest;
import modelResponses.EndGameResponse;
import modelResponses.GameListResponse;
import modelResponses.MoveResponse;
import modelResponses.NewGameResponse;

/**
 * This interface is the contract between the server and client
 * The interface contains each request and response used by the client and server
 * @author cstephenson
 *
 */


public interface TicTacToeInterface {

	public GameList getGameList(GameListRequest glr);

	public MoveResponse joinGame(JoinGameRequest jgr);

	public MoveResponse moveRequest(MoveRequest mr);

	public NewGameResponse newGameRequest(NewGameRequest ngr);

	public void endGame(EndGameResponse egr);

	public void sendGameList(GameListResponse glr);

	public void moveResponse(MoveResponse mr);

	public void newGameResponse(NewGameResponse ngr);

	public void getSignature();
	
	public void setSignature();
}
