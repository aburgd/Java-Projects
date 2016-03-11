import java.io.*;
import java.util.*;

public class Friends {
	public Friends(String fileName) {
		myFriends = new ArrayList<Friend>();
		Scanner fin = null;
		try {
			fin = new Scanner( new File(fileName) );
			while ( fin.hasNext() ) {
				Friend friend = new Friend();
				friend.read(fin);
				myFriends.add(friend);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			fin.close();
		}
	}
	
	public ArrayList<Friend> getFriendList() { return myFriends; } 
	
	private ArrayList<Friend> myFriends = null;
}
