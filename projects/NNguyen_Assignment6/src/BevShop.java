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

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcohol;
	public ArrayList<Order> orders = new ArrayList<>();

	//no-args constructor
	public BevShop(){ numOfAlcohol = 0; }

	//getters
	public int getNumOfAlcoholDrink() {

		for (int i = 0; i < getCurrentOrder().beverages.size(); i++)
			if (getCurrentOrder().beverages.get(i).getType() == Type.ALCOHOL)
				numOfAlcohol++;

		return numOfAlcohol;
	}
	public Order getOrderAtIndex(int index) {
		Order o = orders.get(index);
		return new Order(o.getOrderTime(), o.getOrderDay(), o.getCustomer());
	}

	public boolean isValidTime(int time) {
		return (time >= MIN_TIME) && (time <= MAX_TIME);
	}

	public boolean isValidAge(int age) {
		return age > MIN_AGE_FOR_ALCOHOL;
	}

	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}

	public boolean isEligibleForMore() {
		return getNumOfAlcoholDrink() <= MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}

	//starts a new order
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		orders.add(new Order(time, day, customer));
	}

	//process coffee
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot,extraSyrup);
	}

	//process alcohol
	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
	}

	//process smoothie
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	//find order at orderno
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++)
			if (orders.get(i).getOrderNo() == orderNo)
				return i;

		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		double total = 0;
		int i = 0;

		for (; i < orders.size(); i++)
			if (orders.get(i).getOrderNo() == orderNo) break;

		for (int j = 0; j < orders.get(i).beverages.size(); j++)
			total += orders.get(i).beverages.get(j).calcPrice();

		return total;
	}

	public double totalMonthlySale() {
		double total = 0;

		for (Order order : orders)
			total += order.calcOrderTotal();

		return total;
	}

	public void sortOrders() {
		int size = orders.size();

		for (int i = 0; i < size; i++) {
			double minValue = orders.get(i).calcOrderTotal();
			int indexOfMin = i;

			for (int j = i + 1; j < size; j++){
				if (orders.get(j).calcOrderTotal() < minValue){
					minValue = orders.get(j).calcOrderTotal();
					indexOfMin = j;
				}
				Order temp = orders.get(i);
				orders.set(i, orders.get(indexOfMin));
				orders.set(indexOfMin, temp);
			}
		}
	}

	@Override
	public String toString(){
		String repOfAllOrders = "";

		for (Order order : orders)
			repOfAllOrders += order.toString() + "\n\n";

		return repOfAllOrders + '\n'
			+ "Total monthly sale: " + totalMonthlySale();
	}
}
