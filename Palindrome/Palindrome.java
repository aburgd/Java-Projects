import java.util.Scanner;
import java.util.Collections;

public class Palindrome {
	Scanner kbd = new Scanner(System.in);
	private static Scanner scanner;
	
	public static String reverseString(String str) {
		String revStr = new StringBuilder(str).reverse().toString();
		return revStr;
	}
	
	public static boolean checkStr(String str, String revStr) {
		if ( str.equals(revStr) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("User input (u) or file input (f)? ");
		scanner = new Scanner(System.in);
		char ans = scanner.nextLine().charAt(0);
		
		switch (ans) {
		case 'u': case 'U':
			System.out.println("Enter string to check: ");
			String str = scanner.next().toLowerCase();
			String rev = Palindrome.reverseString(str);
			boolean check = checkStr(str, rev);
			System.out.println( check );
			break;
			
		case 'f': case 'F':
			Scanner in = FileOps.promptForFileIn("Enter path to file to check: ");
			
			if ( in.hasNext() ) {
				str = in.nextLine().toLowerCase();
				rev = reverseString(str);
				check = checkStr(str, rev);
				System.out.println( check );
				in.close();
			} else {
				System.err.print("Palindrome(): bad argument");
			}
			
			break;
			
		}
	}
}
