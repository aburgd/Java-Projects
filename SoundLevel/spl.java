import java.util.Scanner;

public class SoundPressure {
	public static void main(String[] args) {
	
		System.out.println("To find the SPL of a sound at a distance: ");
		
		Scanner kbd = new Scanner(System.in);

		System.out.print("- What is the reference loudness in decibels?");
		int loud1 = kbd.nextInt();
		
		System.out.print("- What is the reference distance in meters?");
		double dist1 = kbd.nextDouble();

		System.out.print("- What is the new distance in meters?");
		double dist2 = kbd.nextDouble();

		long loud2 = newSPL(loud1, dist1, dist2);

		System.out.println("\nThe SPL of the sound at distance " + dist2 + "m is" + loud2 + "dB.");
	}

	public static long newSPL(int spl1, double dist1, double dist2) {
	
	return spl1 - Math.round(20.0 * Math.log10(dist2/dist1) );	

	}
}	
