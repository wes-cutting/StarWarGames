package edu.neumont.csc380;

import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
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
	 * @throws Exception - Message null or = 0
	 */
	public static String Encrypt(String m, BigInteger n, BigInteger e) throws Exception {//, String d) {
		String encryptedMsg = "";
		if(m != null && m.length() <= 0)
			throw new Exception("Message needs to be longer than nothing");
		for (int i = 0; i < m.length(); i++) {
			char letter = m.charAt(i);
			BigInteger c = BigInteger.valueOf(letter);
			String item = c.modPow(e, n).toString();
			encryptedMsg += " "+item;
		}
		return encryptedMsg;
	}
	
	/**
	 * Signs a message with a private key.
	 * @param m - Message to be signed
	 * @param n - Two prime numbers multiplied together
	 * @param d - Private key
	 * @return Signed Payload
	 * @throws Exception - 
	 */
	public static String Sign(String m, BigInteger n, BigInteger d) throws Exception {
		String encryptedMsg = "";
		if(m != null && m.length() <= 0)
			throw new Exception("Message needs to be longer than nothing");
		for (int i = 0; i < m.length(); i++) {
			char letter = m.charAt(i);
			BigInteger c = BigInteger.valueOf(letter);
			String item = c.modPow(d, n).toString();
			encryptedMsg += " "+item;
		}
		return encryptedMsg;
	}
	/**
	 * Decrypts a message.
	 * @param encMSG - The encoded message
	 * @param n - Modulus value
	 * @param d - Private Key
	 * @return
	 */
	public static String Decrypt(String encMSG, BigInteger n, BigInteger d) {
		String decoded = "";
		String[] ecs = encMSG.split(" ");
		for (String string : ecs) {
			if(string.isEmpty())
				continue;
			BigInteger charvalue = new BigInteger(string);
			BigInteger c = charvalue.modPow(d, n);
			decoded += (char)c.longValue();
		}
		return decoded;
	}
	/**
	 * Verifies if the XML is 
	 * @param m
	 * @return
	 */
	public static boolean isVerified(String m) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(m);
		} catch (ParserConfigurationException e1) {
			return false;
		} catch (SAXException e1) {
			return false;
		} catch (IOException e1) {
			return false;
		}
		
		return true;
	}
	/**
	 * Decrypts the signing and returns the result
	 * @param m - Signed Message
	 * @param n - Modulus
	 * @param e - public key
	 * @return
	 */
	public static String UnSign(String m, BigInteger n, BigInteger e) {
		String decoded = "";
		String[] ecs = m.split(" ");
		for (String string : ecs) {
			if(string.isEmpty())
				continue;
			BigInteger charvalue = new BigInteger(string);
			BigInteger c = charvalue.modPow(e, n);
			decoded += (char)c.longValue();
		}
		return decoded;
	}
}