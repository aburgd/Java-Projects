import java.util.Scanner;

public class TShirtOrder {

	private static Scanner kbd;

	public static void main(String[] args) {
		kbd = new Scanner(System.in);
		
		int shirtCount = 0;
		double price = 0.0;
		String sizes = "";
		
		while(true) {
			System.out.println("Enter a  TShirt size to begin (XS, S, M, L, XL) or q to finish and pay.");
			String size = kbd.nextLine();
			if (size.equals("q")) {
				break;
			} else {
				shirtCount++;
				System.out.println("Enter a color: ");
				String color = kbd.nextLine();
				TShirt shirt = new TShirt(size, color);
				price += shirt.getPrice();
				sizes += shirt.getSize() + " ";
				
			}
		}
		System.out.println("You are buying " + shirtCount + " shirts in " + sizes + "sizes for $" + (price * 1.06)
				+ " including 6% tax.");
		
	}
}
