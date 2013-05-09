package modelRequests;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * The client can send this request to join an already existing game
 * @author cstephenson
 *
 */


@XmlRootElement(name="JoinGameRequest")
@XmlSeeAlso(value= {JoinGameRequest.class})
public class JoinGameRequest {
	@XmlElement
	private int gameId;
	@XmlElement
	public BigInteger publicKey;

	@XmlTransient
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	@XmlTransient
	public BigInteger getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}

}
