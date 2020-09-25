package soccerleague;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import controller.Controller;

public class TestJunit5 {
	
	private Controller c1 = new Controller();

	@Test
	public void testRemoveManager() {
		c1.addManager("a", "a", "a", LocalDate.EPOCH, 4);
		c1.removeManager("a");
		assertTrue("Manager was not removed from the list!", c1.listManagers().isEmpty());
	}

}
