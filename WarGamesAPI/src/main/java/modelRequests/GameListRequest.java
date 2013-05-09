package modelRequests;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


/**
 * This calls is used to request a list of games
 * @author cstephenson
 *
 */

@XmlRootElement(name = "GameListRequest")
@XmlSeeAlso(value={GameListRequest.class})
public class GameListRequest {
	@XmlElement
	public BigInteger publicKey;
	
	@XmlTransient
	public BigInteger getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}
}
