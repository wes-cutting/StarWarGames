package edu.neumont.csc380;

import java.util.Scanner;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "beans.xml")
public class Client extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void test() {
		start();
	}
	
	/**
	 * @param args
	 */
	
	Scanner input = new Scanner(System.in);
	//add a menu state?
	
	public void start(){
			String startMode = new PromptHandler().start() + "";
			switch(startMode){
			case "11":
				//Send request to start a game with easy AI
				break;
			case "12":
				//Send request to start a game with medium AI
				break;
			case "13":
				//Send request to start a game with hard AI
				break;
			case "21":
				//Send request to retrieve to create a game
				break;
			case "22":
				//Send request to retrieve all active games
				break;
			}
		getActiveGames();
	}
	
	/**
	 * Gets all active games
	 */
	public void getActiveGames(){
		
	}
	
	/**
	 * Retrieves the public and private keys from Key Generation Service
	 */
	public void getKeys(){
		
	}
	
	
	
}
