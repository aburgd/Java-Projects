import java.util.Scanner;
import java.io.*;

public class FilePayroll {
	public static void main(String[] args) {
		Scanner fin = FileOps.promptForFileIn("Enter path to employees.txt: ");
		PrintWriter fout = FileOps.promptForFileOut("Save as: ");
	
		while ( fin.hasNextLine() ) {
			String firstName = fin.next();
			String lastName = fin.next();
			double hours = fin.nextInt();
			double wage = fin.nextDouble();
			double earnings = 0;
			
			if ( hours < 40 ) {
				earnings = hours * wage;
			} else {
				double hoursOver = hours - 40.0;
				earnings = (wage * 40.0) + ((1.5 * wage) * hoursOver);
			}
	
			fout.printf("%s\t%s\t%.2f%n", firstName, lastName, earnings);
		
		}
		
		System.out.println("Processing complete.");
		fout.close();
		fin.close();
		
	}
}
