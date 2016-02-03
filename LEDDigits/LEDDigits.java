import java.util.Scanner;

public class LEDDigits {
	
	private static Scanner kbd;

	public static void main(String[] args) {
		kbd = new Scanner(System.in);
		String horiz = " --";
		String dblVert = "|  |";
		String lVert = "|   ";
		String rVert = "   |";
		
		boolean done = false;
		final int LED_MIN = 0;
		
		while(!done) {
			System.out.println("Enter a number, 0-9, or -1 to quit: ");
			int num = kbd.nextInt();
			if (num < LED_MIN) {
				done = true;
				System.out.println("Error: Invalid argument received");
				System.exit(1);
			} else {
				switch (num) {
				case 0:
					System.out.println(horiz);
					System.out.println(dblVert);
					System.out.println(dblVert);
					System.out.println(horiz);
					break;
				case 1:
					System.out.println(lVert);
					System.out.println(lVert);
					System.out.println(lVert);
					System.out.println(lVert);
					break;
				case 2:
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(horiz);
					System.out.println(lVert);
					System.out.println(horiz);
					break;
				case 3:
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(horiz);
					break;
				case 4:
					System.out.println(dblVert);
					System.out.println(horiz);
					System.out.println(rVert);
					break;
				case 5:
					System.out.println(horiz);
					System.out.println(lVert);
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(horiz);
					break;
				case 6:
					System.out.println(horiz);
					System.out.println(lVert);
					System.out.println(horiz);
					System.out.println(dblVert);
					System.out.println(horiz);
					break;
				case 7:
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(rVert);
					System.out.println(rVert);
					break;
				case 8:
					System.out.println(horiz);
					System.out.println(dblVert);
					System.out.println(horiz);
					System.out.println(dblVert);
					System.out.println(horiz);
					break;
				case 9:
					System.out.println(horiz);
					System.out.println(dblVert);
					System.out.println(horiz);
					System.out.println(rVert);
					System.out.println(horiz);
					break;
				}
			}
		}
	}
}
