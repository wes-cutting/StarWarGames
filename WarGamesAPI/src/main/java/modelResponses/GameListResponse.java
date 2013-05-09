package modelResponses;

import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="GameListResponse")
@XmlSeeAlso(value={GameListResponse.class})
public class GameListResponse {
	@XmlElement
	public List<Integer> gameList;

	@XmlTransient
	public List<Integer> getGameList() {
		return gameList;
	}

	public void setGameList(List<Integer> gameList) {
		this.gameList = gameList;
	}

}
