package modelRequests;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


/**
 * This request will create a game that another client can join
 * @author cstephenson
 *
 */
@XmlRootElement(name="NewGameRequest")
@XmlSeeAlso(value={NewGameRequest.class})
public class NewGameRequest {
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
