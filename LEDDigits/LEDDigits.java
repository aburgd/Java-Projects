import java.util.Scanner;

public class LEDDigits {
	private static Scanner kbd;

	public static void main(String[] args) {
		kbd = new Scanner(System.in);
		String horiz = "---";
		String dblVer = "|   |";
		String lVert = "|   ";
		String rVert = "   |";

		System.out.println("Enter a number, 0-9: ");
		int num = kbd.nextInt();
		boolean done = false;
		final int LED_MIN = 0;
	}
}
