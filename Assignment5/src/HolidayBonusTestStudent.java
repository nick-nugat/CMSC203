import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HolidayBonusTestStudent {

	private double[][] dataSet1 = {
			{8, 6, 2, 2}, //9000 = (2000 + 5000 + 1000 + 1000)
			{9, 4}, //7000 = (5000 + 2000)
			{4, 1, 5, 3} //12000 = (1000 + 1000 + 5000 + 5000)
	};

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testCalculateHolidayBonusA() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
		assertEquals(9000, result[0], .001);

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(26000, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
