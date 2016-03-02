public class Month {
	public Month(int monthNumber) {
		if (monthNumber < 1 || monthNumber > 12) {
			throw new IllegalArgumentException("Month(): bad month number");
		}
		myNumber = monthNumber;
		myName = MONTHS[monthNumber-1];
	}
	
	public int getNumber() { return myNumber; }
	public String getName() { return myName; }
	public String toString() { return myName; }
	
	private static final String [] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private String myName;
	private int myNumber;
}
