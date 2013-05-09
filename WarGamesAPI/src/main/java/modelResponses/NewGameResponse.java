package modelResponses;

import modelEnities.Board;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement(name="NewGameResponse")
@XmlSeeAlso(value={NewGameResponse.class})
public class NewGameResponse {
	@XmlElement
	private int gameId;
	@XmlElement
	private Board borad;

	@XmlTransient
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	@XmlTransient
	public Board getBorad() {
		return borad;
	}

	public void setBorad(Board borad) {
		this.borad = borad;
	}

}
