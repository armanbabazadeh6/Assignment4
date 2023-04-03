import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PropertyTestStudent {

	@Test
	public void testPropertyConstructorAndGetters() {
		Property p1 = new Property();
		assertEquals("", p1.getCity());
		assertEquals("", p1.getPropertyName());
		assertEquals(0.0, p1.getRentAmount());
		assertEquals("", p1.getOwner());
		assertNotNull(p1.getPlot());
	}

	@Test
	public void testPropertySetters() {
		Property p1 = new Property();
		p1.setCity("New York");
		p1.setPropertyName("Park Avenue");
		p1.setRentalAmount(2000.0);
		p1.setOwner("John Smith");
		Plot plot = new Plot(10, 20, 30, 40);
		p1.setPlot(plot);

		assertEquals("New York", p1.getCity());
		assertEquals("Park Avenue", p1.getPropertyName());
		assertEquals(2000.0, p1.getRentAmount());
		assertEquals("John Smith", p1.getOwner());
		assertEquals(plot, p1.getPlot());
	}

	@Test
	public void testDefaultConstructor() {
		Property p = new Property();
		assertEquals("", p.getPropertyName());
		assertEquals("", p.getCity());
		assertEquals(0, p.getRentAmount(), 0.001);
		assertEquals("", p.getOwner());
	}

	@Test
	public void testPropertyToString() {
		Property p1 = new Property("Riviera", "Miami", 3000.0, "Maria Perez", 10, 20, 30, 40);
		assertEquals("Riviera,Miami,Maria Perez,3000.0", p1.toString());
	}

	@Test
	public void testPropertyEquals() {
		Property p1 = new Property("Riviera", "Miami", 3000.0, "Maria Perez", 10, 20, 30, 40);
		Property p2 = new Property("Riviera", "Miami", 3000.0, "Maria Perez", 10, 20, 30, 40);
		Property p3 = new Property("Riviera", "Miami", 2500.0, "Maria Perez", 10, 20, 30, 40);
		Property p4 = new Property("Riviera", "Miami", 3000.0, "Maria Perez", 20, 30, 40, 50);

		assertFalse(p1.equals(p3));
		assertFalse(p1.equals(p4));
	}
}
