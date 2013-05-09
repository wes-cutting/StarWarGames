package modelRequests;

import java.math.BigInteger;

public class NewGameRequest {
	public BigInteger publicKey;

	public BigInteger getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}

}
