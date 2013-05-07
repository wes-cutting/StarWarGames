package edu.neumont.csc380.game;

public class Board {

	public char[][] board;
	public char player1 = 'X';
	public char player2 = 'O';
	public char noWinner = 'N';
	public char placeHolder = 'P';
	public char winningChar = placeHolder;
	
	public Board(){
		board = new char[3][3];
	}
	
	public void placeX(int row, int col){
		board[row][col] = player1;
	}
	
	public void placeO(int row, int col){
		board[row][col] = player2;
	}
	
	public boolean isGameOver(){
		return false;
	}
	
	public char winner(){
		char winner = noWinner;
		if(!(winningChar == placeHolder)){
			winner = winningChar;
		}
		return winner;
	}
	
	private boolean horizontalCheck(int row){
		return false;
	}
	
	private boolean verticalCheck(int col){
		return false;
	}
	
	private boolean diagonalChecks(){
		return false;
	}
}
