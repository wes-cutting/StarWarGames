package contract;

import java.math.BigInteger;

/**
 * 
 * @author cstephenson
 * This is the signable interface implemented by the MoveRequest
 * This interface is used to retrieve the signature and public key
 */


public interface Signable {
	String getSignature();
	BigInteger getPublicKey();
}
