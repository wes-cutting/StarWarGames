package modelResponses;

import modelEnities.Board;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class is the response sent by the server to indicate to the client
 * that it is their turn. The response contains the most current board
 * @author cstephenson
 *
 */

@XmlRootElement(name="MoveResponse")
@XmlSeeAlso(value={MoveResponse.class})
public class MoveResponse {
	@XmlElement
	private int gameId;
	@XmlElement
	private Board board;
	@XmlElement
	private boolean isGameOver;

	@XmlTransient
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	@XmlTransient
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	@XmlTransient
	public boolean getIsGameOver(){
		return isGameOver;
	}
	
	public void setIsGameOver(boolean gameOver){
		isGameOver = gameOver;
	}

}
