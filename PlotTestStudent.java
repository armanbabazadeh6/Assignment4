import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {

	private Plot plot1, plot2, plot3, plot4, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(1, 1, 5, 5);
		plot2 = new Plot(6, 6, 5, 5);
		plot3 = new Plot(3, 3, 2, 2);
		plot4 = new Plot(0, 0, 10, 10);
		plot5 = new Plot(3, 3, 5, 5);
	}

	@Test
	public void testOverlaps() {
		// assertTrue(plot1.overlaps(plot3)); // plot1 and plot3 overlap
		assertFalse(plot1.overlaps(plot2)); // plot1 and plot2 don't overlap
		assertTrue(plot1.overlaps(plot4)); // plot1 is inside plot4, so they don't overlap
		assertTrue(plot1.overlaps(plot5)); // plot1 and plot5 overlap
	}

	@Test
	public void testEncompasses() {
		// assertTrue(plot1.encompasses(plot3)); // plot3 is not entirely inside plot1
		assertFalse(plot1.encompasses(plot2)); // plot2 is entirely outside plot1
		assertFalse(plot1.encompasses(plot4)); // plot4 contains plot1, not the other way around
		assertTrue(plot4.encompasses(plot1)); // plot1 is entirely inside plot4
		assertTrue(plot5.encompasses(plot3)); // plot3 is entirely inside plot5
		assertFalse(plot5.encompasses(plot1)); // plot1 is not entirely inside plot5
	}

	@Test
	public void testEncompassesFalse() {
		Plot p1 = new Plot(0, 0, 10, 10);
		Plot p2 = new Plot(5, 5, 10, 10);
		assertFalse(p1.encompasses(p2));
	}

	@Test
	public void testEncompassesTrue() {
		Plot p1 = new Plot(0, 0, 20, 20);
		Plot p2 = new Plot(5, 5, 10, 10);
		assertTrue(p1.encompasses(p2));
	}

	@Test
	public void testGetWidth() {
		assertEquals(5, plot2.getWidth());
	}

	@Test
	public void testGetDepth() {
		assertEquals(10, plot4.getDepth());
	}

	@Test
	public void testSetX() {
		plot3.setX(22);
		assertEquals(22, plot3.getX());
	}

}
