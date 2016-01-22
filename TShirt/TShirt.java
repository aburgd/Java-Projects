
public class TShirt {
	public TShirt(String size, String color) {
		mySize = size;
		myColor = color;
		
		switch ( size.charAt(0) ) {
		case 'S': case 'M': case 'L':
			myPrice = 10.00;
			break;
		case 'X':
			switch ( size.charAt(1) ) {
			case 'S':
				myPrice = 9.00;
				break;
			case 'L':
				myPrice = 11.00;
				break;
			default:
				System.err.println("TShirt(size): size \"" + size + "\" is invalid");
				System.exit(1);
			}
			break;
			default:
				System.err.println("TShirt(size): size \"" + size + "\" is invalid");
				System.exit(1);
		}

	}
	
	public String getSize() { return mySize; }
	public double getPrice() { return myPrice; }
	public String getColor() { return myColor; }
	
	public String toString() { return mySize + " ($" + myPrice + ")"; }
	
	private String mySize;
	private double myPrice;
	private String myColor;
}
