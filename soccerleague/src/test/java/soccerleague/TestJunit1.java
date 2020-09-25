package soccerleague;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

public class TestJunit1 {
	
	private Controller c1 = new Controller();
	
	@Test
	public void testAddPlayer() {
		c1.addPlayer("a", "a", "a", 3, true);
		assertFalse("Player was not added to the list!", c1.listPlayers().isEmpty());
	}


}
