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
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	//fields
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	public ArrayList<Beverage> beverages = new ArrayList<>();

	//constructor
	public Order(int orderTime, Day orderDay, Customer customer){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
	}

	//getters
	public boolean isWeekend() {
		return (orderDay == Day.SATURDAY) || (orderDay == Day.SUNDAY);
	}

	public int generateOrder() {
		orderNum = new Random().nextInt(80000) + 10000;
		return orderNum;
	}

	public int getOrderNo() {
		return orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}

	public Beverage getBeverage(int itemNo) {
		Beverage bev = beverages.get(itemNo);

		return bev instanceof Alcohol a
			 	? new Alcohol(a.getName(), a.getSize(), isWeekend())
			 : bev instanceof Coffee c
				? new Coffee(c.getName(), c.getSize(), c.getExtraShot(), c.getExtraSyrup())
			 : bev instanceof Smoothie s
				? new Smoothie(s.getName(), s.getSize(), s.getNumOfFruits(), s.getAddProtein())
			 : null;
	}

	//add coffee
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(
			new Coffee(bevName, size, extraShot, extraSyrup)
		);
	}

	//add smoothie
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein){
		beverages.add(
			new Smoothie(bevName, size, numOfFruits, addProtein)
		);
	}

	//add alcohol
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(
			new Alcohol(bevName, size, isWeekend())
		);
	}

	//calculating the total of the order
	public double calcOrderTotal() {
		double total = 0;

		for (Beverage b : beverages)
			total += b.calcPrice();

		return total;
	}

	//finds how many of passed type is in the order
	public int findNumOfBeveType(Type type) {
		int ofBeverageType = 0;

		for (Beverage b : beverages)
			if (b.getType() == type) ofBeverageType++;

		return ofBeverageType;
	}

	//compares two order numbers
	@Override
	public int compareTo(Order o) { return Integer.compare(orderNum, o.orderNum); }

	//string representation of order
	@Override
	public String toString(){
		String representationOfBeverages = "";

		for (Beverage b : beverages)
			representationOfBeverages += b.toString() + '\n';

		return "Order number: " + orderNum + '\n'
				+ "Order time: " + orderTime + '\n'
				+ "Order day: " + orderDay + '\n'
				+ "Customer name: " + customer.getName() + '\n'
				+ "Customer age: " + customer.getAge() + '\n'
				+ "List of beverages:" + '\n'
			    + "----------" + '\n'
				+ representationOfBeverages;
	}
}
