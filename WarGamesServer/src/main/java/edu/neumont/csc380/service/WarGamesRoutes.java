package edu.neumont.csc380.service;

import org.apache.camel.builder.RouteBuilder;

public class WarGamesRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:topic:service").to("TiKTakToeService").to("jms:topic:join");
		from("jms:topic:move").to("TiKTakToeService").to("jms:topic:move");
		from("jms:topic:list").to("TiKTakToeService").to("jms:topic:list");
		from("jms:topic:new").to("TiKTakToeService").to("jms:topic:new");
	}

}
