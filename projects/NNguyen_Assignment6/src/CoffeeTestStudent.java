import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeTestStudent {
	Coffee c1, c2;
	String coffeeTemplate;

	@Before
	public void setUp() throws Exception {
		c1 = new Coffee("mocha", Size.MEDIUM, true, true);
		c2 = new Coffee("mocha", Size.MEDIUM, true, true);
		coffeeTemplate =
			"""
			Name: %s
			Size: %s
			Extra shot: %b
			Extra syrup: %b
			Price: %.1f""";
	}

	@After
	public void tearDown() throws Exception {
		c1 = c2 = null;
	}

	@Test
	public void getExtraShot() {
		assertTrue(c1.getExtraShot());
		assertTrue(c2.getExtraShot());
	}

	@Test
	public void getExtraSyrup() {
		assertTrue(c1.getExtraSyrup());
		assertTrue(c2.getExtraSyrup());
	}

	@Test
	public void calcPrice() {
		assertEquals(4.0, c1.calcPrice(), .01);
		assertEquals(4.0, c2.calcPrice(), .01);
	}

	@Test
	public void testEquals() {
		assertTrue(c1.equals(c2));
	}

	@Test
	public void testToString() {
		assertEquals(String.format(coffeeTemplate, "mocha", Size.MEDIUM, true, true, 4.0),
				c1.toString());
	}
}