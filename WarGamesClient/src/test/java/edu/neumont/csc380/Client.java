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
	@Autowired
	ProducerTemplate producerTemp;
	@Autowired
	EspionageService espionageService;
	Board board = null;
	List<Integer> gameList = null;
	BigInteger publicKey;
	BigInteger privateKey;

	@Test
	public void test() {
		start();
		while (!gameOver(publicKey)) {
			//if you made the game
			if(){
				makeMove(publicKey);
			}
			//If you found one...
			else{
				
			}
		}
		
	}

	/**
	 * @param args
	 */

	Scanner input = new Scanner(System.in);

	public void start() {
		String startMode = new PromptHandler().start() + "";
		publicKey = BigInteger.valueOf(espionageService.getP("blah"));
		privateKey = BigInteger.valueOf(espionageService.getQ("blah"));
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
			makeNewGame(publicKey);
			break;
		case "22":
			// Send request to retrieve all active games
			System.out.println("Send request to retrieve all active games");
			gameList = getActiveGames(publicKey);
			break;
		}
	}

	/**
	 * Makes a new game request and gets the board
	 */
	public void makeNewGame(BigInteger publicKey) {
		NewGameRequest request = new NewGameRequest();
		request.setPublicKey(publicKey);
		producerTemp.asyncSendBody("jms:queue:game", request);
	}
	
	/**
	 * Gets all active games
	 */
	public List<Integer> getActiveGames(BigInteger publicKey) {
		GameListRequest request = new GameListRequest();
		request.setPublicKey(publicKey);
		GameListResponse response = producerTemp.requestBody("jms:queue:game",
				request, GameListResponse.class);
		return response.getGameList();
	}

	

	/**
	 * Sends a move request
	 * 
	 * @param publicKey
	 *            used to sign the request
	 * @return
	 */
	public Board makeMove(BigInteger publicKey) {

		Point pos = board.placePiece();
		MoveRequest request = new MoveRequest();
		request.setMoveRow(pos.x);
		request.setMoveCol(pos.y);
		request.setPublicKey(publicKey);
		// Need a signing method
		MoveResponse response = producerTemp.requestBody("jms:queue:game",
				request, MoveResponse.class);
		return (Board) response.getBoard();
	}

	/**
	 * Request to check for the end game
	 * 
	 * @return
	 */
	public boolean gameOver(BigInteger publicKey) {
		// Need an end game request
		EndGameRequest request = new EndGameRequest();
		request.setPublicKey(publicKey);
		EndGameResponse response = producerTemp.requestBody("jms:queue:game",
				request, EndGameResponse.class);
		return response.getWinningPlayerPublicKey() == null;
	}
	//
	// /**
	// * Retrieves the public and private keys from Key Generation Service
	// */
	// public BigInteger getKeys() {
	// return
	// }

}
