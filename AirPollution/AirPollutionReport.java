import java.util.Scanner;

public class AirPollutionReport {
	public static void main(String[] args) {
		final int NUM_READINGS = 5;
		double [] readings = new double[NUM_READINGS];
		readReadingsInto(readings);
		System.out.printf(" \nThe average is %.3f%n", avg(readings) );
		print(readings);
	}
	
	private static void readReadingsInto(double [] array) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("To compute the pollution index, ");
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter reading #" + (i+1) + "/" + array.length + ": ");
			array[i] = kbd.nextDouble();
		}
	}
		
	public static double avg(double [] array) {
		if (array.length < 1) {
			throw new IllegalArgumentException("average(): array is empty");
		}
		double sum = 0.0;
		for (double item : array) {
			sum += item;
		}
		return sum/array.length;
		}
		
	public static void print(double [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Reading #" + (i+1) + ": " + array[i]);
		}
	}
}
