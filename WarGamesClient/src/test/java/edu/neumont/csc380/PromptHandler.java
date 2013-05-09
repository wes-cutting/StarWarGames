package edu.neumont.csc380;

import java.util.Scanner;

public class PromptHandler {
	
	private static final int NEW_GAME = 0;
	private static final int SINGLE_PLAYER = 1;
	private static final int SINGLE_PLAYER_EASY = 11;
	private static final int SINGLE_PLAYER_MEDIUM = 12;
	private static final int SINGLE_PLAYER_HARD = 13;
	private static final int MULTIPLAYER = 2;
	private static final int MULTIPLAYER_CREATE = 21;
	private static final int MULTIPLAYER_SEARCH = 22;
	private static final int GAME_EXIT = 3;
	
	static Scanner scan = new Scanner(System.in);
	
	public int start(){ 
		int startMode = 0;
		System.out.println("Welcome to Tic Tac Toe! Choose an option..." + "\n1: Single Player\n2: Head-to-Head\n3: Exit");
		int choice = scan.nextInt();
		switch(choice){
		case SINGLE_PLAYER:
			startMode = handleSinglePlayer();
			break;	
		case MULTIPLAYER:
			startMode = handleMultiplayer();
			break;
		case GAME_EXIT:
			handleExitPrompt();
			break;
		default:
			System.out.println("Not a valid selection, try again.");
			start();
			break;
		}
		return startMode;
	}
	
	private int handleSinglePlayer(){
		int status = 0; 
		System.out.println("Choose AI Difficulty: \n1. Easy \n2.Medium \n3.Hard");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			System.out.println("You chose Easy");
			status = SINGLE_PLAYER_EASY;
			break;
		case 2:
			System.out.println("You chose Easy");
			status = SINGLE_PLAYER_MEDIUM;
			break;
		case 3:
			System.out.println("You chose Hard");
			status = SINGLE_PLAYER_HARD;
			break;
		default:
			System.out.println("Not a valid selection, try again.");
			handleSinglePlayer();
			break;
		}
		return status;
	}
	
	private int handleMultiplayer(){
		int status = 0;
		System.out.println("Welcome to TTT Multiplayer. \n1: Create Game? \n2: Find Game");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			System.out.println("Creating New Game...");
			status = MULTIPLAYER_CREATE;
			break;
		case 2:
			System.out.println("Retrieving Active Games...");
			status = MULTIPLAYER_SEARCH;
			break;
		default:
			System.out.println("Not a valid selection, try again.");
			handleMultiplayer();
			break;
		}
		return status;
	}
	
	private void handleExitPrompt(){
		System.out.println("Are you sure? 1: Yes \n2: No");
		int choice = scan.nextInt();
		switch(choice){
		case 1:
			System.out.println("Bye!");
			System.exit(0);
			break;
		case 2:
			start();
			break;
		default:
			System.out.println("Not a valid selection, try again.");
			break;
		}
	}
}
