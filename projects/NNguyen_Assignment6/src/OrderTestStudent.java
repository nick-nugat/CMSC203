/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description:
 * Due: 12/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTestStudent {
	private Order orderOne, orderTwo, orderThree, orderFour;
	private String customerStringTemplate, orderStringTemplate;
	private int orderOneNum, orderTwoNum, orderThreeNum, orderFourNum;

	@Before
	public void setUp() throws Exception {
		//Creating Order objects
		orderOne = new Order(20, Day.SUNDAY, new Customer("Nick", 17)); //weekend
		orderTwo = new Order(8, Day.THURSDAY, new Customer("Tucker", 32));
		orderThree = new Order(13, Day.SATURDAY, new Customer("Anna", 23)); //weekend
		orderFour = new Order(10, Day.TUESDAY, new Customer("Betty", 62));

		//Generates order numbers
		orderOneNum = orderOne.generateOrder();
		orderTwoNum = orderTwo.generateOrder();
		orderThreeNum = orderThree.generateOrder();
		orderFourNum = orderFour.generateOrder();

		//Initializing String templates for toString() methods
		customerStringTemplate =
				"""
				Customer name: %s
				Customer age: %d""";

		orderStringTemplate =
				"""
				Order number: %d
				Order time: %d
				Order day: %s
				Customer name: %s
				Customer age: %d
				List of beverages:
				----------
				%s""";
	}

	@After
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = orderFour = null;
	}

	@Test
	public void testIsWeekend() {
		assertTrue(orderOne.isWeekend());
		assertTrue(orderThree.isWeekend());
		assertFalse(orderTwo.isWeekend());
		assertFalse(orderFour.isWeekend());
	}

	@Test
	public void testGenerateOrder() {
		assertEquals(orderOneNum, orderOne.getOrderNo());
		assertEquals(orderTwoNum, orderTwo.getOrderNo());
		assertEquals(orderThreeNum, orderThree.getOrderNo());
		assertEquals(orderFourNum, orderFour.getOrderNo());
	}

	@Test
	public void testGetOrderTime() {
		assertEquals(20, orderOne.getOrderTime());
		assertEquals(8, orderTwo.getOrderTime());
		assertEquals(13, orderThree.getOrderTime());
		assertEquals(10, orderFour.getOrderTime());
	}

	@Test
	public void testGetTotalItems() {
		orderOne.addNewBeverage("coffee", Size.SMALL, true, true);
		orderOne.addNewBeverage("alcohol", Size.MEDIUM);
		orderTwo.addNewBeverage("smoothie", Size.LARGE, false, false);
		orderThree.addNewBeverage("coffee", Size.MEDIUM, false, true);
		orderFour.addNewBeverage("alcohol", Size.LARGE);

		assertEquals(2, orderOne.getTotalItems());
		assertEquals(1, orderTwo.getTotalItems());
		assertEquals(1, orderThree.getTotalItems());
		assertEquals(1, orderFour.getTotalItems());
	}

	@Test
	public void testGetOrderDay() {
		assertEquals(Day.SUNDAY, orderOne.getOrderDay());
		assertEquals(Day.THURSDAY, orderTwo.getOrderDay());
		assertEquals(Day.SATURDAY, orderThree.getOrderDay());
		assertEquals(Day.TUESDAY, orderFour.getOrderDay());
	}

	@Test
	public void testGetCustomer() {
		Customer
			c1 = new Customer("Nick", 17),
			c2 = new Customer("Tucker", 32),
			c3 = new Customer("Anna", 23),
			c4 = new Customer("Betty", 62);

		final boolean
			C1_STATUS = c1.getName().equals(orderOne.getCustomer().getName()) && c1.getAge() == orderOne.getCustomer().getAge(),
			C2_STATUS = c2.getName().equals(orderTwo.getCustomer().getName()) && c2.getAge() == orderTwo.getCustomer().getAge(),
			C3_STATUS = c3.getName().equals(orderThree.getCustomer().getName()) && c3.getAge() == orderThree.getCustomer().getAge(),
			C4_STATUS = c4.getName().equals(orderFour.getCustomer().getName()) && c4.getAge() == orderFour.getCustomer().getAge();

		//testing string representations of customers
		assertEquals(String.format(customerStringTemplate, "Nick", 17), orderOne.getCustomer().toString());
		assertEquals(String.format(customerStringTemplate, "Tucker", 32), orderTwo.getCustomer().toString());
		assertEquals(String.format(customerStringTemplate, "Anna", 23), orderThree.getCustomer().toString());
		assertEquals(String.format(customerStringTemplate, "Betty", 62), orderFour.getCustomer().toString());

		//actual customer objects
		assertTrue(C1_STATUS);
		assertTrue(C2_STATUS);
		assertTrue(C3_STATUS);
		assertTrue(C4_STATUS);
	}


	@Test
	public void testGetBeverage() {
		Coffee cf = new Coffee("mocha", Size.LARGE, true, true);
		Alcohol al = new Alcohol("rum", Size.SMALL, true);
		Smoothie sm1 = new Smoothie("strawberry", Size.MEDIUM, 3, true);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);

		orderOne.addNewBeverage("mocha", Size.LARGE, true, true);
		orderOne.addNewBeverage("rum", Size.SMALL);
		orderOne.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		assertEquals(orderOne.getBeverage(0), cf);
		assertEquals(orderOne.getBeverage(1), al);
		assertEquals(orderOne.getBeverage(2), sm1);
		assertNotEquals(orderOne.getBeverage(2), sm2);
	}

	@Test
	public void testAddNewBeverage() {
		assertEquals(0, orderOne.getTotalItems());
		assertEquals(0, orderTwo.getTotalItems());

		orderOne.addNewBeverage("mocha", Size.LARGE, true, true);
		orderOne.addNewBeverage("rum", Size.SMALL);
		orderOne.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		orderTwo.addNewBeverage("mocha", Size.LARGE, true, true);
		orderTwo.addNewBeverage("rum", Size.SMALL);
		orderTwo.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		assertEquals(orderOne.getBeverage(0).getType(), Type.COFFEE);
		assertEquals(orderOne.getBeverage(1).getType(), Type.ALCOHOL);
		assertEquals(orderOne.getBeverage(2).getType(), Type.SMOOTHIE);

		assertEquals(orderTwo.getBeverage(0).getType(), Type.COFFEE);
		assertEquals(orderTwo.getBeverage(1).getType(), Type.ALCOHOL);
		assertEquals(orderTwo.getBeverage(2).getType(), Type.SMOOTHIE);

		assertEquals(3, orderOne.getTotalItems());
		assertEquals(3, orderTwo.getTotalItems());

	}

	@Test
	public void testCalcOrderTotal() {
		//5 + 2.6 + 6 = 13.6
		orderOne.addNewBeverage("mocha", Size.LARGE, true, true); //5
		orderOne.addNewBeverage("rum", Size.SMALL); //2.6
		orderOne.addNewBeverage("strawberry", Size.MEDIUM, 3, true); //6
		assertEquals(13.6, orderOne.calcOrderTotal(), .01);

		//2 + 4 + 3.5  = 9.5
		orderTwo.addNewBeverage("mocha", Size.SMALL, false, false); //2
		orderTwo.addNewBeverage("beer", Size.LARGE); //4
		orderTwo.addNewBeverage("mango", Size.MEDIUM, 1, false); //3.5
		assertEquals(9.5, orderTwo.calcOrderTotal(), .01);
	}

	@Test
	public void testFindNumOfBeveType() {
		orderOne.addNewBeverage("mocha", Size.LARGE, true, true);
		orderOne.addNewBeverage("white chocolate", Size.MEDIUM, false, true);
		orderOne.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		assertEquals(orderOne.findNumOfBeveType(Type.COFFEE), 2);
		assertEquals(orderOne.findNumOfBeveType(Type.SMOOTHIE), 1);
	}

	@Test
	public void testCompareTo() {
		orderOne.addNewBeverage("mocha", Size.LARGE, true, true);
		orderOne.addNewBeverage("rum", Size.SMALL);
		orderOne.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		orderTwo.addNewBeverage("mocha", Size.LARGE, true, true);
		orderTwo.addNewBeverage("rum", Size.SMALL);
		orderTwo.addNewBeverage("strawberry", Size.MEDIUM, 3, true);

		orderThree.addNewBeverage("beer", Size.LARGE);
		orderThree.addNewBeverage("mango", Size.MEDIUM, 1, false);

		//Testing the consistency of the compares
		//NOTE: It isn't possible to test for the equality of the order numbers due to its inconsistency with the random number generation.
		assertEquals(orderOne.compareTo(orderTwo), orderOne.compareTo(orderTwo));
		assertEquals(orderTwo.compareTo(orderThree), orderTwo.compareTo(orderThree));
		assertEquals(orderThree.compareTo(orderFour), orderThree.compareTo(orderFour));

	}

	@Test
	public void testToString() {
		String representationOfBeverages = "";
		String expected;

		orderOne.addNewBeverage("mocha", Size.LARGE, true, true);

		for (Beverage b : orderOne.beverages)
			representationOfBeverages += b.toString() + '\n';

		expected =
			String.format(
				orderStringTemplate,
					orderOne.getOrderNo(),
					orderOne.getOrderTime(),
					orderOne.getOrderDay(),
					orderOne.getCustomer().getName(),
					orderOne.getCustomer().getAge(),
					representationOfBeverages
			);

		assertEquals(expected, orderOne.toString());

	}
}