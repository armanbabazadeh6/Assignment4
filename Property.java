
public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	public Property() {
		this.city = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.owner = "";
		this.plot = new Plot();

	}

	public Property(String propertyName, String city, double rentalAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentalAmount;
		this.owner = owner;
		this.plot = new Plot();

	}

	public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width,
			int depth) {

		this.city = city;
		this.propertyName = propertyName;
		this.rentAmount = rentalAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);

	}

	public Property(Property otherProperty) {
		this.city = otherProperty.city;
		this.propertyName = otherProperty.propertyName;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);

	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentalAmount(double rentalAmount) {
		this.rentAmount = rentalAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public String toString() {

		return propertyName + "," + city + "," + owner + "," + rentAmount;

	}

}
