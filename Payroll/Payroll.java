import java.util.Scanner;

public class Payroll {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Employee Name: ");
		Scanner scanner = new Scanner(System.in);
		String employee = scanner.nextLine();
		System.out.print("Hours worked: ");
		double hours = keyboard.nextDouble();
		System.out.print("Hourly wage: ");
		double wage = keyboard.nextDouble();
		
		double earnings = hours * wage;
		
		System.out.printf(employee + " worked " + hours + ", earning $%.2f this week." , earnings);
	}

}
