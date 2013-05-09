package modelRequests;

import java.math.BigInteger;

public class JoinGameRequest {
	private int gameId;
	public BigInteger publicKey;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public BigInteger getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}

}
