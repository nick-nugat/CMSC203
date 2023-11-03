/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Tests the Property class
 * Due: 11/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyTestStudent {
	Property propertyOne;

	@BeforeEach
	public void setUp() throws Exception {
		propertyOne = new Property("Property DEF", "Towson", 8200, "Capital City Bank");
	}

	@AfterEach
	public void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	public void testGetPropertyName() {
		assertEquals("Property DEF", propertyOne.getPropertyName());
	}

	@Test
	public void testGetRentAmount() {
		assertEquals(8200.0, propertyOne.getRentAmount());
	}

	@Test
	public void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	public void testGetCity() {
		assertEquals("Towson", propertyOne.getCity());
	}

	@Test
	public void testGetOwner() {
		assertEquals("Capital City Bank", propertyOne.getOwner());
	}

	@Test
	public void testToString() {
		assertEquals("Property DEF,Towson,Capital City Bank,8200.0",propertyOne.toString());
	}

}

