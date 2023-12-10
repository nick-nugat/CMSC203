/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description:
 * Due: 12/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlcoholTestStudent {
	Alcohol a1, a2;
	String alcoholTemplate;

	@Before
	public void setUp() throws Exception {
		a1 = new Alcohol("beer", Size.MEDIUM, true);
		a2 = new Alcohol("beer", Size.MEDIUM, true);

		alcoholTemplate =
			"""
			Name: %s
			Size: %s
			Available on weekend: %b
			Price: %.1f""";
	}

	@After
	public void tearDown() throws Exception {
		a1 = a2 = null;
	}

	@Test
	public void testEquals() {
		assertTrue(a1.equals(a2));
	}

	@Test
	public void testToString() {
		assertEquals(String.format(alcoholTemplate, "beer", Size.MEDIUM, true, 3.6),
				a1.toString());
	}

	@Test
	public void testCalcPrice() {
		assertEquals(3.6, a1.calcPrice(), .01);
	}
}