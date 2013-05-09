package edu.neumont.csc380;

import java.awt.Point;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import modelRequests.*;
import modelResponses.*;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "beans.xml")
public class Client extends AbstractJUnit4SpringContextTests {
	@Autowired
	ProducerTemplate camelTemplate;
	Board board = null;
	List<Integer> gameList = null;

	@Test
	public void test() {
		start();
		do{
			
		}while();
	}

	/**
	 * @param args
	 */

	Scanner input = new Scanner(System.in);

	// add a menu state?

	public void start() {
		// GetKeys
		BigInteger publicKey = null;
		String startMode = new PromptHandler().start() + "";
		switch (startMode) {
		
		case "11":
			// Send request to start a game with easy AI

			break;
		case "12":
			// Send request to start a game with medium AI

			break;
		case "13":
			// Send request to start a game with hard AI
			
			break;
		case "21":
			// Send request to retrieve to create a game
			board = makeNewGame(publicKey);
			break;
		case "22":
			// Send request to retrieve all active games
			gameList = getActiveGames(publicKey);
			break;
		}
	}

	/**
	 * Gets all active games
	 */
	public List<Integer> getActiveGames(BigInteger publicKey) {
		GameListRequest request = new GameListRequest();
		request.setPublicKey(publicKey);			
		GameListResponse response = camelTemplate.requestBody("jms:queue:game",
				request, GameListResponse.class);
		return response.getGameList();
	}

	/**
	 * Makes a new game request and gets the board
	 */
	public Board makeNewGame(BigInteger publicKey) {
		NewGameRequest request = new NewGameRequest();
		request.setPublicKey(publicKey);
		NewGameResponse response = camelTemplate.requestBody("jms:queue:game",
				request, NewGameResponse.class);
		return (Board) response.getBorad();
	}
	
	/**
	 * Sends a move request
	 * @param publicKey used to sign the request
	 * @return
	 */
	public Board makeMove(BigInteger publicKey){
		
		Point pos = board.placePiece();
		MoveRequest request = new MoveRequest();
		request.setMoveRow(pos.x);
		request.setMoveCol(pos.y);
		request.setPublicKey(publicKey);
		MoveResponse response = camelTemplate.requestBody("jms:queue:game",
				request, MoveResponse.class);
		return (Board) response.getBoard();
	}
	
	/**
	 * Request to check for the end game
	 * @return
	 */
	public BigInteger hasGameEnded(){
		//
		EndGameResponse response = camelTemplate.requestBody("jms:queue:game", EndGameResponse.class);
	}

	/**
	 * Retrieves the public and private keys from Key Generation Service
	 */
	public BigInteger getKeys() {
		return 
	}

}
