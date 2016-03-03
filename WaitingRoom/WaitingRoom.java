import java.util.*;
import java.io.*;

public class WaitingRoom {
	public static void main(String[] args) {
		WaitingRoom self = new WaitingRoom("today.txt");
		self.run();
	}
	
	public WaitingRoom(String fileName) {
		readApptList(fileName);
		myWaitList = new LinkedList<String>();
	}
	
	private void readApptList(String fileName) {
		myApptList = new LinkedList<String>();
		Scanner fin = null;
		try {
			fin = new Scanner(new File(fileName));
			while (fin.hasNextLine()) {
				String pat = fin.nextLine();
				myApptList.add(pat);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			fin.close();
		}
		
	}
	
	public void run() {
		while ( !myApptList.isEmpty() || !myWaitList.isEmpty()) {
			processArrival();
		}
	}
	
	private void processArrival() {
		System.out.println("\nWelcome to Dr. Suture's office!");
		System.out.print("Enter your name: ");
		String name = kbd.nextLine();
		if ( name.equals("99") && !myWaitList.isEmpty() ) {
			myWaitList.removeFirst();
		} else if ( myApptList.remove(name) ) {
			myWaitList.add(name);
			System.out.println("Thank you. Please take a seat.");
		} else {
			System.out.println("Today's appointments: " + myApptList);
		}
	}
	
	private LinkedList<String> myWaitList = null;
	private LinkedList<String> myApptList = null;
	private Scanner kbd = new Scanner(System.in);
}
