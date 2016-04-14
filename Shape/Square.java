import java.awt.Color;

public class Square extends Polygon {
	public Square(Color aColor, double centerX, double centerY, double sideLength) {
		super(aColor, 4);
		double halfSideLength = sideLength / 2;
		super.setPoint(0, centerX - halfSideLength, centerY - halfSideLength);
		super.setPoint(1, centerX - halfSideLength, centerY + halfSideLength);
		super.setPoint(2, centerX + halfSideLength, centerY + halfSideLength);
		super.setPoint(3, centerX - halfSideLength, centerY - halfSideLength);
	}
}
