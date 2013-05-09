package edu.neumont.csc380;

import java.util.Scanner;

public class Board {
	public static final int BOARD_ROWS = 3;
	public static final int BOARD_COLS = 3;

	String[][] board = new String[3][3];
	Scanner scan = new Scanner(System.in);

	/**
	 * Checks to see if a piece already exists on the spot which the player
	 * would like to place her/her piece
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isValidMove(int row, int col) {
		return board[col][row] == null;
	}

	/**
	 * Method that allows a player to place their piece on the game board
	 * 
	 * @param piece
	 * @return
	 */
	public String[][] placePiece(String piece) {
		System.out.println("Where to move?");
		boolean valid = false;
		do {
			System.out
					.println("Enter the row and column of your move separated by a comma. Ex: 1,3");
			drawBoard();
			String[] move = scan.nextLine().split(",");
			int row = Integer.parseInt(move[0]);
			int col = Integer.parseInt(move[1]);
			if (isValidMove(row, col)) {
				board[row][col] = piece;
				valid = true;
			} else {
				System.out.println("There's already a piece here, try again.");
			}
		} while (!valid);
		drawBoard();
		return board;
	}

	/**
	 * Draws the game board
	 */
	public void drawBoard() {
		for (int i = 0; i < BOARD_ROWS; i++) {
			for (int j = 0; j < BOARD_COLS; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}