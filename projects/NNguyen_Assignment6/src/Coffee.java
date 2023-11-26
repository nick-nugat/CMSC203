public class Coffee extends Beverage {
	private final boolean extraShot, extraSyrup;

	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup){
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean isExtraShot() { return extraShot; }
	public boolean isExtraSyrup() { return extraSyrup; }

	@Override
	public double calcPrice() {
		double price = getBasePrice();

		if (extraSyrup) price += 0.50;
		if (extraShot) price += 0.50;

		return price;
	}

	@Override
	public boolean equals(Object obj){
		Coffee other = (Coffee) obj;

		return super.equals(other)
			&& getBasePrice() == other.getBasePrice()
			&& isExtraShot() == other.isExtraShot()
			&& isExtraSyrup() == other.isExtraSyrup();
	}

	@Override
	public String toString(){
		return getName() + "," +
				getSize() + "," +
				"Extra shot: " + extraShot + "," +
				"Extra syrup: " + extraSyrup +
				"Price: " + calcPrice();
	}
}
