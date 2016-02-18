import java.util.Scanner;

public class AvgMonthlyTemperature {
	public static void main(String[] args) {
		System.out.println("To average a month's temperatures,");
		Scanner fin = FileOps.promptForFileIn("enter input file name: ");
		
		Temperature temp = new Temperature();
		double sum = 0.0;
		int count = 0;
		while ( fin.hasNext() ) {
			temp.read(fin);
			sum += temp.inCelsius().getMag();
			count++;
		}
		fin.close();
		if (count > 0) {
			System.out.println("The average temperature is " + new Temperature(sum/count, 'C') );
		} else {
			System.err.println("No values in input file!");
		}
	}
}
