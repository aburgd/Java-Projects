import java.awt.Color;
import java.util.LinkedList;

public class Logo {
	public Logo() {
		myShapes = new LinkedList<Shape>();
		myShapes.add( new Square(Color.RED, 5, 5, 10) );
		myShapes.add( new Circle(Color.GREEN, 5, 5, 5) );
		myShapes.add( new Triangle(Color.BLUE, 1, 2, 5, 10, 9, 2) );
	}
	
	public void draw(Plotter plotter) {
		plotter.hideAxes();
		for(Shape shape : myShapes) {
			shape.draw(plotter);
		}
	}
	
	private LinkedList<Shape> myShapes = null;
	
	public static void main(String[] args) {
		Logo self = new Logo();
		self.draw(new Plotter(0, 0, 10, 10) );
	}
}
