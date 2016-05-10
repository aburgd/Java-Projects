import java.security.SecureRandom;
import java.util.Scanner;

public class DHKE {
	
	// Keyboard set up
	public static Scanner kbd;
	
	// Setting up the RNG
	final static byte[] dummy = new byte[512];
	public static SecureRandom srng = new SecureRandom();
	
	public static void main(String[] args) {
		kbd = new Scanner(System.in);
		// Seeding the RNG
		srng.nextBytes(dummy);
		
		// Ask user for input: public key, or shared secret
		System.out.println("Do you want to compute a public key," +
		" or a shared secret? ");
		String answer = kbd.nextLine();

		if ( answer.toLowerCase().contains("public") ) {		 			// Checks if the user wants the public key...
			int baseG = Math.abs( srng.nextInt() );
			System.out.print("Your base number g is: \n" + baseG + "\n");
			
			int modP = Math.abs( srng.nextInt() );
			System.out.print("Your modulo prime p is: \n" + modP + "\n");
			
			System.out.print("Please enter your secret integer a: \n");
			int secretA = kbd.nextInt();
			
			int publicA = DHKE.publicKey(baseG, modP, secretA);
			System.out.print("Send this to your contact: " + publicA + "\n");
			
		} else if ( answer.toLowerCase().contains("shared") ) { 			// or the shared secret.
			System.out.print("Please enter your shared modulo prime p: \n");
			int modP = kbd.nextInt();
			
			System.out.print("Please enter the public key your contact sent: \n");
			int baseG = kbd.nextInt();
			
			System.out.print("Please enter your secret integer a: \n");
			int secretA = kbd.nextInt();
			
			int sharedSecret = DHKE.sharedSecret(modP, baseG, secretA);
			System.out.print("Compare this to your contact's: " + sharedSecret + "\n");
		} else {
			System.out.print("Have a nice day!");
		}
	}
	
	// Finds the public key in accordance with the Diffie-Hellman Key Exchange algorithm
	public static int publicKey(int baseG, int modP, int secretA) {
		return (int) (Math.pow(baseG, secretA) % modP);
	}
	
	// Computes the shared secret in accordance with the Diffie-Hellman Key Exchange algorithm
	public static int sharedSecret(int modP, int publicB, int secretA) {
		return (int) (Math.pow(publicB, secretA) % modP);
	}
}
