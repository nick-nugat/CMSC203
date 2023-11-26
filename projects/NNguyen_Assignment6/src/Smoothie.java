public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean proteinAdded;

	public Smoothie(String name, Size size, int numOfFruits, boolean proteinAdded) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.proteinAdded = proteinAdded;
	}

	@Override
	public double calcPrice() {
		double price = getBasePrice();

		if (proteinAdded) price += 1.50;
		price += numOfFruits * 0.50;

		return price;
	}

	@Override
	public boolean equals(Object obj){
		Smoothie other = (Smoothie) obj;

		return super.equals(other)
				&& numOfFruits == other.numOfFruits
				&& proteinAdded == other.proteinAdded;
	}

	public String toString(){
		return super.toString()
				+ "Protein added: " + proteinAdded + "\n"
				+ "Number of fruits: " + numOfFruits + "\n"
				+ "Price: " + calcPrice();
	}

	public int getNumOfFruits() { return numOfFruits; }

	public boolean isProteinAdded() { return proteinAdded; }
}
