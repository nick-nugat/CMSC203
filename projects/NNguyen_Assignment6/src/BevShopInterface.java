/**
 * Interface for an Order
 *
 * @author Greg Grinberg
 * @version 8/21/2022
 **/
public interface BevShopInterface {

	int MIN_AGE_FOR_ALCOHOL = 21;  //Minimum age for offering alcohol drink
	int MAX_ORDER_FOR_ALCOHOL= 3;   /*Maximum number of alcohol beverages
										that can be ordered within an order  */
	int MIN_TIME= 8;				//earliest time for the order
	int MAX_TIME= 23;				//latest  time for the order
	int MAX_FRUIT = 5;				//Maximum number of fruits that this shop offers for SMOOTHIE beverage


	/**
	 * Checks if the time is valid (between 8 and 23 )
	 *
	 * @param time
	 *            time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean isValidTime(int time);

	/**
	 * returns the constant value for the minimum age for offering Alcohol drink
	 *
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMaxNumOfFruits();


	/**
	 * returns the constant value for the Maximum age for offering Alcohol drink
	 *
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMinAgeForAlcohol();


	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 *
	 * @param numOfFruits
	 *            number of fruits
	 * @return true if the passed parameter exceeds the MAXIUM number of fruits
	 *         allowed for the SMOTHIE drink, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits);

	/**
	 * returns constant maximum number of alcohol beverages/per order offered by
	 * the beverage shop
	 *
	 * @return constant maximum number of alcohol beverages/per order offered by
	 *         the beverage shop
	 */
	public int getMaxOrderForAlcohol();

	/**
	 * checks if the number of alcohol beverages for the current order has
	 * reached the maximum
	 *
	 * @return true if number of alcohol drinks for the current order has
	 *         reached the maximum , false otherwise
	 */
	public boolean isEligibleForMore();

	/**
	 * returns the number of alcohol drinks for the current order
	 *
	 * @return returns the number of alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink();

	/**
	 * check the valid age for the alcohol drink
	 *
	 * @param age
	 *            the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	public boolean isValidAge(int age);

	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 *
	 * @param time
	 *            time of the order
	 * @param day
	 *            day of the order of type DAY
	 * @param customerName
	 *            customer name
	 * @param customerAge
	 *            customer age
	 */

	public void startNewOrder(int time, Day day, String customerName, int customerAge);

	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup);

	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size);

	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtein
	 *            true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein);

	/**
	 * locate an order based on the order number
	 *
	 * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	public int findOrder(int orderNo);

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 *
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo);

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale();

	/**
	 * returns total numbers of orders within the month
	 *
	 * @returns total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders();

	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 *
	 * @return the current order
	 */
	public Order getCurrentOrder();

	/**
	 * returns Order in the list of orders at the index Notes: this method
	 * returns the shallow copy of the order
	 *
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index);

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders();


}
