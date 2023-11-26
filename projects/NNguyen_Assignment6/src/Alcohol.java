public class Alcohol extends Beverage {
	private final boolean isWeekend;

	public Alcohol(String name, Size size, boolean isWeekend){
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	public boolean isWeekend() { return isWeekend; }

	@Override
	public boolean equals(Object obj) {
		Alcohol other = (Alcohol) obj;

		return
			super.equals(other) &&
			getBasePrice() == other.getBasePrice() &&
			isWeekend == other.isWeekend;
	}

	@Override
	public String toString() {
		return
			super.toString() +
			"Available on weekend: " + isWeekend + "\n" +
			"Price: " + calcPrice();
	}

	@Override
	public double calcPrice() {
		double price = getBasePrice();
		if (isWeekend) price += 0.60;
		return price;

	}
}
