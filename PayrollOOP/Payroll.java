import java.util.Scanner;
import java.io.*;

public class Payroll {
	public void run() {
		Scanner fin = null;
		try {
			System.out.println("Where is payrollData.txt?");
			Scanner kbd = new Scanner(System.in);
			fin = new Scanner( new File("payrollData.txt") );
			Employee employee = null;
			while ( fin.hasNext() ) {
				String employeeKind = fin.next() + "Employee";
				employee = Class.forName(employeeKind).asSubclass(Employee.class).newInstance();
				employee.read(fin);
				System.out.printf("%20s: $%7.2f%n", employee.getName(), employee.getPay() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fin.close();
		}
	}
	
	public static void main(String[] args) {
		Payroll self = new Payroll();
		self.run();
	}
}
