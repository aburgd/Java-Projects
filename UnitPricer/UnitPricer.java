import java.util.Scanner;

public class UnitProject {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What is the first item? ");
		Scanner scanner = new Scanner(System.in);
		String item1 = scanner.nextLine();
		System.out.print("Enter the price of the first item: ");
		double price1 = keyboard.nextDouble();
		System.out.print("How many units are in the first item? ");
		double units1 = keyboard.nextDouble();
		
		System.out.print("What is the second item? ");
		Scanner scanner2 = new Scanner(System.in);
		String item2 = scanner2.nextLine();
		System.out.print("Enter the price of the second item: ");
		double price2 = keyboard.nextDouble();
		System.out.print("How many units are in the second item? ");
		double units2 = keyboard.nextDouble();
		
		double unitPrice1 = price1/units1;
		double unitPrice2 = price2/units2;
		
		System.out.printf("%n" + item1 + " unit price: $%7.2f", unitPrice1);
		System.out.printf("%n" + item2 + " unit price: $%7.2f", unitPrice2);

	}

}
