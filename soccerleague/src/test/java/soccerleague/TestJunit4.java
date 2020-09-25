package soccerleague;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import controller.Controller;

public class TestJunit4 {
	private Controller c1 = new Controller();
	
	@Test
	public void testAddManager() {
		c1.addManager("a", "a", "a", LocalDate.EPOCH, 4);
		assertFalse("Manager was not added to the list!", c1.listManagers().isEmpty());
	}

}
