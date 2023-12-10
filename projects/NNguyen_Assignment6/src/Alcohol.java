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

public class Alcohol extends Beverage {
	private boolean isWeekend;

	public Alcohol(String name, Size size, boolean isWeekend){
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	@Override
	public double calcPrice() { return isWeekend ? (addSizePrice() + 0.60) : addSizePrice(); }
	public boolean isWeekend() { return isWeekend; }

	@Override
	public boolean equals(Object obj) {
		Alcohol other = (Alcohol) obj;

		return super.equals(other)
			&& getBasePrice() == other.getBasePrice()
			&& isWeekend == other.isWeekend;
	}

	@Override
	public String toString() {
		return super.toString() + '\n'
			+ "Available on weekend: " + isWeekend + '\n'
			+ "Price: " + calcPrice();
	}
}
