import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany m;

	@Before
	public void setUp() throws Exception {
		p1 = new Property("Ovid Hazen", "Clarksburg", 5849, "Hamza Anthony", 8, 1, 1, 1);
		p2 = new Property("Gateway Cafe", "Clarksburg", 3432, "Amir H", 3, 1, 1, 1);
		p3 = new Property("Super Center", "Germantown", 4738, "Daniel Dirico", 5, 1, 1, 1);

		m = new ManagementCompany("Arman", "555555555", 6);

		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() throws Exception {
		p1 = p2 = p3 = p4 = p5 = p6 = null;
		m = null;
	}

	@Test
	public void testAddProperty() {
		p4 = new Property("Walmart", "Fredrick", 4892, "Joe Wilson", 5, 1, 1, 1);
		p5 = new Property("Miles Stone", "Germantown", 4839, "Joey bob", 3, 1, 1, 1);
		p6 = new Property("A lot of Prob", "AllyWay", 4738, "Jack Scott", 1, 1, 1, 1);

		assertEquals(m.addProperty(p4), -4, 0);
		assertEquals(m.addProperty(p5), -4, 0);
		assertEquals(m.addProperty(p6), 3, 0);
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.getTotalRent(), 14019.0, 0);
	}

	@Test
	public void isPropertiesFull() {

		assertEquals(m.isPropertiesFull(), false);
	}

	@Test
	public void getHighestRentPropperty() {
		// Test that the maxRentProp method returns the property with the highest rent
		assertEquals(m.getHighestRentPropperty().getRentAmount(), 5849, 0);
	}

	@Test
	public void isManagmentFeeValid() {
		assertEquals(m.isManagmentFeeValid(), true);
	}

	@Test
	public void testGetPropertiesCount() {
		assertEquals(m.getPropertiesCount(), 3);
	}

	@Test
	public void testRemoveLastProperty() {
		int expectedCount = m.getPropertiesCount() - 1;
		m.removeLastProperty();
		assertEquals(expectedCount, m.getPropertiesCount());
	}

	@Test
	public void testConstructor() {
		String name = "My Company";
		String taxID = "123456789";
		double mgmFee = 0.1;
		ManagementCompany company = new ManagementCompany(name, taxID, mgmFee);
		assertNotNull(company);
		assertEquals(name, company.getName());
		assertEquals(taxID, company.getTaxID());
		assertEquals(mgmFee, company.getMgmFeePer(), 0);
		assertEquals(0, company.getPropertiesCount());
		assertEquals(0, company.getPlot().getX());
		assertEquals(0, company.getPlot().getY());
	}

	@Test
	public void testConstructorWithNameTaxIDMgmFeeXYWidthDepth() {
		String name = "Test Company";
		String taxID = "123456789";
		double mgmFee = 10.0;
		int x = 1;
		int y = 2;
		int width = 3;
		int depth = 4;

		ManagementCompany company = new ManagementCompany(name, taxID, mgmFee, x, y, width, depth);

		assertEquals(name, company.getName());
		assertEquals(taxID, company.getTaxID());
		assertEquals(mgmFee, company.getMgmFeePer(), 0.0);
		assertEquals(x, company.getPlot().getX());
		assertEquals(y, company.getPlot().getY());
		assertEquals(width, company.getPlot().getWidth());
		assertEquals(depth, company.getPlot().getDepth());
	}

}
