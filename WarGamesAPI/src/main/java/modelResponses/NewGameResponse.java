package modelResponses;

import modelEnities.Board;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This response serves as a notification that the a game has been created
 * @author cstephenson
 *
 */

@XmlRootElement(name="NewGameResponse")
@XmlSeeAlso(value={NewGameResponse.class})
public class NewGameResponse {
	@XmlElement
	private int gameId;
	@XmlElement
	private Board board;

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

}
