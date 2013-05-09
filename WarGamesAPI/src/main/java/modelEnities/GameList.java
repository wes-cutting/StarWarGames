package modelEnities;

import java.math.BigInteger;
import java.util.List;

public class GameList {
	private List<Integer> games;
	
	public void setGames(List<Integer> listOfGameIds){
		games = listOfGameIds;
	}
	
	public List<Integer> getGames(){
		return games;
	}
}
