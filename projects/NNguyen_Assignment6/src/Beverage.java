public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;

	public static final double BASE_PRICE = 2;
	public static final double SIZE_PRICE = 1;

	public Beverage(String name, Type type, Size size){
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public double getBasePrice() { return BASE_PRICE; }
	public String getName() { return name; }
	public Type getType() { return type; }
	public Size getSize() { return size; }

	public abstract double calcPrice();
	public double addSizePrice() {
		return size == Size.MEDIUM
					? BASE_PRICE + SIZE_PRICE
			:  size == Size.LARGE
					? BASE_PRICE + (SIZE_PRICE + SIZE_PRICE)
			:  BASE_PRICE;
	}


	@Override
	public boolean equals(Object obj){
		Beverage other = (Beverage) obj;

		return name.equals(other.name)
			&& type == other.type
			&& size == other.size;
	}

	@Override
	public String toString() {
		return "Name: " + name
			 + "\nSize: " +  size;
	}
}
