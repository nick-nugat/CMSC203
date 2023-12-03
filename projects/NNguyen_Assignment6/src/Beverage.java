public abstract class Beverage {
	private static final double
		SIZE_PRICE = 1,
		BASE_PRICE = 2;

	private String name; //name of beverage
	private Type type;
	private Size size;


	public Beverage(String name, Type type, Size size){
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public abstract double calcPrice();

	public double getBasePrice() { return BASE_PRICE; }
	public String getName() { return name; }
	public Type getType() { return type; }
	public Size getSize() { return size; }
	public double addSizePrice() { return BASE_PRICE + SIZE_PRICE;}

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
