package modelResponses;

import java.math.BigInteger;

public class EndGameResponse {
	public BigInteger winningPlayerPublicKey;
	private int gameId;

	public BigInteger getWinningPlayerPublicKey() {
		return winningPlayerPublicKey;
	}

	public void setWinningPlayerPublicKey(BigInteger winningPlayerPublicKey) {
		this.winningPlayerPublicKey = winningPlayerPublicKey;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
