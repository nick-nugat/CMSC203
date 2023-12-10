import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BevShopTestStudent {
	BevShop shop;
	int orderOneNum, orderTwoNum, orderThreeNum, orderFourNum;


	@Before
	public void setUp() throws Exception {
		 shop = new BevShop();
		 
		 shop.startNewOrder(20, Day.SUNDAY, "Nick", 17);
		 shop.getCurrentOrder().generateOrder();
		 orderOneNum = shop.getCurrentOrder().getOrderNo();
		 shop.startNewOrder(8, Day.THURSDAY, "Tucker", 32);
		 orderTwoNum = shop.getCurrentOrder().generateOrder();
		 shop.startNewOrder(13, Day.SATURDAY, "Anna", 23);
		 orderThreeNum = shop.getCurrentOrder().generateOrder();
		 shop.startNewOrder(10, Day.TUESDAY, "Betty", 62);
		 orderFourNum = shop.getCurrentOrder().generateOrder();

	}

	@After
	public void tearDown() throws Exception {
		shop = null;
	}

	@Test
	public void testIsValidTime() {
		BevShop invalidTime = new BevShop();
		invalidTime.startNewOrder(1, Day.FRIDAY, "False", 16);
		assertFalse(invalidTime.isValidTime(invalidTime.orders.get(0).getOrderTime()));

		assertTrue(shop.isValidTime(shop.orders.get(0).getOrderTime()));
		assertTrue(shop.isValidTime(shop.orders.get(1).getOrderTime()));
		assertTrue(shop.isValidTime(shop.orders.get(2).getOrderTime()));
		assertTrue(shop.isValidTime(shop.orders.get(3).getOrderTime()));
	}

	@Test
	public void testIsValidAge() {
		assertFalse(shop.isValidAge(shop.orders.get(0).getCustomer().getAge()));
		assertTrue(shop.isValidAge(shop.orders.get(1).getCustomer().getAge()));
		assertTrue(shop.isValidAge(shop.orders.get(2).getCustomer().getAge()));
		assertTrue(shop.isValidAge(shop.orders.get(3).getCustomer().getAge()));
	}

	@Test
	public void testIsMaxFruit() {
		assertFalse(shop.isMaxFruit(3));
		assertTrue(shop.isMaxFruit(6));
	}

	@Test
	public void testIsEligibleForMore() {
		shop.getCurrentOrder().addNewBeverage("rum", Size.SMALL);
		shop.getCurrentOrder().addNewBeverage("rum", Size.SMALL);

		System.out.println(shop.getCurrentOrder().getOrderNo());
	}

	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(5, shop.getMaxNumOfFruits());
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(21, shop.getMinAgeForAlcohol());
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(3, shop.getMaxOrderForAlcohol());
	}

	@Test
	public void testTotalNumOfMonthlyOrders() {
		assertEquals(4, shop.totalNumOfMonthlyOrders());
	}

	@Test
	public void testGetCurrentOrder() {
		Order orderToCompare = new Order(10, Day.TUESDAY, new Customer("Betty", 62));
		final boolean CURRENT_ORDER_STATUS = (orderToCompare.getOrderTime()) == (shop.getCurrentOrder().getOrderTime())
										  && (orderToCompare.getOrderDay()) == (shop.getCurrentOrder().getOrderDay())
										  && (orderToCompare.getCustomer().getAge()) == (shop.getCurrentOrder().getCustomer().getAge())
										  && (orderToCompare.getCustomer().getName()).equals(shop.getCurrentOrder().getCustomer().getName());

		assertTrue(CURRENT_ORDER_STATUS);
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		shop.processAlcoholOrder("beer", Size.MEDIUM);
		shop.processAlcoholOrder("wine", Size.LARGE);

		assertEquals(2, shop.getNumOfAlcoholDrink());
	}

	@Test
	public void testGetOrderAtIndex() {
		Order[] ordersToCheck = {
			new Order(20, Day.SUNDAY, new Customer("Nick", 17)),
			new Order(8, Day.THURSDAY, new Customer("Tucker", 32)),
			new Order(13, Day.SATURDAY, new Customer("Anna", 23)),
			new Order(10, Day.TUESDAY, new Customer("Betty", 62))
		};

		final boolean
			FIRST_ORDER = (ordersToCheck[0].getOrderTime()) == (shop.getOrderAtIndex(0).getOrderTime())
					   && (ordersToCheck[0].getOrderDay()) == (shop.getOrderAtIndex(0).getOrderDay())
					   && (ordersToCheck[0].getCustomer().getAge()) == (shop.getOrderAtIndex(0).getCustomer().getAge())
					   && (ordersToCheck[0].getCustomer().getName()).equals(shop.getOrderAtIndex(0).getCustomer().getName()),

			SECOND_ORDER = (ordersToCheck[1].getOrderTime()) == (shop.getOrderAtIndex(1).getOrderTime())
						&& (ordersToCheck[1].getOrderDay()) == (shop.getOrderAtIndex(1).getOrderDay())
						&& (ordersToCheck[1].getCustomer().getAge()) == (shop.getOrderAtIndex(1).getCustomer().getAge())
						&& (ordersToCheck[1].getCustomer().getName()).equals(shop.getOrderAtIndex(1).getCustomer().getName()),

			THIRD_ORDER = (ordersToCheck[2].getOrderTime()) == (shop.getOrderAtIndex(2).getOrderTime())
					   && (ordersToCheck[2].getOrderDay()) == (shop.getOrderAtIndex(2).getOrderDay())
					   && (ordersToCheck[2].getCustomer().getAge()) == (shop.getOrderAtIndex(2).getCustomer().getAge())
					   && (ordersToCheck[2].getCustomer().getName()).equals(shop.getOrderAtIndex(2).getCustomer().getName()),

			FOURTH_ORDER = (ordersToCheck[3].getOrderTime()) == (shop.getOrderAtIndex(3).getOrderTime())
						&& (ordersToCheck[3].getOrderDay()) == (shop.getOrderAtIndex(3).getOrderDay())
						&& (ordersToCheck[3].getCustomer().getAge()) == (shop.getOrderAtIndex(3).getCustomer().getAge())
						&& (ordersToCheck[3].getCustomer().getName()).equals(shop.getOrderAtIndex(3).getCustomer().getName());


		assertTrue(FIRST_ORDER);
		assertTrue(SECOND_ORDER);
		assertTrue(THIRD_ORDER);
		assertTrue(FOURTH_ORDER);
	}

	@Test
	public void testStartNewOrder() {
		int sizeBefore = shop.totalNumOfMonthlyOrders();
		shop.startNewOrder(10, Day.FRIDAY, "Fred", 25);
		assertEquals(sizeBefore + 1, shop.totalNumOfMonthlyOrders());
	}

	@Test
	public void testProcessCoffeeOrder() {
		shop.processCoffeeOrder("mocha", Size.LARGE, true, true);
		assertEquals(Type.COFFEE, shop.getCurrentOrder().beverages.get(0).getType());
	}

	@Test
	public void testProcessAlcoholOrder() {
		shop.processAlcoholOrder("rum", Size.SMALL);
		assertEquals(Type.ALCOHOL, shop.getCurrentOrder().beverages.get(0).getType());
	}

	@Test
	public void testProcessSmoothieOrder() {
		shop.processSmoothieOrder("strawberry", Size.MEDIUM, 3, true);
		assertEquals(Type.SMOOTHIE, shop.getCurrentOrder().beverages.get(0).getType());
	}

	@Test
	public void testFindOrder() {
		assertEquals(0, shop.findOrder(orderOneNum));
		assertEquals(1, shop.findOrder(orderTwoNum));
		assertEquals(2, shop.findOrder(orderThreeNum));
		assertEquals(3, shop.findOrder(orderFourNum));

		assertEquals(-1, shop.findOrder(1000));
	}

	@Test
	public void testTotalOrderPrice() {
		BevShop temp = new BevShop();
		temp.startNewOrder(10, Day.MONDAY, "Bob", 30);

		temp.processCoffeeOrder("mocha", Size.LARGE, true, true); //5
		temp.processAlcoholOrder("rum", Size.SMALL); //2
		temp.processSmoothieOrder("strawberry", Size.MEDIUM, 3, true); //6

		assertEquals(13, temp.totalOrderPrice(temp.getCurrentOrder().generateOrder()), .01);
	}

	@Test
	public void testTotalMonthlySale() {
		BevShop temp = new BevShop();
		double expectedTotalSale = (2 + 4 + 3.5);
		temp.startNewOrder(10, Day.MONDAY, "Nicky", 30);

		temp.processCoffeeOrder("mocha", Size.SMALL, false, false); //2
		temp.processAlcoholOrder("beer", Size.LARGE); //4
		temp.processSmoothieOrder("mango", Size.MEDIUM, 1, false); //3.5

		assertEquals(expectedTotalSale, temp.totalMonthlySale(), .001);

	}

	@Test
	public void testSortOrders() {
		shop.sortOrders();
		assertEquals(orderOneNum, shop.orders.get(0).getOrderNo());
		assertEquals(orderTwoNum, shop.orders.get(1).getOrderNo());
		assertEquals(orderThreeNum, shop.orders.get(2).getOrderNo());
		assertEquals(orderFourNum, shop.orders.get(3).getOrderNo());
	}

	@Test
	public void testToString(){
		throw new UnsupportedOperationException("Method not implemented yet");
	}
}