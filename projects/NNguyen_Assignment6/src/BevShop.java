import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcohol;
	public ArrayList<Order> orders;

	public BevShop(){}

	@Override
	public boolean isValidTime(int time) { return (time >= MIN_TIME) && (time <= MAX_TIME); }
	@Override
	public int getMaxNumOfFruits() { return MAX_FRUIT; }
	@Override
	public int getMinAgeForAlcohol() { return MIN_AGE_FOR_ALCOHOL; }

	@Override
	public boolean isMaxFruit(int numOfFruits) { return numOfFruits > MAX_FRUIT; }

	@Override
	public int getMaxOrderForAlcohol() { return MAX_ORDER_FOR_ALCOHOL; }

	@Override
	public boolean isEligibleForMore() { return numOfAlcohol < MAX_ORDER_FOR_ALCOHOL; }

	@Override
	public int getNumOfAlcoholDrink() { return numOfAlcohol; }

	@Override
	public boolean isValidAge(int age) { return age > MIN_AGE_FOR_ALCOHOL; }

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		Alcohol alcohol = new Alcohol(bevName, size, getCurrentOrder().isWeekend());
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			int orderAtIndexNo = orders.get(i).getOrderNo();
			if (orderAtIndexNo == orderNo) return i;
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double total = 0;

		for (Order order : orders) {
			int orderAtIndexNo = order.getOrderNo();
			if (orderAtIndexNo == orderNo)
				total = getCurrentOrder().calcOrderTotal();
		}

		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;

		for (Order order : orders)
			total += order.calcOrderTotal();

		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {

	}

	@Override
	public Order getOrderAtIndex(int index) {
		Order orderAtIndex = orders.get(index);
		int time = orderAtIndex.getOrderTime();
		Day day = orderAtIndex.getOrderDay();
		Customer customer = orderAtIndex.getCustomer();

		return new Order(time, day, customer); //shallow copy
	}

	@Override
	public void sortOrders() {
		//using selection sort
		for (int i = 0; i < orders.size(); i++) {

		}
	}
}
