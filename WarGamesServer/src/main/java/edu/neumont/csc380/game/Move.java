package edu.neumont.csc380.game;

public class Move {
	private int row;
	private int col;
	
	public Move(int r, int c){
		row = r;
		col = c;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return col;
	}
}
