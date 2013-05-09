package modelResponses;

import modelEnities.Board;

public class MoveResponse {
	private int gameId;

	private Board board;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
