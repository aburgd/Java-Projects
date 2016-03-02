import java.util.*;

public class MonthTester {
	private static Scanner kbd;

	public static void main(String[] args) {
		System.out.println("Welcome to month name game!");
		System.out.print("\nI will give you a month number;");
		System.out.println(" you should enter its name.");
		kbd = new Scanner(System.in);
		Random gen = new Random();
		
		char ans;
		do {
			int monthNumber = gen.nextInt(12) + 1;
			System.out.print("\nWhat is the name of month #" + monthNumber + "?\n");
			String resp = kbd.next();
			Month m = new Month(monthNumber);
			if ( m.getName().equals(resp) ) {
				System.out.println("Correct!");
			} else {
				System.out.println("Sorry, month #" + monthNumber + " is " + m);
			}
			
			System.out.println("\nDo you want to try another? y/n ");
			ans = kbd.next().charAt(0);
		} while ( ans == 'y' || ans == 'Y' );
	}
}
