import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class ChaosGame {
	public ChaosGame(int numPoints) {
		if(numPoints <= 0) {
			System.err.println("ChaosGame(reps): reps must be positive");
			System.exit(1);
		} 
		myPlot = new Plotter(0, 0, 1, 1, "Chaos");
		myPlot.hideAxes();
		drawVertices();
		drawPoints(numPoints);
	}
	
	private void drawVertices() {
		// red point
		myRedVertex = new Point(0.5, 1.0);
		myPlot.setPenColor(Color.RED);
		myPlot.drawPoint(myRedVertex.x, myRedVertex.y);
		
		// green point
		myGreenVertex = new Point(0.0, 0.0);
		myPlot.setPenColor(Color.GREEN);
		myPlot.drawPoint(myGreenVertex.x, myGreenVertex.y);
		
		// blue point
		myBlueVertex = new Point(1.0, 0.0);
		myPlot.setPenColor(Color.BLUE);
		myPlot.drawPoint(myBlueVertex.x, myBlueVertex.y);
	}
	
	private void drawPoints(int numPoints) {
		Random rng = new Random();
		Point p1 = new Point(rng.nextDouble(), rng.nextDouble());
		Point p2 = null;
		
		for (int i = 0; i < numPoints; i++) {
			int dieRoll = rng.nextInt(6);
			switch (dieRoll) {
			case 0: case 1: 
				p2 = findPointHalfwayBetween(p1, myRedVertex);
				drawPoint(p2, Color.RED, i);
				break;
			case 2: case 3:
				p2 = findPointHalfwayBetween(p1, myGreenVertex);
				drawPoint(p2, Color.GREEN, i);
				break;
			case 4: case 5:
				p2 = findPointHalfwayBetween(p1, myBlueVertex);
				drawPoint(p2, Color.BLUE, i);
				break;
			default:
				System.err.println("run(): bad roll value: " + dieRoll);
				System.exit(1);
			}
			
			p1 = p2;
		}
	}
	
	private void drawPoint(Point p, Color color, int pointNumber) {
		final int START_DRAWING_AT = 5;
		if (pointNumber > START_DRAWING_AT) {
			myPlot.setPenColor(color);
			myPlot.drawPoint(p.x, p.y);
		}
	}
	
	private Point findPointHalfwayBetween(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
	}
	
	private class Point {
		public Point(double xVal, double yVal) { 
			x = xVal; 
			y = yVal; 
		}
		
		public double x, y;
	}
	
	private Plotter myPlot = null;
	private Point myRedVertex, myGreenVertex, myBlueVertex;
	
	public static void main(String[] args) {
		ChaosGame game1000 = new ChaosGame(1000);
		ChaosGame game10000 = new ChaosGame(10000);
	}
}
