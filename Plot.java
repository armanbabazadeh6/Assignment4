
public class Plot {

	private int x;
	private int y;
	private int depth;
	private int width;

	public Plot() {
		this.width = 1;
		this.depth = 1;
	}

	public Plot(int x, int y, int width, int depth) {

		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}

	public Plot(Plot otherPlot) {

		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean overlaps(Plot plot) {
		int x2 = plot.getX();
		int y2 = plot.getY();
		int depth2 = plot.getDepth();
		int width2 = plot.getWidth();

		if (x + width > x2 && x2 + width2 > x) { // checks if plots overlap
													// horizontally

			if (y + depth > y2 && y2 + depth2 > y) { // checks if plots
														// overlap
														// vertically
				return true; // if the plots are overlap
			}
		}
		return false; // return false if plots do not overlap
	}

	public boolean encompasses(Plot plot) {

		int x2 = plot.getX();
		int y2 = plot.getY();
		int depth2 = plot.getDepth();
		int width2 = plot.getWidth();

		if (x2 >= x && x2 + width2 <= x + width) {
			if (y2 >= y && y2 + depth2 <= y + depth) {
				return true; // if it contains
			}
		}

		return false; // if it is not contained

	}

	@Override
	public String toString() { // to string method

		return x + "," + y + "," + width + "," + depth;

	}

}
