import java.util.Scanner;
import java.io.*;

public class FileOps {
	public static Scanner kbd = new Scanner(System.in);

	public static File promptForFile(String prompt) {
		System.out.print(prompt);
		String fileName = kbd.next();
		return new File(fileName);
	}

	public static Scanner promptForFileIn(String prompt) {
		Scanner result = null;
		boolean done = false;
		do {
			try {
				File inFile = promptForFile(prompt);
				result = new Scanner(inFile);
				done = true;
			} catch (FileNotFoundException fnfe) {
				quitOrTryAgain("Unable to open input file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!done);
		
		return result;
	}

	private static void quitOrTryAgain(String errorMessage) {
		System.out.println(errorMessage);
		System.out.println("Do you want to quit (q) or try again (a)? ");
		char answer = kbd.next().charAt(0);
		if (answer == 'q' || answer == 'Q') {
			System.exit(1);
		}
	}

	public static PrintWriter promptForFileOut(String prompt) {
		PrintWriter result = null;
		boolean done = false;
		do {
			try {
				File outFile = promptForFile(prompt);
				result = new PrintWriter(outFile);
				done = true;
			} catch (FileNotFoundException fnfe) {
				quitOrTryAgain("Unable to open output file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!done);

		return result;
	}
}
