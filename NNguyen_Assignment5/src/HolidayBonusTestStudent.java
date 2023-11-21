/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Testing class for HolidayBonus class
 * Due: 11/27/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HolidayBonusTestStudent {

	private double[][] dataSet1 = {
			{8, 6, 2, 2},
			{9, 4},
			{4, 1, 5, 3}
	};

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testCalculateHolidayBonus() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
		assertEquals(9000, result[0], .001);


	}

	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(28000, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
