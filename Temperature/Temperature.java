import java.util.Scanner;

public class Temperature {
	public static final double ABS_ZERO_FAHR = -459.67;
	public static final double ABS_ZERO_CELS = -273.15;
	
	public Temperature() {
		myMag = ABS_ZERO_CELS;
		myScale = 'C';
	}
	
	public Temperature(double mag, char scale) {
		checkAndSet(mag, scale);
	}
	
	private void checkAndSet(double mag, char scale) {
		if ( isValid(mag, scale) ) {
			myMag = mag;
			myScale = scale;
		} else {
			throw new IllegalArgumentException("checkAndSet(): bad args");
		}
	}
	
	public static boolean isValid(double mag, char scale) {
		switch (scale) {
		case 'f': case 'F':
			return mag >= ABS_ZERO_FAHR;
		case 'c': case 'C':
			return mag >= ABS_ZERO_CELS;
		default:
			return false;
		}
	}
	
	public char getScale() { return myScale; }
	public double getMag () { return myMag; }
	public String toString() { return myMag + " " + myScale; }
	
	public void read(Scanner scanner) {
		double mag = scanner.nextDouble();
		char scale = scanner.next().charAt(0);
		checkAndSet(mag, scale);
	}
	
	public static double fahrToCels(double fahrTemp) {
		return(fahrTemp - 32.0) / 1.8;
	}
	
	public Temperature inCelsius() {
		Temperature result = null;
		switch (myScale) {
		case 'F': case 'f':
			result = new Temperature(fahrToCels(myMag), 'C');
			break;
		case 'C': case 'c':
			result = new Temperature(myMag, 'C');
			break;
		default:
			throw new IllegalArgumentException("inCelsius(): bad scale");
		}
		return result;
	}
	
	private double myMag;
	private char myScale;
}
