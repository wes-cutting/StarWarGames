package contract;

import java.math.BigInteger;

public interface Signable {
	String getSignature();
	BigInteger getPublicKey();
}
