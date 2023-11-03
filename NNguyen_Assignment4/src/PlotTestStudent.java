/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Tests the Plot class
 * Due: 11/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlotTestStudent {
	private Plot plot1, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(6, 10, 2, 3);
		plot5 = new Plot(7, 11, 1, 2);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5));
	}

	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot5));
	}

	@Test
	public void testGetX() {
		assertEquals(6, plot1.getX());
		assertEquals(7, plot5.getX());
	}
	@Test
	public void testGetY() {
		assertEquals(10, plot1.getY());
		assertEquals(11, plot5.getY());
	}
	@Test
	public void testGetWidth() {
		assertEquals(2, plot1.getWidth());
		assertEquals(1, plot5.getWidth());
	}
	@Test
	public void testGetDepth() {
		assertEquals(3, plot1.getDepth());
		assertEquals(2, plot5.getDepth());
	}

	@Test
	public void testToString() {
		assertEquals("7,11,1,2",plot5.toString());
		assertEquals("6,10,2,3", plot1.toString());
	}

}
