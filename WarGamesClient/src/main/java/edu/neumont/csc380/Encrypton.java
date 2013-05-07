package edu.neumont.csc380;

import java.math.BigInteger;
/**
 * A static class that helps Encrypting and Signing data.
 * @author Rouska
 *
 */
public class Encrypton {
	
	/** 
	 * Encrpts data using the Public Key
	 * @param message - The Payload to be encrypted
	 * @param n - Two prime numbers multiplied together
	 * @param e - Public key to use for ecryption
	 * @return Encrypted Payload
	 */
	public static String Encrypt(String message, BigInteger n, BigInteger e) {//, String d) {
		String encrypted = "";
		
		for(int i =0; i< message.length(); i++) {
			char letter = message.charAt(i);
			BigInteger charvalue = BigInteger.valueOf(letter);
			String c = charvalue.modPow(e, n).toString();
			String temp = "";
			while(c.length() < 4) {
				temp = "0" + c;
			}
			encrypted += temp;
		}
		return encrypted;
	}
	/**
	 * Signs a message with a private key.
	 * @param payload - Message to be signed
	 * @param n - Two prime numbers multiplied together
	 * @param d - Private key
	 * @return Signed Payload
	 */
	public static String Sign(String payload, BigInteger n, BigInteger d) {
		String signedData = "";
		
		for(int i =0; i< payload.length(); i++) {
			char letter = payload.charAt(i);
			BigInteger charvalue = BigInteger.valueOf(letter);
			String c = charvalue.modPow(d, n).toString();
			String temp = "";
			while(c.length() < 4) {
				temp = "0" + c;
			}
			signedData += temp;
		}
		return signedData;
	}
}
