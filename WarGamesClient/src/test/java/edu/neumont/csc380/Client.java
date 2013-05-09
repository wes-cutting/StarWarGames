package edu.neumont.csc380;

import java.awt.Point;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import modelRequests.EndGameRequest;
import modelRequests.GameListRequest;
import modelRequests.MoveRequest;
import modelRequests.NewGameRequest;
import modelResponses.EndGameResponse;
import modelResponses.GameListResponse;
import modelResponses.MoveResponse;
import modelResponses.NewGameResponse;

import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.neumont.csc380.service.EspionageService;

@ContextConfiguration(locations = "beans.xml")
public class Client extends AbstractJUnit4SpringContextTests {
	@Autowired ProducerTemplate camelTemplate;
	@Autowired EspionageService espionageService;
	Board board = null;
	List<Integer> gameList = null;

	@Test
	public void test() {
		start();
//		do{
//			
//		}while();
	}

	/**
	 * @param args
	 */

	Scanner input = new Scanner(System.in);

	public void start() {
		String startMode = new PromptHandler().start() + "";
		int publicKey = espionageService.getP("blah");
		int privateKey = espionageService.getQ("blah");
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
			// Send request to create a game
			System.out.println("Send request to create a game");
			board = makeNewGame(BigInteger.valueOf(publicKey));
			break;
		case "22":
			// Send request to retrieve all active games
			System.out.println("Send request to retrieve all active games");
			gameList = getActiveGames(BigInteger.valueOf(publicKey));
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
		return (Board) response.getBoard();
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
		//Need a signing method
		MoveResponse response = camelTemplate.requestBody("jms:queue:game",
				request, MoveResponse.class);
		return (Board) response.getBoard();
	}
	
	/**
	 * Request to check for the end game
	 * @return
	 */
	public BigInteger hasGameEnded(BigInteger publicKey){
		//Need an end game request
		EndGameRequest request = new EndGameRequest();
		request.setPublicKey(publicKey);
		request.setSignature();
		EndGameResponse response = camelTemplate.requestBody("jms:queue:game", EndGameResponse.class);
	}
//
//	/**
//	 * Retrieves the public and private keys from Key Generation Service
//	 */
//	public BigInteger getKeys() {
//		return 
//	}

}
