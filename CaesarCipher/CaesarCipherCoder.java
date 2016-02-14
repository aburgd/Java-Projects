import java.util.Scanner;
import java.io.*;

public class CaesarCipherCoder {
	public char encodeChar(char ch, int shiftAmount) {
		if (shiftAmount <= 0) {
			throw new IllegalArgumentException("encodeChar(): bad argument");
		}
		char chEncoded;
		if (Character.isUpperCase(ch) ) {
			int chEncodedAsInt = ( (ch - 'A' + shiftAmount) % 26) + 'A';
			chEncoded = (char) chEncodedAsInt;
		} else {
			chEncoded = ch;
		}
		return chEncoded;
	}

	public String encodeString(String str, int shiftAmount) {
		if (shiftAmount <= 0) {
			throw new IllegalArgumentException( "encodeString(): bad argument");
		}
		
		String codedStr = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			char chEncoded = encodeChar(ch, shiftAmount);
			codedStr += chEncoded;
		}
		return codedStr;
	}

	public void encodeFile(Scanner fin, int shift, PrintWriter fout) {
		if (fin == null || shift <= 0 || fout == null) {
			throw new IllegalArgumentException( "encodeString(): bad argument");
		}
		while ( fin.hasNextLine() ) {
			String line = fin.nextLine();
			String lineEncoded = encodeString(line, shift);
			fout.println(lineEncoded);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Caesar Cipher file encoder");
		Scanner in = FileOps.promptForFileIn("Input file name: ");
		System.out.print("Positions to shift: ");
		int shiftAmount = FileOps.kbd.nextInt();
		PrintWriter out = FileOps.promptForFileOut("Save as: ");
		CaesarCipherCoder ccCoder = new CaesarCipherCoder();
		ccCoder.encodeFile(in, shiftAmount, out);
		in.close();
		out.close();
		System.out.println("Processing complete.");
	}
}
