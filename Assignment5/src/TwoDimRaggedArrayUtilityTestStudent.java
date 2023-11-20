import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] raggedArray = {
			{8, 6, 2, 2},
			{9, 4, 5},
			{4, 1, 2, 6},
			{9, 2, 0, 2, 5, 1}
	};

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testReadFile() throws IOException { //IOException is the superclass of FileNotFoundException.
		File file = new File("dataSet1.txt");

		double[][] arr1 = TwoDimRaggedArrayUtility.readFile(file);
		assertEquals(5.0, arr1[1][1], .001);

		File anotherFile = new File("dataSet2.txt");
		double[][] arr2 = TwoDimRaggedArrayUtility.readFile(anotherFile);
		assertEquals(11.0, arr2[3][0], .001);
	}

	@Test
	public void testWriteToFile() throws FileNotFoundException {
		File file = new File("studentDataset.txt");
		TwoDimRaggedArrayUtility.writeToFile(raggedArray, file);

		double[][] fromStudentFile = TwoDimRaggedArrayUtility.readFile(file);

		assertArrayEquals(fromStudentFile, raggedArray);
		assertEquals(fromStudentFile[2][1], raggedArray[2][1], .001);
	}
	@Test
	public void testGetTotal(){
		assertEquals(68.0, TwoDimRaggedArrayUtility.getTotal(raggedArray), .001);
	}

	@Test
	public void testGetAverage(){
		double actual = TwoDimRaggedArrayUtility.getAverage(raggedArray);
		assertEquals(4.0, actual, .001);
	}
	@Test
	public void testGetRowTotal() {
		assertEquals(18.0, TwoDimRaggedArrayUtility.getRowTotal(raggedArray,1), .001);
		assertEquals(13.0, TwoDimRaggedArrayUtility.getRowTotal(raggedArray,2), .001);
	}

	@Test
	public void testGetColumnTotal(){
		assertEquals(30.0, TwoDimRaggedArrayUtility.getColumnTotal(raggedArray, 0), .001);
		assertEquals(10.0, TwoDimRaggedArrayUtility.getColumnTotal(raggedArray, 3), .001);
	}

	@Test
	public void testGetHighestInRow(){
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(raggedArray, 0), .001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(raggedArray, 1), .001);
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInRow(raggedArray, 2), .001);
	}

	@Test
	public void testGetHighestInRowIndex(){
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(raggedArray, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(raggedArray, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(raggedArray, 2));
	}

	@Test
	public void testGetLowestInRow(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRow(raggedArray, 0), .001);
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(raggedArray, 1), .001);
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(raggedArray, 2), .001);
	}

	@Test
	public void testGetLowestInRowIndex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(raggedArray, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(raggedArray, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(raggedArray, 2));
	}

	@Test
	public void testGetHighestInColumn(){
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInColumn(raggedArray, 0), .001);
		assertEquals(6, TwoDimRaggedArrayUtility.getHighestInColumn(raggedArray, 3), .001);
		assertEquals(5, TwoDimRaggedArrayUtility.getHighestInColumn(raggedArray, 4), .001);
	}

	@Test
	public void testGetHighestInColumnIndex(){
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(raggedArray, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(raggedArray, 3));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(raggedArray, 4));
	}

	@Test
	public void testGetLowestInColumn(){
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInColumn(raggedArray, 0), .001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(raggedArray, 3), .001);
		assertEquals(5, TwoDimRaggedArrayUtility.getLowestInColumn(raggedArray, 4), .001);
	}

	@Test
	public void testGetLowestInColumnIndex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(raggedArray, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(raggedArray, 3));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(raggedArray, 4));
	}

	@Test
	public void testGetHighestInArray(){
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(raggedArray), .001);
	}

	@Test
	public void testGetLowestInArray(){
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInArray(raggedArray), .001);
	}
}
