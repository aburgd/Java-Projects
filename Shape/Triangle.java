import java.awt.Color;

public class Triangle extends Polygon {
	public Triangle(Color aColor, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(aColor, 3);
		super.setPoint(0, x1, y1);
		super.setPoint(1, x2, y2);
		super.setPoint(2, x3, y3);
	}
}
