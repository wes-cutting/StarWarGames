package edu.neumont.csc380.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import modelEnities.Board;
import modelEnities.GameList;
import modelRequests.GameListRequest;
import modelRequests.JoinGameRequest;
import modelRequests.MoveRequest;
import modelRequests.NewGameRequest;
import modelResponses.EndGameResponse;
import modelResponses.GameListResponse;
import modelResponses.MoveResponse;
import modelResponses.NewGameResponse;
import contract.TicTacToeInterface;

import edu.neumont.csc380.game.TikTakToe;
import exceptions.InvalidOperation;

@Service("TiKTakToeService")
public class TikTakToeImpl implements TicTacToeInterface {

	public GameList getGameList(GameListRequest glr) {
		List<Integer> gameIds = new ArrayList<Integer>();
		List<TikTakToe> tikTakGames = TikTakToe.GetGameList();
		
		for(TikTakToe ttt : tikTakGames){
			gameIds.add(ttt.getId());
		}
		
		GameList games = new GameList();
		games.setGames(gameIds);
		return games;
	}
 
	public MoveResponse joinGame(JoinGameRequest jgr) throws InvalidOperation{
		List<TikTakToe> games = TikTakToe.GetGameList();
		TikTakToe game = null;
		for(TikTakToe g : games){
			if(g.getId() == jgr.getGameId()){
				g.join(jgr.publicKey);
				game = g;
				break;
			}
		}
		if(game == null){
			throw new InvalidOperation("Game does not exist with ID in Join Request");
		}
		MoveResponse response = new MoveResponse();
		response.setGameId(game.getId());
		response.setBoard(game.getBoard());
		return response;
	}

	public MoveResponse moveRequest(MoveRequest mr) throws InvalidOperation {
		
		return null;		
	}

	public NewGameResponse newGameRequest(NewGameRequest ngr) {
		NewGameResponse response = new NewGameResponse();
		TikTakToe game = new TikTakToe(ngr.getPublicKey());
		response.setBoard(game.getBoard());
		response.setGameId(game.getId());
		return response;
		
	}

	public void endGame(EndGameResponse egr) {
		// TODO Auto-generated method stub
		
	}

	public void sendGameList(GameListResponse glr) {
		// TODO Auto-generated method stub
		
	}

	public void moveResponse(MoveResponse mr) {
		// TODO Auto-generated method stub
		
	}

	public void newGameResponse(NewGameResponse ngr) {
		// TODO Auto-generated method stub
		
	}

	public void getSignature() {
		// TODO Auto-generated method stub
		
	}

	public void setSignature() {
		// TODO Auto-generated method stub
		
	}

}
