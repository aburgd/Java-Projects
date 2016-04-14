import java.awt.Color;

public class Circle extends Shape {
  public Circle(Color aColor, double centerX, double centerY, double radius) {
    super(aColor);
    myX = centerX; myY = centerY; myRad = radius;
  }
   
  public double getRad() { return myRad; }
  public Point getCenter() { return new Point(myX, myY); }
  
  public void draw(Plotter plot) {
    double diameter = myRad * 2;
    plot.setPenColor( super.getColor() );
    plot.drawOval(myX, myY, diameter, diameter);
  }
  
  private double myRad, myX, myY;
}
