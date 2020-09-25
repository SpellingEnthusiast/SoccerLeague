package soccerleague;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

public class TestJunit2 {
	
	private Controller c1 = new Controller();

	@Test
	public void testRemovePlayer() {
		c1.addPlayer("a", "a", "a", 3, true);
		c1.removePlayer("a");
		assertTrue("Player was not removed from the list!", c1.listPlayers().isEmpty());
	}

}
