package edu.neumont.csc380.game;

import modelEnities.Board;

public class GameBoard extends Board{

	public char player1 = 'X';
	public char player2 = 'O';
	private char noWinner = 'N';
	private char placeHolder = 'P';
	private char winningChar = placeHolder;
	
	public GameBoard(){
		board = new char[3][3];
	}
	
	/**
	 * Places an X in the given row and column position
	 * @param row
	 * @param col
	 */
	public void placeX(Move move){
		board[move.getRow()][move.getColumn()] = player1;
	}
	
	/**
	 * Places an O in the given row and column position
	 * @param row
	 * @param col
	 */
	public void placeO(Move move){
		board[move.getRow()][move.getColumn()] = player2;
	}
	
	/**
	 * Returns the char of the winning player if one exists
	 * 'X' for player 1
	 * 'O' for player 2
	 * @return
	 */
	public char winner(){
		char winner = noWinner;
		if(!(winningChar == placeHolder)){
			winner = winningChar;
		}
		return winner;
	}
	
	/**
	 * Checks if Game winning conditions have been met
	 * @return
	 */
	public boolean isGameOver(){
		boolean result = false;
		result = playerChecks(player1);
		if(!result){
			result = playerChecks(player2);
		}
		return result;
	}
	
	/**
	 * Checks all possible winning conditions for the given player
	 * @param player
	 * @return
	 */
	private boolean playerChecks(char player){
		boolean result = false;
		if(!result){
			for(int i = 0; i < board.length; i ++){
				if(horizontalCheck(i, player))
					result = true;
			}
		}
		if(!result){
			for(int i = 0; i < board.length; i ++){
				if(verticalCheck(i, player))
					result = true;
			}
		}
		
		if(!result){
			for(int i = 0; i < board.length; i ++){
				if(diagonalChecks(player))
					result = true;
			}
		}
		if(result){
			winningChar = player;
		}
		return result;
	}
		
	/**
	 * Checks the given row to see if the given player is the winner
	 * @param row
	 * @param player
	 * @return
	 */
	private boolean horizontalCheck(int row, char player){
		boolean result = false;
		int count = 0;
		for(int i = 0; i < board.length; i ++)
			if(board[row][i] == player)
				count ++;
		if(count == 2)
			result = true;
		return result;
	}
	
	/**
	 * Checks the given column to see if the given player is the winner
	 * @param col
	 * @param player
	 * @return
	 */
	private boolean verticalCheck(int col, char player){
		boolean result = false;
		int count = 0;
		for(int i = 0; i < board.length; i ++)
			if(board[i][col] == player)
				count ++;
		if(count == 2)
			result = true;
		return result;
	}
	
	/**
	 * Checks for a winner in both Diagonals
	 * Checks to see if the given player is a winner
	 * @param player
	 * @return
	 */
	private boolean diagonalChecks(char player){
		boolean result = leftDiagonal(player);
		if(!result)
			result = rightDiagonal(player);
		return result;
	}
	
	/**
	 * Checks the diagonal starting in the top left
	 * Checks to see if the given player is a winner
	 * @param player
	 * @return boolean
	 */
	private boolean leftDiagonal(char player){
		boolean result = false;
		int count = 0;
		for(int i = 0; i < board.length; i ++)
			if(board[i][i] == player)
				count ++;
		if(count == 2)
			result = true;
		return result;
	}
	
	/**
	 * Checks the diagonal starting in the top right
	 * Checks to see if the given player is a winner
	 * @param player
	 * @return boolean
	 */
	private boolean rightDiagonal(char player){
		boolean result = false;
		int count = 0;
		for(int i = 0; i < board.length; i ++)
			if(board[board.length - i][i] == player)
				count ++;
		if(count == 2)
			result = true;
		return result;
	}
}
