package soccerleague;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Controller;

public class TestJunit6 {
	
	private Controller c1 = new Controller();
	
	@Test
	public void testAddLeague() {
		c1.addLeague("a");
		assertFalse("League was not added to the list!", c1.listLeagues().isEmpty());
	}
	
}
