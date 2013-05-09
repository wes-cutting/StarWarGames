package modelRequests;


import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name = "EndGameRequest")
@XmlSeeAlso(value={EndGameRequest.class})
public class EndGameRequest {
	@XmlElement
	private String signature;
	@XmlElement
	private int gameId;
	@XmlElement
	public BigInteger publicKey;
	
	@XmlTransient
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
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
