package pH;
import java.util.Scanner;

public class PHLabeler {

	private static Scanner kbd;

	public static void main(String[] args) {
	
		boolean done = false;
		while (!done) {
			System.out.print("Enter a pH value, or -1 to quit: ");
			kbd = new Scanner(System.in);
			double phValue = kbd.nextDouble();
			if (phValue < PH.STRONG_AC_MIN) {
				done = true;
			} else {
				PH pH = new PH(phValue);
				System.out.println(" --> " + pH.toString() );
			}
		}
	
	}

}
