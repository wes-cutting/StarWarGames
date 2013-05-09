package contract;

import modelRequests.GameListRequest;
import modelRequests.JoinGameRequest;
import modelRequests.MoveRequest;
import modelRequests.NewGameRequest;
import modelResponses.EndGameResponse;
import modelResponses.GameListResponse;
import modelResponses.MoveResponse;
import modelResponses.NewGameResponse;

public interface TicTacToeInterface {

	public void getGameList(GameListRequest glr);

	public void joinGame(JoinGameRequest jgr);

	public void moveRequest(MoveRequest mr);

	public void newGameRequest(NewGameRequest ngr);

	public void endGame(EndGameResponse egr);

	public void sendGameList(GameListResponse glr);

	public void moveResponse(MoveResponse mr);

	public void newGameResponse(NewGameResponse ngr);

}
