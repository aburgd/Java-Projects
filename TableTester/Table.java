public class Table {
	public Table(int rows, int columns) {
		if ( rows < 1 || columns < 1) {
			throw new IllegalArgumentException("Table(): bad args");
		}
		myTable = new double[rows][columns];
		myRows = rows;
		myColumns = columns;
	}
	
	public int getRows() { return myRows; }
	public int getCols() { return myColumns; }
	
	public double get(int row, int col) {
		return myTable[row][col];
	}
	
	public void set(int row, int col, double item) {
		myTable [row][col] = item;
	}
	
	public String toString () {
		String result = "";
		for (int r = 0; r < myTable.length; r++) {
			for (int c = 0; c < myTable[r].length; c++) {
				result += (myTable[r][c] + "\t");
			}
		}
		return result;
	}
	
	private int myRows, myColumns;
	private double [][] myTable = null;
}
