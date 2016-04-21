import java.util.Scanner;

public class Piecework extends Employee {
	public Piecework() {
		super();
		myItems = 0; 
		myRate = 0.0;
	}
	
	public Piecework(String name, int id, int items, double rate) {
		super(name,id);
		myItems = items;
		myRate = rate;
	}
	
	public double getItems() { return myItems; }
	public double getRate() { return myRate; }
	
	public String toString() { return super.toString() + "\t" + myRate + "\t" + myItems; }
	
	public void read(Scanner in) {
		super.read(in);
		myRate = in.nextDouble();
		myItems = in.nextDouble();
	}
	
	public double getPay() {
		double pay = myItems * myRate;
		return pay;
	}
	
	private double myItems;
	private double myRate;
}

