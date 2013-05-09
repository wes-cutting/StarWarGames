package modelResponses;

import modelEnities.Board;

public class NewGameResponse {
	private int gameId;

	private Board borad;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public Board getBorad() {
		return borad;
	}

	public void setBorad(Board borad) {
		this.borad = borad;
	}

}
