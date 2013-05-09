package edu.neumont.csc380.game;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TikTakToe {
	private static List<TikTakToe> GameList = new ArrayList<TikTakToe>();
	
	public static List<TikTakToe> GetGameList(){
		return GameList;
	}		
	private BigInteger player1;
	private BigInteger player2;
	private BigInteger winner;
	private Board board;	
	private boolean gameOver = false;
	
	public TikTakToe(BigInteger player1){
		GameList.add(this);
		this.player1 = player1; 
		board = new Board();
	}
	
	public void join(BigInteger player2){
		this.player2 = player2;
	}
	
	public void makeMove(BigInteger key, Move move){
		if(key == player1){
			board.placeX(move);
		}else if(key == player2){
			board.placeX(move);
		}
		checkIsGameOver();
	}
	
	private void checkIsGameOver(){
		if(board.isGameOver()){
			char victor = board.winner();
			if(victor == board.player1){
				winner = player1;
			}else if(victor == board.player2){
				winner = player2;
			}else{
				System.out.println("Derp in GameOver Checking");
			}
			endGame();
		}
	}
	
	private void endGame(){
		gameOver = true;
		GameList.remove(GameList.indexOf(this));
	}
	
	private BigInteger getWinner(){
		return winner;
	}
	
	private boolean isGameOver(){
		return gameOver;
	}

}