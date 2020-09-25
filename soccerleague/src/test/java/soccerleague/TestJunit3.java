package soccerleague;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

public class TestJunit3 {
	
	private Controller c1 = new Controller();

	@Test
	public void testListPlayers() {
		c1.addPlayer("c", "a", "a", 3, true);
		c1.addPlayer("b", "a", "a", 3, true);
		c1.addPlayer("a", "a", "a", 3, true);
		assertTrue("Players listed incorrectly!", c1.listPlayers().startsWith(" Name"));
	}

}
