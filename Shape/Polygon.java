import java.awt.Color;

public class Polygon extends Shape {
	public Polygon(Color aColor, int numCorners) {
		super(aColor);
		if (numCorners < 3) {
			throw new IllegalArgumentException("Polygon(): numCorners must be >= 3");
		}
		myPoints = new Point[numCorners];
	}
	
	protected void setPoint(int i, double x, double y) {
		myPoints[i] = new Point(x, y);
	}
	
	public Point getPoint(int i) { return myPoints[i]; }
	
	public void draw(Plotter plot) {
		plot.setPenColor( super.getColor() );
		Point p0 = myPoints[0], p1 = null;
		for (int i = 1; i < myPoints.length; i++) {
			p1 = myPoints[i];
			plot.drawLine( p0.getX(), p0.getY(), p1.getX(), p1.getY() );
			p0 = p1;
		}
		plot.drawLine( p1.getX(), p1.getY(), myPoints[0].getX(), myPoints[0].getY() );
	}
	private Point [] myPoints = null;
	
}
