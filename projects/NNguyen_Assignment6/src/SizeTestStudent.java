import org.junit.Test;

import static org.junit.Assert.*;

public class SizeTestStudent {

	@Test
	public void values() {
		Size[] expected = {
				Size.SMALL,
				Size.MEDIUM,
				Size.LARGE
		};
		assertArrayEquals(expected, Size.values());
	}

	@Test
	public void valueOf() {
		assertEquals(Size.SMALL, Size.valueOf("SMALL"));
		assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
		assertEquals(Size.LARGE, Size.valueOf("LARGE"));
	}
}