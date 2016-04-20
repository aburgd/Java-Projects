public class TShirt {
	public TShirt(String size) {
		if( !(size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") ) ) {
			throw new IllegalArgumentException("TShirt(): bad size: " + size);
		}
		mySize = size;
	}
	public String getSize() { return mySize; }
	public double getPrice() { return 10.00; }
	public String toString() { return mySize + "TShirt"; }
	
	private String mySize;
}
