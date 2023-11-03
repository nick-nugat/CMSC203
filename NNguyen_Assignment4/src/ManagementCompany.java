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
public class ManagementCompany {
    //instance variables/fields
    private String name;
    private String taxID;
    private double mgmFee;
    private int numberOfProperties;
    private Property[] properties;
    private Plot plot;

    //public constants
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    //no-arg constructor
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";

        plot = new Plot();
        plot.setWidth(MGMT_WIDTH);
        plot.setDepth(MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
    }

    //constructor with company fields
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee / 100;

        plot = new Plot();
        plot.setWidth(MGMT_WIDTH);
        plot.setDepth(MGMT_DEPTH);

        properties = new Property[MAX_PROPERTY];
    }

    //constructor with same parameters + properties fields
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this(name, taxID, mgmFee);
        plot = new Plot(x, y, width, depth);
    }

    //copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name,
             otherCompany.taxID,
             otherCompany.mgmFee);
    }

    //overloaded add property methods
    public int addProperty(Property property) {
        if (property == null) return -2;
        if (isPropertiesFull()) return -1;
        if (!(plot.encompasses(property.getPlot()))) return -3;

        int i = 0;
        for (; i < properties.length; i++) {

            if ((properties[i] != null) && property.getPlot().overlaps(properties[i].getPlot()))
                    return -4;
            else if (properties[i] == null) {
                properties[i] = property;
                break;
            }

        }
        return i;

    }

    public int addProperty(String name, String city, double rent, String owner){
        Property p = new Property(name, city, rent, owner);
        return addProperty(p);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property p = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(p);
    }

    //remove last property (nullify)
    public void removeLastProperty() {
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i] != null) properties[i] = null;
        }
	}

    //checks if properties array is full
    public boolean isPropertiesFull() {
		for (Property property : properties) {
			if (property == null) return false;
		}
        return true;
    }

    //gets the properties inside the properties array (excludes null)
    public int getPropertiesCount() {
        numberOfProperties = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) numberOfProperties++;
        }
        return numberOfProperties;
    }

    //gets total rent of the properties in the properties array
    public double getTotalRent() {
        double total = 0;

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) total += properties[i].getRentAmount();
        }
        return total;
    }

    //returns property with the highest rent in the properties array
    public Property getHighestRentProperty() {

        Property highestRentProperty = properties[0]; // Assume the first property has the highest rent

        for (int i = 1; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i]; // Update the highest rent property
            }
        }

        return highestRentProperty;
    }


    //checks if the management fee is between 0 and 100
    public boolean isManagementFeeValid() { return mgmFee > 0 && mgmFee < 100; }

    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public Property[] getProperties() { return properties; }

    //gets management fee per
    public double getMgmFeePer() {
        double value = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                value += properties[i].getRentAmount() * mgmFee;
            }
        }
        return value;
    }
    public Plot getPlot() { return plot; }


    //toString() override
    @Override
    public String toString() {
        String data = "";
        String companyName = "";
        String propertyName = "";
        String city = "";
        String owner = "";
        double rent = 0;
        double totalManagementFee = getMgmFeePer();

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                companyName = this.name;
                propertyName += properties[i].getPropertyName();
                city += properties[i].getCity();
                owner += properties[i].getOwner();
                rent += properties[i].getRentAmount();
                data += propertyName + "," + city + "," + owner + "," + rent + "\n";
            }
        }


            return "List of the properties for " + name + ", " + "taxID: " + taxID + "\n"
                + "______________________________________________________\n"
                + data
                + "______________________________________________________\n"
                + "\n"
                + " total management Fee: " + totalManagementFee;

    }
}



