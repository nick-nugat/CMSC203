import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	private int orderNum;
	private Day orderDay;
	private int orderTime;
	private int totalItems;
	private Customer customer;
	private Beverage beverage;

	public Order(int orderTime, Day orderDay, Customer customer){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
	}

	public int generateOrder(){
		Random random = new Random();
		return random.nextInt(80000) + 10000;
	}

	public int getOrderNum() { return orderNum; }
	public Day getOrderDay() { return orderDay; }
	public int getOrderTime() { return orderTime; }
	public int getTotalItems() { return totalItems; }
	public Customer getCustomer() { return customer; }

	@Override
	public Beverage getBeverage(int itemNo) {

	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		bevName = beverage.getName();
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {

	}

	@Override
	public double calcOrderTotal() {
		return 0;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		return 0;
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {

	}



	@Override
	public boolean isWeekend() {
		return orderDay == Day.SATURDAY
				|| orderDay == Day.SUNDAY;
	}

	@Override
	public int compareTo(Order o) {
		return 0;
	}
}
