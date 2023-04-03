public class ManagementCompany {

	private String name;
	private String taxID;
	private double mgmFeePer;

	public final int MAX_PROPERTY = 5; // all three constant values
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;

	private Property[] properties; // array of properties from property class
	private Plot plot; // Plot from plot class
	private int numberOfProperties;

	public ManagementCompany() { // setting initial values
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];

	}

	public ManagementCompany(String name, String taxID, double mgmFee) {

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);

	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);

	}

	public ManagementCompany(ManagementCompany otherCompany) { // copy constructor
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = otherCompany.properties;
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public int addProperty(Property property) { // COME BACK

		if (numberOfProperties >= MAX_PROPERTY) {
			return -1;
		}

		if (property.equals(null)) {
			return -2;
		}

		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}

		for (int i = 0; i < numberOfProperties; i++) { // check if property plot overlaps with any other property's
														// plot
			if (properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		properties[numberOfProperties] = property; // add property to array
		return numberOfProperties++;

	}

	public int addProperty(String name, String city, double rent, String owner) {

		return addProperty(new Property(name, city, rent, owner));

	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}

	public void removeLastProperty() {

		properties[numberOfProperties--] = null;

	}

	public Property getHighestRentPropperty() {

		Property highestValue = properties[0];

		for (int i = 0; i < properties.length; i++) {

			if (properties[i] != null) {
				if (properties[i].getRentAmount() > highestValue.getRentAmount()) {

					highestValue = properties[i];
				}

			}

		}

		return highestValue;
	}

	public double getTotalRent() {

		double total = 0;

		for (int i = 0; i < properties.length; i++) {

			if (properties[i] != null) {
				total += properties[i].getRentAmount();
			}

		}

		return total;
	}

	public boolean isPropertiesFull() {
		return numberOfProperties >= MAX_PROPERTY;
	}

	public int getPropertiesCount() {
		return numberOfProperties;
	}

	public boolean isManagmentFeeValid() {

		return mgmFeePer >= 0 && mgmFeePer <= 100;

	}

	public String toString() {

		String listOfProperties = "";

		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				listOfProperties += properties[i] + "\n";
			}

		}

		return "List of the properties for " + name + ", taxID: " + taxID
				+ "\n-----------------------------------------------\n" +

				listOfProperties

				+ "-----------------------------------------------" + "\nTotal management Fee: "
				+ (getTotalRent() * mgmFeePer / 100);

	}

}
