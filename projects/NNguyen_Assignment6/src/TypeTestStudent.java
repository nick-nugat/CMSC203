import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTestStudent {

	@Test
	public void values() {
		Type[] expected = {
				Type.COFFEE,
				Type.SMOOTHIE,
				Type.ALCOHOL
		};

		assertArrayEquals(expected, Type.values());
	}

	@Test
	public void valueOf() {
		assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
		assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
		assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
	}
}