import java.security.SecureRandom;
import java.util.Scanner;

public class DHKE {
	// Keyboard and random number generator
	public static Scanner kbd;
	public static SecureRandom srng;
	
	public static void main(String[] args) {
		kbd = new Scanner(System.in);
		
		System.out.println("Do you want to compute a public key," +
		" or a shared secret? ");
		String answer = kbd.nextLine();

		if ( answer.toLowerCase().contains("public") ) {		 			// Checks if the user wants the public key...
			int g = 0;
			System.out.print("Your base number g is: \n" + g);
			g = srng.nextInt();
			
			int p = 0;
			System.out.print("Your modulo prime p is: \n" + p);
			p = srng.nextInt();
			
			System.out.print("Please enter your secret prime a: \n");
			int a = kbd.nextInt();
			
			int key = DHKE.publicKey(g, p, a);
			System.out.print("Send this to your contact: " + key + "\n");
			
		} else if ( answer.toLowerCase().contains("shared") ) { 			// or the shared secret.
			System.out.print("Please enter your shared modulo prime p: \n");
			int p = kbd.nextInt();
			
			System.out.print("Please enter the public key your contact sent: \n");
			int b = kbd.nextInt();
			
			System.out.print("Please enter your secret prime a: \n");
			int a = kbd.nextInt();
			
			int secret = DHKE.sharedSecret(p, b, a);
			System.out.print("Compare this to your contact's: " + secret + "\n");
		} else {
			System.out.print("Have a nice day!");
		}
	}
	
	// Finds the public key in accordance with the Diffie-Hellman Key Exchange algorithm
	public static int publicKey(int g, int p, int a) {
		return (int) (Math.pow(g, a) % p);
	}
	
	// Computes the shared secret in accordance with the Diffie-Hellman Key Exchange algorithm
	public static int sharedSecret(int p, int b, int a) {
		
		
		return (int) (Math.pow(b, a ) % p);
	}
}
