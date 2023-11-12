import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] dataSet1 = {
			{8, 6, 2, 2},
			{9, 4},
			{4, 1, 2}
	};

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testReadFile(){
		//implement
	}
	@Test
	public void testWriteToFile(){
		//implement
	}
	@Test
	public void testGetTotal(){
		assertEquals(38.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
	}

	@Test
	public void testGetAverage(){
		double actual = Double.parseDouble(String.format("%.2f", TwoDimRaggedArrayUtility.getAverage(dataSet1))); //rounds decimal places

		assertEquals(4.22, actual, .001);
	}
	@Test
	public void testGetRowTotal() {
		assertEquals(13.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1), .001);
	}

	@Test
	public void testGetColumnTotal(){
		assertEquals(21.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
	}

	@Test
	public void testGetHighestInRow(){
		assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), .001);
	}

	@Test
	public void testGetHighestInRowIndex(){
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
	}

	@Test
	public void testGetLowestInRow(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);
	}
	@Test
	public void testGetLowestInRowIndex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
	}
	@Test
	public void testGetHighestInColumn(){
		assertEquals(6, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), .001);
	}
	@Test
	public void testGetHighestInColumnIndex(){
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
	}
	@Test
	public void testGetLowestInColumn(){
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), .001);
	}

	@Test
	public void testGetLowestInColumnindex(){
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
	}

	@Test
	public void testGetHighestInArray(){
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
	}

	@Test
	public void testGetLowestInArray(){
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
	}
}
