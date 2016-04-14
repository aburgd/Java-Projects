import java.awt.Color;

abstract public class Shape {
  public Shape(Color aColor) { myColor = aColor; }
  
  public Color getColor() { return myColor; }
  
  abstract public void draw(Plotter plot);
  
  private Color myColor;
}
