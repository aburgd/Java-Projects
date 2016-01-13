/** Plotter.java is a widget for plotting (x,y) points/lines.
 *  @author:  Joel C. Adams, for Alice+Java.
 */

import java.awt.*; // Graphics, Color, ...
import javax.swing.*; // JFrame, JPanel, ...
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Plotter extends JFrame {
	/** Default constructor (8 x 8 coordinate system)
	 *  Postcondition: my lower left corner is (-4, -4) &&
	 *                 my upper right corner is (4, 4) &&
	 *                 my title is "PointPlotter"
	 */
	public Plotter() {
		this(0, 0, -4.0, -4.0, 4.0, 4.0, "Plotter");
		centerFrame();
	}

	/** Explicit value constructor using x-y values
	 * @param minX, a double
	 * @param minY, a double
	 * @param maxX, a double
	 * @param maxY, a double
	 * Postcondition: my lower left corner is (minX, minY) &&
	 *                 my upper right corner is (maxX, maxY) &&
	 *                 my title is "PointPlotter"
	 */
	public Plotter(double minX, double minY, double maxX, double maxY) {
		this(0, 0, minX, minY, maxX, maxY, "Plotter");
		centerFrame();
	}

	/** Explicit value constructor using x-y values
	 * @param minX, a double
	 * @param minY, a double
	 * @param maxX, a double
	 * @param maxY, a double
	 * Postcondition: my lower left corner is (minX, minY) &&
	 *                 my upper right corner is (maxX, maxY) &&
	 *                 my title is "PointPlotter"
	 */
	public Plotter(double minX, double minY, double maxX, double maxY, String title) {
		this(0, 0, minX, minY, maxX, maxY, title);
		centerFrame();
	}

	/** Explicit value constructor using x-y values
	 * @param screenX, an int
	 * @param screenY, an int
	 * @param minX, a double
	 * @param minY, a double
	 * @param maxX, a double
	 * @param maxY, a double
	 * @param title, a String
	 * Postcondition: I have been drawn at (screenX, screenY) &&
	 *                 my lower left corner is (minX, minY) &&
	 *                 my upper right corner is (maxX, maxY) &&
	 *                 my title is title
	 */
	public Plotter(int screenX, int screenY, double minX, double minY, double maxX, double maxY,
			String title) {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		myPanel = new PlotPanel(minX, minY, maxX, maxY);
		this.setContentPane(myPanel);
		this.setLocation(screenX, screenY);
		this.pack();
		this.setVisible(true);
	}
	
	private void centerFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight = (int)screenSize.getHeight();
		this.setLocation(((screenWidth / 2) - (this.getWidth()/2)),
		         ((screenHeight / 2) - (this.getHeight()/2)));
	}

	/** Draw a point at (x,y)
	 * @param x, a double
	 * @param y, a double
	 * Postcondition: I now have a point at (x,y)
	 */
	public void drawPoint(double x, double y) {
		myPanel.plotPoint(x, y);
	}
	
	/** draw a Line from (x1, y1) to (x2, y2).
	 * @param x1, a double
	 * @param y1, a double
	 * @param x2, a double
	 * @param y2, a double
	 * Postcondition: I contain a line from (x1, y1) to (x2, y2).
	 */
	public void drawLine(double x1, double y1, double x2, double y2) {
		myPanel.drawLine(x1, y1, x2, y2);
	}
	
	/** draw an Oval at (xCenter, yCenter), of the given width and height
	 * @param xCenter, a double
	 * @param yCenter, a double
	 * @param width, a double
	 * @param height, a double
	 * Postcondition: I contain an oval whose width is width, whose height
	 *               is height, and whose center is at (xCenter, yCenter).
	 */
	public void drawOval(double xCenter, double yCenter, 
			             double width, double height) {
		myPanel.drawOval(xCenter, yCenter, width, height);
	}
	
	/** Hide the axes 
	 * Postcondition: the axes in myPanel are hidden.
	 */
	public void hideAxes() {
		myPanel.hideAxes();
	}

	/** Make axes visible
	 * Postcondition: the axes in myPanel are visible.
	 */
	public void showAxes() {
		myPanel.showAxes();
	}

	/** Set pen color for graphics
	 * @param col, a Color
	 * Postcondition: whatever I draw next will be done in col.
	 */
	public void setPenColor(Color col) {
		myPanel.setPenColor(col);
	}

	/** Get the delta value for 1 column
	 * @return delta x for the given window size
	 */
	public double deltaX() {
		return myPanel.deltaX();
	}

	/** Get the delta value for 1 row
	 * @return delta y for the given window size
	 */
	public double deltaY() {
		return myPanel.deltaY();
	}

	/** Minimum x-value accessor
	 *  @return  my minimum x-value
	 */
	public double minX() {
		return myPanel.minX();
	}

	/** Minimum y-value accessor
	 *  @return  my minimum y-value
	 */
	public double minY() {
		return myPanel.minY();
	}

	/** Maximum x-value accessor
	 *  @return  my maximum x-value
	 */
	public double maxX() {
		return myPanel.maxX();
	}

	/** Maximum y-value accessor
	 *  @return  my maximum y-value
	 */
	public double maxY() {
		return myPanel.maxY();
	}

	/** Rounding utility method
	 *  @param number, a double
	 *  @return the int nearest to number.
	 */
	public static int round(double number) {
		return (int) (number + 0.5);
	}

	// --- PlotPanel does most of the hard work ---
	private class PlotPanel extends JPanel {
		public final static int AXIS_MARGIN = 40, // rows/columns at edge of axis
				                AXIS_GAP    = 50; // rows/columns btwn axis markings

		/** Default constructor
		 *  Postcondition: I have been initialized:
		 *                   lower-left  == (-4.0, -4.0);
		 *                   upper-right == (4.0, 4.0).
		 */
		public PlotPanel() {
			this(-4.0, -4.0, 4.0, 4.0);
		}

		/** Explicit coordinate constructor
		 *  Receive:       minX, minY, maxX, maxY, four double values.
		 *  Postcondition: I have been initialized:
		 *                   lower-left  == (minX, minY);
		 *                   upper-right == (maxX, maxY).
		 */
		public PlotPanel(double minX, double minY, double maxX, double maxY) {
			xMin = minX;
			yMin = minY;
			xMax = maxX;
			yMax = maxY;
			myXRange = xMax - xMin;
			myYRange = yMax - yMin;
			mySizeFactor = 400;

			int width, height;
			if (myXRange < myYRange) {
				width = round(mySizeFactor * myXRange / myYRange) + 2
						* AXIS_MARGIN;
				height = mySizeFactor + 2 * AXIS_MARGIN;
			} else {
				width = mySizeFactor + 2 * AXIS_MARGIN;
				height = round(mySizeFactor * myYRange / myXRange) + 2
						* AXIS_MARGIN;
			}

			setSize(width, height);
			setPreferredSize(new Dimension(width, height));
			setMaximumSize(new Dimension(width, height));
			setBackground(Color.WHITE);

			setSizeDependentAttributes();
			myFont = new Font("Serif", Font.PLAIN, 12);
		    setFont(myFont);
		    myFontMetrics = getFontMetrics(myFont);
			myFormatter.setMaximumFractionDigits(3);
			myFormatter.setMinimumFractionDigits(0);
//			myFormatter.setPositivePrefix("+");
			myPointList = new ArrayList<Point>();
			myLineList = new ArrayList<Line>();
			myOvalList = new ArrayList<Oval>();
		}

		/** Utility to initialize size-dependent attributes
		 *  Precondition: I have a height accessible via getHeight(),
		 *                 and a width accessible via getWidth().
		 *  Postcondition: My size-dependent attributes: 
		 *                   myRows, myLastRow, myColumns, myColumnsPerX,
		 *                   myRowsPerY, xInterval, and yInterval
		 *                 have been initialized.
		 */
		private void setSizeDependentAttributes() {
			myRows = getHeight() - 2 * AXIS_MARGIN; // - TITLE_ROWS;
			myLastRow = myRows - 1;
			myColumns = getWidth() - 2 * AXIS_MARGIN;
			xInterval = computeInterval(xMin, xMax);
			yInterval = computeInterval(yMin, yMax);
		}
		
		private double computeInterval(double min, double max) {
			double range = Math.abs(max - min);
			if (range < .0002) {
				return 0.00001;
			} else if (range < .002) {
				return 0.0001;
			} else if (range < .02) {
				return 0.001;
			} else if (range < .2) {
				return 0.01;
			} else if (range < 2) {
				return 0.1;
			} else if (range < 20) {
				return 1.0;
			} else if (range < 200) {
				return 10.0;
			} else if (range < 2000) {
				return 100.0;
			} else if (range < 20000){
				return 1000.0;
			} else {
				return 10000.0;
			}

		}

		/** Plot one point
		 * @param x, a double
		 * @param y, a double
		 * Postcondition: (x,y) is the last point in myPointList
		 */
		public void plotPoint(double x, double y) {
			myPointList.add(new Point(xToColumn(x), yToRow(y),
					         myPenColor));
			repaint();
		}

		public void drawLine(double x1, double y1, double x2, double y2) {
			myLineList.add( new Line(xToColumn(x1), yToRow(y1), 
					                 xToColumn(x2), yToRow(y2),
					                 myPenColor) );
			repaint();
		}
		
		public void drawOval(double xCenter, double yCenter,
				              double width, double height) {
			myOvalList.add(new Oval(xToColumn(xCenter - width/2), 
					                yToRow(yCenter + height/2),
					                (int) (width/deltaX()), 
					                (int) (height/deltaY()),
					                myPenColor) );
			repaint();
		}

		/** Map x-value to a grid column
		 *  @param x, a double
		 *  @return   the grid column corresponding to x.
		 */
		private int xToColumn(double x) {
			return AXIS_MARGIN + round((x - xMin) * myColumns / myXRange);
		}

		/** Map y-value to a grid row
		 *  @param y, a double
		 *  @return   the grid row corresponding to y.
		 */
		private int yToRow(double y) {
			return AXIS_MARGIN + myLastRow
					- round((y - yMin) * myRows / myYRange);
		}

		/** Get x-value corresponding to 1 grid column
		 *  @return  the change in x per column.
		 */
		public double deltaX() {
			return myXRange / myRows;
		}

		/** Get y-value corresponding to 1 grid row
		 *  @return  the change in y per row.
		 */
		public double deltaY() {
			return myYRange / myColumns;
		}

		/** Minimum x-value accessor
		 *  @return  my minimum x-value
		 */
		public double minX() {
			return xMin;
		}

		/** Minimum y-value accessor
		 *  @return  my minimum y-value
		 */
		public double minY() {
			return yMin;
		}

		/** Maximum x-value accessor
		 *  @return  my maximum x-value
		 */
		public double maxX() {
			return xMax;
		}

		/** Maximum y-value accessor
		 *  @return  my maximum y-value
		 */
		public double maxY() {
			return yMax;
		}

		/** Method to draw my axes and points
		 *  @param pen, a Graphics object.
		 *  Postcondition: I have been drawn, showing axes and points
		 */
		public void paintComponent(Graphics pen) {
			super.paintComponent(pen);

			int rows = getHeight() - 2 * AXIS_MARGIN, // - TITLE_ROWS,
			columns = getWidth() - 2 * AXIS_MARGIN;

			if (rows < columns)
				mySizeFactor = round(mySizeFactor * (double) rows / myRows);
			else
				mySizeFactor = round(mySizeFactor * (double) columns
						/ myColumns);

			if (myXRange < myYRange)
				setSize(round(mySizeFactor * myXRange / myYRange) + 2
						* AXIS_MARGIN, mySizeFactor + 2 * AXIS_MARGIN);
			else
				setSize(mySizeFactor + 2 * AXIS_MARGIN, round(mySizeFactor
						* myYRange / myXRange)
						+ 2 * AXIS_MARGIN);

			setSizeDependentAttributes();

			drawAxes(pen);
			plotData(pen);
		}

		private void plotData(Graphics pen) {
			// draw the currently-known points
			for (int i = 0; i < myPointList.size(); i++) {
				Point p = myPointList.get(i);
				pen.setColor( p.getColor() );
				pen.fillOval(p.getX(), p.getY(), 5, 5);
			}
			
			// draw the currently-known lines
			for (int i = 0; i < myLineList.size(); i++) {
				Line l = myLineList.get(i);
				pen.setColor( l.getColor() );
				pen.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2() );
			}
		    
	        // draw the currently-known ovals
			for (int i = 0; i < myOvalList.size(); i++) {
				Oval o = myOvalList.get(i);
				pen.setColor( o.getColor() );
				pen.drawOval( o.getX(), o.getY(), o.getWidth(), o.getHeight() );
			}
		}

		private void drawAxes(Graphics pen) {
			if (showAxes) {
				pen.setColor(Color.BLACK);
				drawXAxis(pen);
				drawYAxis(pen);
			}
		}

		private void drawYAxis(Graphics pen) {
			if (xMin >= 0 || xMax <= 0) { // origin not visible,
				drawYAxisAtLeftEdge(pen); //  plot at left edge
			} else {                    // origin visible
				drawYAxisAtOrigin(pen);    //  plot at origin
			}
		}

		private void drawYAxisAtLeftEdge(Graphics pen) {
			pen.drawLine(xToColumn(xMin), yToRow(yMin), // y-axis
					xToColumn(xMin), yToRow(yMax));
			// draw y-axis interval marks
			for (double y = yMin; y < yMax; y += yInterval) {
				pen.drawLine(xToColumn(xMin) - 5, yToRow(y),
						xToColumn(xMin) + 5, yToRow(y));
			}
			// draw mark for and label xMax
			drawYAxisLabelsAt(xMin, pen);
		}
		
		private void drawYAxisAtOrigin(Graphics pen) {
			pen.drawLine(xToColumn(0), yToRow(yMin), // y-axis
					xToColumn(0), yToRow(yMax));
			// draw y-axis interval marks
			for (double y = 0; y < yMax; y += yInterval) {
				pen.drawLine(xToColumn(0) - 5, yToRow(y),
						xToColumn(0) + 5, yToRow(y));
			}
			for (double y = 0; y > yMin; y -= yInterval) {
				pen.drawLine(xToColumn(0) - 5, yToRow(y),
						xToColumn(0) + 5, yToRow(y));
			}
			// draw mark for and label xMax
			drawYAxisLabelsAt(0, pen);
		}

		private void drawYAxisLabelsAt(double xPosition, Graphics pen) {
			pen.drawLine(xToColumn(xPosition) - 10, yToRow(yMax),
					xToColumn(xPosition) + 10, yToRow(yMax));
			String yMaxLabel = myFormatter.format(yMax);
			int labelWidth = myFontMetrics.stringWidth(yMaxLabel);
			int thirdHeight = myFontMetrics.getHeight() / 3;
			int labelXPosition = xToColumn(xPosition) - (labelWidth+15);
			pen.drawString(yMaxLabel, labelXPosition, yToRow(yMax)+ thirdHeight);
			// draw mark for and label xMin
			pen.drawLine(xToColumn(xPosition) - 10, yToRow(yMin),
					xToColumn(xPosition) + 10, yToRow(yMin));
			String yMinLabel = myFormatter.format(yMin);
			labelWidth = myFontMetrics.stringWidth(yMinLabel);
			pen.drawString(yMinLabel, labelXPosition, yToRow(yMin) + thirdHeight);
		}

		
		private void drawXAxis(Graphics pen) {
			if (yMin >= 0 || yMax <= 0) {  // origin not visible, plot at bottom edge
				drawXAxisAtBottom(pen);
			} else { // origin visible, plot at y = 0
				drawXAxisAtOrigin(pen);
			}
		}

		private void drawXAxisAtBottom(Graphics pen) {
			pen.drawLine(xToColumn(xMin), yToRow(yMin),
					     xToColumn(xMax), yToRow(yMin));
			// draw x-axis interval marks
			for (double x = xMin; x < xMax; x += xInterval) {
				pen.drawLine(xToColumn(x), yToRow(yMin) + 5,
						xToColumn(x), yToRow(yMin) - 5);
			}
			drawXLabelsAt(yMin, pen);
		}

		private void drawXLabelsAt(double yPosition, Graphics pen) {
			// draw mark for and label xMax
			pen.drawLine(xToColumn(xMax), yToRow(yPosition) + 10,
					xToColumn(xMax), yToRow(yPosition) - 10);
			String xMaxLabel = myFormatter.format(xMax);
			int labelWidth = myFontMetrics.stringWidth(xMaxLabel);
			int halfWidth = labelWidth / 2;
			int labelYPosition = yToRow(yPosition) + 25;
			pen.drawString(xMaxLabel, xToColumn(xMax) - halfWidth, labelYPosition);
			// draw mark for and label xMin
			pen.drawLine(xToColumn(xMin), yToRow(yPosition) + 10,
					xToColumn(xMin), yToRow(yPosition) - 10);
			String xMinLabel = myFormatter.format(xMin);
			labelWidth = myFontMetrics.stringWidth(xMinLabel);
			halfWidth = labelWidth / 2;
			pen.drawString(xMinLabel, xToColumn(xMin) - halfWidth, labelYPosition);
		}
		
		private void drawXAxisAtOrigin(Graphics pen) {
			pen.drawLine(xToColumn(xMin), yToRow(0),
					xToColumn(xMax), yToRow(0));
			// draw positive x-axis interval marks
			for (double x = 0; x < xMax; x += xInterval) {
				pen.drawLine(xToColumn(x), yToRow(0) + 5,
						xToColumn(x), yToRow(0) - 5);
			}
			// draw negative  x-axis interval marks
			for (double x = 0; x > xMin; x -= xInterval) {
				pen.drawLine(xToColumn(x), yToRow(0) + 5,
						xToColumn(x), yToRow(0) - 5);
			}
			drawXLabelsAt(0, pen);
			
		}

		/** Method to mutate my pen/drawing color
		 *  @param newColor, a Color value
		 *  Postcondition: myPenColor = newColor
		 */
		public void setPenColor(Color newColor) {
			myPenColor = newColor;
		}

		/** Accessor to retrieve my current pen/drawing color
		 *  @return myPenColor
		 */
		public Color getPenColor() {
			return myPenColor;
		}

		public void hideAxes() {
			showAxes = false;
			repaint();
		}

		public void showAxes() {
			showAxes = true;
			repaint();
		}

		// --- Attribute variables, class PlotPanel
		private double            xMin, yMin, // minimum axis values 
				                  xMax, yMax, // maximum axis values 
				                  xInterval, yInterval, // x/y-values btwn axis markings
				                  myXRange, myYRange; // total range of x/y values
		private int               myRows, myColumns, // number of rows/columns in graph 
				                  myLastRow, // # of last row 
				                  mySizeFactor; // factor for calc-ing "size" of graph
		private boolean           showAxes = true; // flag for showing/hiding axes
		private Color             myPenColor = Color.black; // drawing color
		private DecimalFormat     myFormatter = new DecimalFormat(); // formatter for axis labels
		private Font              myFont = null;
		private FontMetrics       myFontMetrics = null;
		private ArrayList<Point>  myPointList = null; // points to draw
		private ArrayList<Line>   myLineList = null;
		private ArrayList<Oval>   myOvalList = null;
		private static final long serialVersionUID = 80L; // provided to elim. a warning
		
		private class Point {
			public Point(int x, int y, Color newColor) {
				myX = x; myY = y;
				myColor = newColor;
			}
			
			public int getX() { return myX; }
			public int getY() { return myY; }
			
			public Color getColor() { return myColor; }
			
			private int myX, myY;
			private Color myColor;
			
		}
		private class Line {
			public Line(int x1, int y1, int x2, int y2, Color newColor) {
				myX1 = x1; myY1 = y1; myX2 = x2; myY2 = y2;
				myColor = newColor;
			}
			
			public int getX1() { return myX1; }
			public int getY1() { return myY1; }
			public int getX2() { return myX2; }
			public int getY2() { return myY2; }
			
			public Color getColor() { return myColor; }

			private int myX1, myY1, myX2, myY2;
			private Color myColor;
		}
	}
	
	public class Oval {
		public Oval(int centerX, int centerY, int width, int height, Color color) {
			myX = centerX; myY = centerY;
			myWidth = width; myHeight = height;
			myColor = color;
		}
		public int getX() { return myX; }
		public int getY() { return myY; }
		public int getWidth() { return myWidth; }
		public int getHeight() { return myHeight; }
		public Color getColor() { return myColor; }
		
		private int myX, myY, myWidth, myHeight;
		private Color myColor;
	}

	// --- attribute variables, class PointPlotter
	private PlotPanel         myPanel = null; // the panel where I plot points
	private static final long serialVersionUID = 81L; // provided to elim. a warning
}
