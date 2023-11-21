
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityGFATest {

	private double[][] dataSet1 = {
			{1,2,3},
			{4,5},
			{6,7,8,9}
	};
	
	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,
				TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),
				.001);
	}
}
