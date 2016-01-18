// Only use Random for example purposes!
// Use SecureRandom for production!
// Actually, this entire thing is for example purposes
// You've been warned

import java.util.Random;
import java.util.Scanner;

public class DHKE {

	public static Scanner kbd;
	public static Random rng;

	public static void main( String[] args ) {

		kbd = new Scanner( System.in );
		rng = new Random();

		System.out.print( "Are you computing the public key or the shared secret? \n" );
		
		String answer = kbd.nextLine();
		
		// ask user what they want to compute
		if ( answer.toLowerCase().contains("public") ) {
			double g = 0;
			double p = 0;
			double a = 0;
				
			double publick = DHKE.A(g, p, a);
			System.out.print( "Send this to your contact: " + publick + "\n" );
		}
		
		else if ( answer.toLowerCase().contains("shared") ) {
			//double g = 0;
			double p = 0;
			double B = 0;
			double a = 0;
			
			double shared = DHKE.s(p, B, a);
			System.out.print ("Compare this with your contact: " + shared + "\n" );
		}

		else {
			System.out.print( "Have a nice day!\n" );
		}	
	}
	
	// public key method
	public static double A( double g, double p, double a ) {
		System.out.print( "Your base number (g) is: \n" );
		g = rng.nextInt(1031);
		System.out.print(g + "\n");

		System.out.print( "Enter your shared modulo prime (p): \n" );
		p = kbd.nextFloat();

		System.out.print( "Enter your secret prime (a): \n" );
		a = kbd.nextFloat();
		
		// public key calculation
		return ( Math.pow(g, a) % p );
	}
	
	// shared secret method
	public static double s( double p, double B, double a ) {
		System.out.print( "Enter your shared modulo prime (p): \n" );
		p = kbd.nextFloat();

		System.out.print( "Enter the public key your contact gave you (B): \n" );
		B = kbd.nextFloat();

		System.out.print( "Enter your secret prime (a): \n" );
		a = kbd.nextFloat();

		// shared secret calculation
		return ( Math.pow(B, a) % p );
	}
}
