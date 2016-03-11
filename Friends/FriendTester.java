import java.util.*;
import java.io.*;

public class FriendTester {
	private static Scanner kbd;
	public static void main(String[] args) {
		Friends myFriends = new Friends("friends.txt");
		ArrayList<Friend> friendsList = new ArrayList<Friend>();
		
		friendsList = myFriends.getFriendList();
		
		System.out.println("Welcome to friends directory.");
		System.out.print("\nYou give me a friend's name, ");
		System.out.println(" and I'll give you their information.");
		
		kbd = new Scanner(System.in);
		
		boolean cont = true;
		do { 
			System.out.print("\nEnter a friend's name (first and last): ");
			String firstName = kbd.next();
			if (firstName.equals("quit")) {
				cont = false;
			} else {
				String name = firstName  + " " + kbd.next();
				boolean found = false;
				for (int i = 0; i < friendsList.size() && cont; i++) {
					if (friendsList.get(i).getName().equals(name)) {
						found = true;
						System.out.println("Phone number: " + friendsList.get(i).getPhone() );
						System.out.println("Email: " + friendsList.get(i).getEmail() );
					}
				}
				
				if (!found) {
					System.out.println("Sorry, " + name + " is not found.");
				}
			}
		} while ( cont );
		
		String name = kbd.next() + " " + kbd.next();
	}

}
