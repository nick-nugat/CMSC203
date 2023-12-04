import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	private int orderNum;
	private int orderTime;
	private int totalItems;
	private Day orderDay;
	private Customer customer;
	private Beverage beverage;

	public Order(int orderTime, Day orderDay, Customer customer){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
	}
	
	@Override
	public boolean isWeekend() { return (orderDay == Day.SATURDAY) || (orderDay == Day.SUNDAY); }
	public int generateOrder(){ return new Random().nextInt(80000) + 10000; }
	public int getOrderNo() { return orderNum; }
	public int getOrderTime() { return orderTime; }
	public int getTotalItems() { return totalItems; }
	public Day getOrderDay() { return orderDay; }
	public Customer getCustomer() { return new Customer(customer); }


	@Override
	public Beverage getBeverage(int itemNo) {
		//return shallow copy of Beverage

		return beverage;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;

	}

	@Override
	public int findNumOfBeveType(Type type) {

	}


	@Override
	public int compareTo(Order o) {

	}
}
