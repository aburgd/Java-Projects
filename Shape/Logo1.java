import java.awt.Color;

public class Logo1 {
	public static void main(String[] args) {
		Plotter plotter = new Plotter(0, 0, 10, 10);
		plotter.hideAxes();
		Shape shape = new Square(Color.RED, 5, 5, 10);
		shape.draw(plotter);
		shape = new Circle(Color.GREEN, 5, 5, 5);
		shape.draw(plotter);
		shape = new Triangle(Color.BLUE, 1, 2, 5, 10, 9, 2);
		shape.draw(plotter);
	}
}
