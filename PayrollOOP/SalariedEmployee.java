import java.util.Scanner;

public class SalariedEmployee extends Employee {
	public SalariedEmployee() {
		super();
		mySalary = 0.0;
	}
	
	public SalariedEmployee(String name, int id, double salary) {
		super(name, id);
		mySalary = salary;
	}
	
	public double getSalary() { return mySalary; }
	
	public String toString() { return super.toString() + "\t" + mySalary; }
	
	public void read(Scanner in) {
		super.read(in);
		mySalary = in.nextDouble();
	}
	
	public double getPay() { return mySalary; }
	
	private double mySalary;
}
