package edu.neumont.csc380.game;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * The chief game class that handles input, players and the gameboard
 * @author wcutting
 *
 */
public class TikTakToe {
	private static List<TikTakToe> GameList = new ArrayList<TikTakToe>();
	private static int idCounter = 1;
	
	public static List<TikTakToe> GetGameList(){
		return GameList;
	}		
	private BigInteger player1;
	private BigInteger player2;
	private BigInteger winner;
	private GameBoard board;	
	private boolean gameOver = false;
	private int id;
	
	public TikTakToe(BigInteger player1){
		GameList.add(this);
		id = idCounter;
		idCounter++;
		this.player1 = player1; 
		board = new GameBoard();
	}
	
	public int getId(){
		return id;
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
	
	public GameBoard getBoard(){
		return board;
	}

}
