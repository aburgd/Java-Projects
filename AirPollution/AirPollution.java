import java.util.Scanner;

public class AirPollution {

	private static Scanner kbd;

	public static void main(String[] args) {
		final int NUM_READINGS = 5;
		double sum = 0.0;
		kbd = new Scanner(System.in);
		System.out.println("To compute the air pollution index...");
		for (int count = 1; count <= NUM_READINGS; count++) {
			System.out.print("Enter reading #" + count + " of "  + NUM_READINGS + ": ");
			double reading = kbd.nextDouble();
			sum += reading;
		}
		double pollAvg = sum / NUM_READINGS;
		System.out.printf("The average is %.3f", pollAvg);

	}

}
