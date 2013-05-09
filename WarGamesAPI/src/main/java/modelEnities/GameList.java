package modelEnities;

import java.math.BigInteger;
import java.util.List;

public class GameList {
	private List<BigInteger> games;
	
	public void setGames(List<BigInteger> listOfGameIds){
		games = listOfGameIds;
	}
	
	public List<BigInteger> getGames(){
		return games;
	}
}
