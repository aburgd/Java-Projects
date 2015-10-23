import java.util.Scanner;

public class MonthAbbrev {
	public static void main (String[] args)	{
		
		// Scanner dec
		Scanner keyboard = new Scanner(System.in);
        
        // Ask user
        System.out.print("To see the first three letters of a month,");
        System.out.println(" enter a month number (1-12): ");
        int number = keyboard.nextInt();
        
        // Months as single string
        final String MONTH_TABLE = "JanFebMarAprMayJunJulAugSepOctNovDec";
        
        // Compute start, stop, and abbrev
        int start = (number - 1) * 3;
        int stop = start + 3;
        String abbrev = MONTH_TABLE.substring(start,stop);
        
        // Print final statement
        System.out.println("\nMonth #" + number + " begins with '" + abbrev + "'.");
		
	}
}
