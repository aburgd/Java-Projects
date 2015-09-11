import java.util.Scanner;

public class MHALL {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What is your name? ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.print("What is your favourite animal? ");
		Scanner scanner1 = new Scanner(System.in);
		String animal = scanner1.nextLine();
		
		System.out.println(name + " had a little " + animal);
		System.out.println("little " + animal + "," );
		System.out.println("little " + animal + ",");
		System.out.println(name + " had a little " + animal + ",");
		System.out.println("its fleece was white as snow.");
	}

}