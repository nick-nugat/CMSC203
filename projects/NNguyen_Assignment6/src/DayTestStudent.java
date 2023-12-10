import org.junit.Test;

import static org.junit.Assert.*;

public class DayTestStudent {

	@Test
	public void testValues() {
		Day[] expected = {
				Day.MONDAY,
				Day.TUESDAY,
				Day.WEDNESDAY,
				Day.THURSDAY,
				Day.FRIDAY,
				Day.SATURDAY,
				Day.SUNDAY
		};
		assertArrayEquals(expected, Day.values());
	}

	@Test
	public void testValueOf() {
		assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
		assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"));
		assertEquals(Day.WEDNESDAY, Day.valueOf("WEDNESDAY"));
		assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"));
		assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"));
		assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
		assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
	}
}