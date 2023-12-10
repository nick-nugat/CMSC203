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

import java.util.Scanner;

public class BevShopDriverApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BevShop shop = new BevShop();
		String anotherOrderDecision = "y";

		System.out.println(
				"""
				The current order in process can have at most 3 alcoholic beverages.
				The minimum age to order alcohol drink is 21.
				Please begin your order:"""
		);

		while(anotherOrderDecision.equalsIgnoreCase("y")) {
			Day currentDay;
			Size size;

			boolean wantsMoreAlcohol = true;
			boolean wantsMoreSmoothie = true;
			boolean wantsMoreCoffee = true;

			String customerName;
			int customerAge;

			String beverageName;
			String beverageSize;

			String addProtein;

			String moreAlcoholDecision;
			String moreSmoothieDecision;
			String moreCoffeeDecision;
			String genDecision;

			int numOfFruits;
			int currentTime;

			anotherOrderDecision = "n";

			System.out.println("Your total order for now is 0.0");
			System.out.println();

			System.out.print("Please enter your name: ");
			customerName = scanner.nextLine();

			System.out.print("Please enter your age: ");
			customerAge = scanner.nextInt();
			scanner.nextLine();

			System.out.print("What is the time right now? (8-23) ");
			currentTime = scanner.nextInt();
			scanner.nextLine();

			System.out.print("What day is it? ");
			currentDay = Day.valueOf(scanner.nextLine().toUpperCase());

			shop.startNewOrder(
					currentTime, currentDay,
					customerName, customerAge
			);
			shop.getCurrentOrder().generateOrder();

			//alcohol processing
			if (shop.isValidAge(customerAge)) {
				System.out.println("You are over 20, which is old enough for alcohol");
				
				System.out.print("Do you want any alcohol? (y/n) ");
				genDecision = scanner.nextLine();
				
				//wants alcohol
				if (genDecision.equalsIgnoreCase("y")) {
					while(wantsMoreAlcohol) {
						System.out.print("What is the name of your drink? ");
						beverageName = scanner.nextLine();

						System.out.print("What size do you want? (small/medium/large) ");
						beverageSize = scanner.nextLine();
						size = Size.valueOf(beverageSize.toUpperCase());

						shop.processAlcoholOrder(beverageName, size);

						System.out.print("Do you want more alcohol? (y/n) ");
						moreAlcoholDecision = scanner.nextLine();
						wantsMoreAlcohol = (moreAlcoholDecision.equalsIgnoreCase("y"));
						if (!shop.isEligibleForMore()){
							System.out.println("You have reached the maximum amount of alcohol!");
							break;
						}
					}
					printCurrentOrderStatus(shop);
				}
			} else {
				System.out.print("You are not old enough for alcohol");
			}

			System.out.println();
			System.out.println();

			//smoothie processing
			System.out.print("Do you want any smoothies? (y/n) ");
			genDecision = scanner.nextLine();

			if (genDecision.equalsIgnoreCase("y")) {
				while(wantsMoreSmoothie) {
					System.out.print("What is the name of your drink? ");
					beverageName = scanner.nextLine();

					System.out.print("What size do you want? (small/medium/large) ");
					beverageSize = scanner.nextLine();
					size = Size.valueOf(beverageSize.toUpperCase());

					System.out.print("Do you want protein? (y/n) ");
					addProtein = scanner.nextLine();
					boolean proteinDecision = addProtein.equalsIgnoreCase("y");

					System.out.print("How many fruits do you want? ");
					numOfFruits = scanner.nextInt();
					scanner.nextLine();

					if (shop.isMaxFruit(numOfFruits)) {
						System.out.println("You have reached the maximum amount of fruit!");
						break;
					} else{
						shop.processSmoothieOrder(
								beverageName, size,
								numOfFruits, proteinDecision
						);
					}
					System.out.print("Do you want another smoothie? (y/n) ");
					moreSmoothieDecision = scanner.nextLine();
					wantsMoreSmoothie = (moreSmoothieDecision.equalsIgnoreCase("y"));
				}
				printCurrentOrderStatus(shop);
			}

			System.out.println();
			System.out.println();

			//coffee processing
				System.out.print("Do you want coffee? (y/n) ");
				genDecision = scanner.nextLine();

				if (genDecision.equalsIgnoreCase("y")) {
					while(wantsMoreCoffee) {
						System.out.print("What is the name of your drink? ");
						beverageName = scanner.nextLine();

						System.out.print("What size do you want? (small/medium/large) ");
						beverageSize = scanner.nextLine();
						size = Size.valueOf(beverageSize.toUpperCase());

						System.out.print("Do you want extra shot? (y/n) ");
						genDecision = scanner.nextLine();
						boolean extraShotDecision = genDecision.equalsIgnoreCase("y");

						System.out.print("Do you want extra syrup? (y/n) ");
						genDecision = scanner.nextLine();
						boolean extraSyrupDecision = genDecision.equalsIgnoreCase("y");

						shop.processCoffeeOrder(
								beverageName,
								size,
								extraShotDecision,
								extraSyrupDecision
						);

						System.out.print("Do you want another coffee drink? (y/n) ");
						moreCoffeeDecision = scanner.nextLine();
						wantsMoreCoffee = (moreCoffeeDecision.equalsIgnoreCase("y"));
					}
					printCurrentOrderStatus(shop);
				}

			System.out.println();
			System.out.println();

			System.out.print("Do you want to start another order? (y/n) ");
			anotherOrderDecision = scanner.nextLine();

			System.out.println();
			if (anotherOrderDecision.equalsIgnoreCase("y")){
				System.out.println("**********************");
			} else{
				System.out.println("Thank you for visiting!");
				break;
			}
		} //end while loop

		System.out.println(shop);

		scanner.close();
	}

	//prints num of drinks in order and total price
	private static void printCurrentOrderStatus (BevShop shop){
		System.out.print(
				"The current order of drinks is "
		      + shop.getCurrentOrder().getTotalItems() + '\n'
		      + "The total price on the order is "
			  + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo())
		);
	}
}
