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
	public void testCalculateHolidayBonusA() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
		assertEquals(9000, result[0], .001);

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(26000, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
