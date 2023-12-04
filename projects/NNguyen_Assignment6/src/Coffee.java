public class Coffee extends Beverage {
	private final boolean extraShot, extraSyrup;

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
		return getName() + ","
				+ getSize() + ","
				+ "Extra shot: " + extraShot + ","
				+ "Extra syrup: " + extraSyrup
				+ "Price: " + calcPrice();
	}
}
