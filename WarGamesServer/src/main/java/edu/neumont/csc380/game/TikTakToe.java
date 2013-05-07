package edu.neumont.csc380.game;

import java.util.ArrayList;
import java.util.List;

public class TikTakToe {
	private static List<TikTakToe> GameList = new ArrayList<TikTakToe>();
	
	public static List<TikTakToe> GetGameList(){
		return GameList;
	}	
	
	public Player player1;
	public Player player2;
	
	public TikTakToe(Player player1){
		GameList.add(this);
		this.player1 = player1; 
	}
	
	public void join(Player player2){
		this.player2 = player2;
	}
	
	private void endGame(){
		GameList.remove(GameList.indexOf(this));
	}

}
