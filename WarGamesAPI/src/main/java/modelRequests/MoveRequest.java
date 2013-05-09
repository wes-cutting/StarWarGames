package modelRequests;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

import contract.Signable;



/**
 * This class represents the MoveRequest sent by the client to make a move on the board.
 * @author cstephenson
 *
 */
@XmlRootElement(name="MoveRequest")
@XmlSeeAlso(value={MoveRequest.class})
public class MoveRequest implements Signable {
	@XmlElement
	public BigInteger publicKey;
	@XmlElement
	private int moveRow;
	@XmlElement
	private int moveCol;
	@XmlElement
	private String signature;

	@XmlTransient
	public BigInteger getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}
	@XmlTransient
	public int getMoveRow() {
		return moveRow;
	}

	public void setMoveRow(int moveRow) {
		this.moveRow = moveRow;
	}
	@XmlTransient
	public int getMoveCol() {
		return moveCol;
	}

	public void setMoveCol(int moveCol) {
		this.moveCol = moveCol;
	}
	@XmlTransient
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
