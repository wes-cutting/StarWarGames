package modelEnities;

import java.math.BigInteger;
import java.util.List;


/**
 * This class is an abstraction for the list of games
 * @author wcutting
 *
 */

public class GameList {
	private List<Integer> games;
	
	public void setGames(List<Integer> listOfGameIds){
		games = listOfGameIds;
	}
	
	public List<Integer> getGames(){
		return games;
	}
}
