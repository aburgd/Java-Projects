import java.util.Scanner;

public class BalloonPrank {
	public static void main(String[] args) {

		final double LENGTH = 9.0;
		final double WIDTH = 8.0;
		final double HEIGHT = 7.0;

		System.out.print("Enter a balloon radius in inches: ");
		Scanner kbd = new Scanner(System.in);
		double bRad = kbd.nextDouble();
		 bRad /= 12; // to feet
		
		double bVol = Sphere.volume(bRad);
		double rVol = Box.volume(LENGTH, WIDTH, HEIGHT);

		double bReq = rVol / bVol;
		System.out.printf("Using balloons with radii of %.0f inches, you will need %.0f balloons.\n", bRad*12, bReq);

	}
}
