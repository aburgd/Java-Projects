import java.util.Scanner;

public class PhLabeler {
	public static void main (String[] args) {
		Scanner kbd = new Scanner(System.in);

		boolean done = false;
		while (!done) {
			System.out.print("Enter a pH value, or -1 to quit: ");
			double phValue = kbd.nextDouble();
			if (phValue < PH.MIN) {
				done = true;
			} else {
				PH pH = new PH(phValue);
				System.out.println(" --> " + pH.label());
			}
		}
	}
}
