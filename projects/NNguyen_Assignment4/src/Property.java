/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description:
 * Due: 11/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

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

        this.plot = new Plot();
    }

    public Property(String name, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
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

    public String getPropertyName() { return this.name; }
    public double getRentAmount() { return this.rentAmount; }
    public Plot getPlot() { return this.plot; }
    public String getCity() { return this.city; }
    public String getOwner() { return this.owner; }

    @Override
    public String toString() {
        return this.getPropertyName() + "," +
               this.getCity() + "," +
               this.getOwner() + "," +
               this.getRentAmount();
    }


}
