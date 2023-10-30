public class Property {
    private String name;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this.name = "";
        this.city = "";
        this.owner = "";
    }

    public Property(String name, String city, double rentAmount, String owner) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.rentAmount = rentAmount;
    }

    public Property(String name,
                    String city,
                    String owner,
                    double rentAmount,
                    int x,
                    int y,
                    int width,
                    int depth) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.rentAmount = rentAmount;
        this.plot = new Plot(x, y, width, depth);

    }

    public Property(Property otherProperty) {
        this(otherProperty.name,
             otherProperty.city,
             otherProperty.rentAmount,
             otherProperty.owner);
    }

    public String getName() { return this.name; }
    public String getCity() { return this.city; }
    public String getOwner() { return this.owner; }
    public double getRentAmount() { return this.rentAmount; }
    public Plot getPlot() { return this.plot; }

    @Override
    public String toString() {
        return this.getName() + ", " +
                this.getCity() + ", " +
                this.getOwner() + ", " +
                this.getRentAmount();
    }


}
