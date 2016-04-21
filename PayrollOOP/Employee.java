import java.util.Scanner;

abstract public class Employee {
	public Employee() {
		myName = "";
		myID = 0;
	}
	public Employee(String name, int id) {
		myName = name;
		myID = id;
	}
	
	public String getName() { return myName; }
	public int getID() { return myID; }
	public String toString() { return myName +"\t" + myID; }
	
	abstract double getPay();
	
	public void read(Scanner in) {
		myName = in.next();
		myID = in.nextInt();
	}
	
	private String myName = null;
	private int myID;
}
