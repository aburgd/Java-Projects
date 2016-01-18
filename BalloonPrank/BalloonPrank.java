import java.util.Scanner;

public class balloonPrank {
	private static Scanner kbd;

	public static void main(String[] args) {

		double length;
		double width;
		double height;
		double bRad;

		System.out.print("Enter a balloon radius in inches: ");
		kbd = new Scanner(System.in);
		bRad = kbd.nextDouble();
		 bRad /= 12; // to feet
		
		System.out.print("Enter a length in feet: ");
		length = kbd.nextDouble();
		
		System.out.print ("Enter a width in feet: ");
		width = kbd.nextDouble();
		
		System.out.print("Enter a height in feet: ");
		height = kbd.nextDouble();
		
		double bVol = Sphere.volume(bRad);
		double rVol = Box.volume(length, width, height);

		double bReq = rVol / bVol;
		System.out.printf("Using balloons with radii of %.0f inches, you will need %.0f balloons.\n", bRad*12, bReq);

	}
}
