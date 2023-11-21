
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Testing class for the TwoDimRaggedArrayUtility class
 * Due: 11/27/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

public class TwoDimRaggedArrayUtilityTestStudent {

	//Ragged arrays being tested
	private final static double[][]
		DATA_1 = {
			{67.89, 54.32, 0.11},
			{142.99, -5.27, 88.88, 21.34, 99.99},
			{43.21, 32.10, 9.87, -5.27},
			{76.54, -2.22, 11.11, 22.22}
		},
		DATA_2 = {
			{86, 69, 24, 27.99},
			{8.99, 52.70, 5, 9.23, 27.2},
			{41, 10.52},
			{9.62, 2, 67, 1.52, 8.56}
		};

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testReadFile() throws FileNotFoundException {
		File file = new File("dataSet1.txt");

		double[][] arr1 = TwoDimRaggedArrayUtility.readFile(file);
		assertEquals(5.0, arr1[1][1], .001);

		File anotherFile = new File("dataSet2.txt");
		double[][] arr2 = TwoDimRaggedArrayUtility.readFile(anotherFile);
		assertEquals(11.0, arr2[3][0], .001);
	}


	@Test
	public void testWriteToFile() throws FileNotFoundException {
		File file = new File("studentDataset1.txt");
		File anotherFile = new File("studentDataset2.txt");

		TwoDimRaggedArrayUtility.writeToFile(DATA_1, file);
		TwoDimRaggedArrayUtility.writeToFile(DATA_2, anotherFile);

		double[][]
			fromStudentFile = TwoDimRaggedArrayUtility.readFile(file),
			fromOtherStudentFile = TwoDimRaggedArrayUtility.readFile(anotherFile);

		assertArrayEquals(fromStudentFile, DATA_1);
		assertArrayEquals(fromOtherStudentFile, DATA_2);

		assertEquals(fromStudentFile[2][1], DATA_1[2][1], .001);
		assertEquals(fromOtherStudentFile[3][4], DATA_2[3][4], .001);
	}

	@Test
	public void testGetTotal(){
		assertEquals(657.81, TwoDimRaggedArrayUtility.getTotal(DATA_1), .001);
		assertEquals(450.33, TwoDimRaggedArrayUtility.getTotal(DATA_2), .001);
	}

	@Test
	public void testGetAverage(){
		double
			actualAvg1 = Double.parseDouble(String.format("%.2f", TwoDimRaggedArrayUtility.getAverage(DATA_1))),
			actualAvg2 = Double.parseDouble(String.format("%.2f", TwoDimRaggedArrayUtility.getAverage(DATA_2)));

		assertEquals(41.11, actualAvg1, .001);
		assertEquals(28.15, actualAvg2, .001);
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(347.93, TwoDimRaggedArrayUtility.getRowTotal(DATA_1,1), .001);
		assertEquals(79.91, TwoDimRaggedArrayUtility.getRowTotal(DATA_1,2), .001);
		assertEquals(206.99, TwoDimRaggedArrayUtility.getRowTotal(DATA_2,0), .001);
		assertEquals(51.52, TwoDimRaggedArrayUtility.getRowTotal(DATA_2,2), .001);
	}

	@Test
	public void testGetColumnTotal(){
		assertEquals(330.63, TwoDimRaggedArrayUtility.getColumnTotal(DATA_1, 0), .001);
		assertEquals(38.29, TwoDimRaggedArrayUtility.getColumnTotal(DATA_1, 3), .001);
		assertEquals(145.61, TwoDimRaggedArrayUtility.getColumnTotal(DATA_2, 0), .001);
		assertEquals(38.74, TwoDimRaggedArrayUtility.getColumnTotal(DATA_2, 3), .001);
	}

	@Test
	public void testGetHighestInRow(){
		assertEquals(67.89, TwoDimRaggedArrayUtility.getHighestInRow(DATA_1, 0), .001);
		assertEquals(142.99, TwoDimRaggedArrayUtility.getHighestInRow(DATA_1, 1), .001);
		assertEquals(86, TwoDimRaggedArrayUtility.getHighestInRow(DATA_2, 0), .001);
		assertEquals(41, TwoDimRaggedArrayUtility.getHighestInRow(DATA_2, 2), .001);
	}

	@Test
	public void testGetHighestInRowIndex(){
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(DATA_1, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(DATA_1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(DATA_2, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(DATA_2, 3));
	}

	@Test
	public void testGetLowestInRow(){
		assertEquals(0.11, TwoDimRaggedArrayUtility.getLowestInRow(DATA_1, 0), .001);
		assertEquals(-5.27, TwoDimRaggedArrayUtility.getLowestInRow(DATA_1, 1), .001);
		assertEquals(5, TwoDimRaggedArrayUtility.getLowestInRow(DATA_2, 1), .001);
		assertEquals(1.52, TwoDimRaggedArrayUtility.getLowestInRow(DATA_2, 3), .001);
	}

	@Test
	public void testGetLowestInRowIndex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(DATA_1, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(DATA_1, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(DATA_2, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInRowIndex(DATA_2, 3));
	}

	@Test
	public void testGetHighestInColumn(){
		assertEquals(142.99, TwoDimRaggedArrayUtility.getHighestInColumn(DATA_1, 0), .001);
		assertEquals(22.22, TwoDimRaggedArrayUtility.getHighestInColumn(DATA_1, 3), .001);
		assertEquals(69, TwoDimRaggedArrayUtility.getHighestInColumn(DATA_2, 1), .001);
		assertEquals(27.2, TwoDimRaggedArrayUtility.getHighestInColumn(DATA_2, 4), .001);
	}

	@Test
	public void testGetHighestInColumnIndex(){
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(DATA_1, 0));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(DATA_1, 3));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(DATA_2, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(DATA_2, 4));
	}

	@Test
	public void testGetLowestInColumn(){
		assertEquals(43.21, TwoDimRaggedArrayUtility.getLowestInColumn(DATA_1, 0), .001);
		assertEquals(-5.27, TwoDimRaggedArrayUtility.getLowestInColumn(DATA_1, 3), .001);
		assertEquals(8.99, TwoDimRaggedArrayUtility.getLowestInColumn(DATA_2, 0), .001);
		assertEquals(1.52, TwoDimRaggedArrayUtility.getLowestInColumn(DATA_2, 3), .001);
	}

	@Test
	public void testGetLowestInColumnIndex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(DATA_1, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(DATA_1, 3));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(DATA_2, 0));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(DATA_2, 3));
	}

	@Test
	public void testGetHighestInArray(){
		assertEquals(142.99, TwoDimRaggedArrayUtility.getHighestInArray(DATA_1), .001);
		assertEquals(86, TwoDimRaggedArrayUtility.getHighestInArray(DATA_2), .001);
	}

	@Test
	public void testGetLowestInArray(){
		assertEquals(-5.27, TwoDimRaggedArrayUtility.getLowestInArray(DATA_1), .001);
		assertEquals(1.52, TwoDimRaggedArrayUtility.getLowestInArray(DATA_2), .001);
	}
}
