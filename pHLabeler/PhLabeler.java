package pH;
import java.util.Scanner;

public class PHLabeler {

	private static Scanner kbd;

	public static void main(String[] args) {
	
		boolean done = false;
		int count = 0;
		double sum = 0;
		double avg = 0;
		while (!done) {
			System.out.print("Enter a pH value, or -1 to quit: ");
			kbd = new Scanner(System.in);
			double phValue = kbd.nextDouble();
			if (phValue < PH.STRONG_AC_MIN) {
				done = true;
			} else {
				count++;
				sum += phValue;
				PH pH = new PH(phValue);
				System.out.println(" --> " + pH.toString() );
			}
			if ( count > 0 ) {
				avg = sum / count;
				PH avgPH = new PH(avg);
				System.out.println("Average pH of lake is: " + avgPH + ", " + avgPH.toString() );
			}
		}
	
	}
