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

public class Smoothie extends Beverage {
	private final int numOfFruits;
	private final boolean addProtein;

	public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}

	@Override
	public double calcPrice() {
		double price = addSizePrice();

		if (addProtein) price += 1.50;
		if (numOfFruits > 0) price += numOfFruits * 0.50;

		return price;
	}
	public int getNumOfFruits() { return numOfFruits; }
	public boolean getAddProtein() { return addProtein; }

	@Override
	public boolean equals(Object obj){
		Smoothie other = (Smoothie) obj;

		return super.equals(other)
				&& getBasePrice() == other.getBasePrice()
				&& numOfFruits == other.numOfFruits
				&& addProtein == other.addProtein;
	}

	@Override
	public String toString(){
		return super.toString() + '\n'
				+ "Protein added: " + addProtein + '\n'
				+ "Number of fruits: " + numOfFruits + '\n'
				+ "Price: " + calcPrice();
	}

}
