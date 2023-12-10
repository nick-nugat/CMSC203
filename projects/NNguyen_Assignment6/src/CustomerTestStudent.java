import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTestStudent {
	Customer c1, c2;
	String customerTemplate;

	@Before
	public void setUp() throws Exception {
		c1 = new Customer("Nick", 17);
		c2 = new Customer("Tucker", 32);
		customerTemplate =
			"""
			Customer name: %s
			Customer age: %d""";
	}

	@Test
	public void getName() {
		assertEquals("Nick", c1.getName());
		assertEquals("Tucker", c2.getName());
	}

	@Test
	public void getAge() {
		assertEquals(17, c1.getAge());
		assertEquals(32, c2.getAge());
	}

	@Test
	public void setName() {
		assertEquals("Nick", c1.getName());
		c1.setName("Nicky");
		assertEquals("Nicky", c1.getName());
	}

	@Test
	public void setAge() {
		assertEquals(17, c1.getAge());
		c1.setAge(19);
		assertEquals(19, c1.getAge());
	}

	@Test
	public void testToString() {
		assertEquals(String.format(customerTemplate, "Nick", 17), c1.toString());
	}
}