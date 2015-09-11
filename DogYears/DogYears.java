import java.util.Scanner;

public class DogYears {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How old are you? ");
		int ageh = keyboard.nextInt();
		int aged = ageh * 7;
		System.out.printf("In dog years you are " + aged);
	}

}
