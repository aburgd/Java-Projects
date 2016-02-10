package pH;

import java.util.Scanner;
import java.io.*;

public class PhFileLabeler {

	public static void main(String[] args) {
		try {
			System.out.print("Enter name of the input file: ");
			Scanner kbd = new Scanner(System.in);
			String inFileName = kbd.nextLine();
			File inFile = new File(inFileName);
			Scanner fin = new Scanner(inFile);
			
			System.out.print("Enter name of the output file: ");
			String outFileName = kbd.nextLine();
			File outFile = new File(outFileName);
			PrintWriter fout = new PrintWriter(outFile);
			
			while ( fin.hasNextDouble() ) {
				double phValue = fin.nextDouble();
				PH pH = new PH(phValue);
				fout.println(phValue + " --> " + pH.label() );
			}
			
			fin.close();
			fout.close();
			System.out.print("Done. See '" + outFileName + "'.");	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
