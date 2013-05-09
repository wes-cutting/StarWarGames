package modelResponses;


import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="EndGameResponse")
@XmlSeeAlso(value={EndGameResponse.class})
public class EndGameResponse {
	
	@XmlElement
	public BigInteger winningPlayerPublicKey;
	@XmlElement
	private int gameId;

	@XmlTransient
	public BigInteger getWinningPlayerPublicKey() {
		return winningPlayerPublicKey;
	}

	public void setWinningPlayerPublicKey(BigInteger winningPlayerPublicKey) {
		this.winningPlayerPublicKey = winningPlayerPublicKey;
	}

	@XmlTransient
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
