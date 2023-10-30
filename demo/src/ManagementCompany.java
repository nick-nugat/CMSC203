public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFee;
    private int numberOfProperties;
    private Property[] properties;
    private Plot plot;

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
        this.mgmFee = mgmFee;

        plot = new Plot();
        plot.setWidth(MGMT_WIDTH);
        plot.setDepth(MGMT_DEPTH);

        properties = new Property[MAX_PROPERTY]; //idk if this is the right length
    }

    //constructor with same parameters + properties fields
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this(name, taxID, mgmFee);
        plot = new Plot(x, y, width, depth);
    }

    //copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        new ManagementCompany(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee);
    }


    public int addProperty(String name,
                           String city,
                           double rent,
                           String owner){
        if (isPropertiesFull()) return -1;

        for (int i = 0; i < properties.length; i++) {
            properties[i] = new Property(name, city, rent, owner);
            //if property object null @return -2
            //if mgmt company does not encompass property plot


        }


    }

    public int addProperty(String name,
                           String city,
                           double rent,
                           String owner,
                           int x,
                           int y,
                           int width,
                           int depth) {

    }

    public int addProperty(Property property) {

    }

    public void removeLastProperty() {

    }

    public boolean isPropertiesFull() {

    }



    public Property getHighestRentProperty() {

    }

    public boolean isManagementFeeValid() {

    }

    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public Property[] getProperties() { return properties; }
    public double getMgmFee() { return mgmFee; }
    public Plot getPlot() { return plot; }
    public int getNumberOfProperties() { return numberOfProperties; }

    public double getTotalRent() {
        double total = 0;

		for (Property property: properties) {
			total += property.getRentAmount();
		}
        return total;
    }

    public String toString() {

    }



}
