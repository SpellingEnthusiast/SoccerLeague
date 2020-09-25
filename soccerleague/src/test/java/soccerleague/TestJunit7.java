package soccerleague;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

public class TestJunit7 {
	
	private Controller c1 = new Controller();

	@Test
	public void testListLeagues() {
		c1.addLeague("a");
		c1.addLeague("b");
		c1.addLeague("c");
		assertTrue("Leagues listed incorrectly!", c1.listLeagues().startsWith("League"));
	}
}
