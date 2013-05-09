package edu.neumont.csc380.service;

import org.apache.camel.builder.RouteBuilder;

public class WarGamesRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:queue:tictac").to("TikTakToeService");
		
	}

}
