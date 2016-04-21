import java.util.Scanner;

public class HourlyEmployee extends Employee{
	public HourlyEmployee() {
		super();
		myHours = myRate = 0.0;
	}
	
	public HourlyEmployee(String name, int id, double hours, double rate) {
		super(name,id);
		myHours = hours;
		myRate = rate;
	}
	
	public double getHours() { return myHours; }
	public double getRate() { return myRate; }
	
	public String toString() { return super.toString() + "\t" + myRate + "\t" + myHours; }
	
	public void read(Scanner in) {
		super.read(in);
		myRate = in.nextDouble();
		myHours = in.nextDouble();
	}
	
	public double getPay() {
		final double OVERTIME_BONUS = 0.5;
		double pay = myHours * myRate;
		if (myHours > 40) {
			double overtimeHours = myHours - 40;
			pay += overtimeHours * myRate * OVERTIME_BONUS;
		}
		return pay;
	}
	
	private double myHours;
	private double myRate;
} 
