import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SmoothieTestStudent {
	Smoothie smallSmoothie;
	Smoothie largeSmoothie;

	@Before
	public void setUp() {
		smallSmoothie = new Smoothie("Tropical", Size.SMALL, 2, false);
		largeSmoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
	}

	@After
	public void tearDown() {
		smallSmoothie = largeSmoothie = null;
	}

	@Test
	public void calcPrice() {
		assertEquals(3.0, smallSmoothie.calcPrice(), 0.001);
		assertEquals(7.0, largeSmoothie.calcPrice(), 0.001);
	}

	@Test
	public void testEquals() {
		Smoothie sameAsSmallSmoothie = new Smoothie("Tropical", Size.SMALL, 2, false);
		assertEquals(smallSmoothie, sameAsSmallSmoothie);

		Smoothie differentSmoothie = new Smoothie("Green Goddess", Size.SMALL, 2, false);
		assertNotEquals(smallSmoothie, differentSmoothie);
	}

	@Test
	public void testToString() {
		String expectedString = "Name: Berry Blast\nSize: LARGE\nProtein added: true\nNumber of fruits: 3\nPrice: 7.0";
		assertEquals(expectedString, largeSmoothie.toString());
	}

	@Test
	public void getNumOfFruits() {
		assertEquals(2, smallSmoothie.getNumOfFruits());
	}

	@Test
	public void getAddProtein() {
		assertTrue(largeSmoothie.getAddProtein());
	}
}
