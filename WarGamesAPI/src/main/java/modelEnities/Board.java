package modelEnities;



/**
 * This class is the Board entity used to represent the board in move 
 * requests and move responses.
 * @author cstephenson
 *
 */

public class Board {
	protected char[][] board;

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

}
