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

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;

	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup){
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean getExtraShot() { return extraShot; }
	public boolean getExtraSyrup() { return extraSyrup; }

	@Override
	public double calcPrice() {
		double price = addSizePrice();

		if (extraSyrup) price += 0.50;
		if (extraShot) price += 0.50;

		return price;
	}

	@Override
	public boolean equals(Object obj){
		Coffee other = (Coffee) obj;

		return super.equals(other)
			&& getBasePrice() == other.getBasePrice()
			&& getExtraShot() == other.getExtraShot()
			&& getExtraSyrup() == other.getExtraSyrup();
	}

	@Override
	public String toString(){
		return super.toString() + '\n'
				+ "Extra shot: " + extraShot + '\n'
				+ "Extra syrup: " + extraSyrup + '\n'
				+ "Price: " + calcPrice();
	}
}
