import java.util.*;

public class TShirtOrder {
	private double myTotal = 0.00;
	private LinkedList<TShirt> myShirts = new LinkedList<TShirt>();
	private TShirt [] myShirtKinds = { new XSmallTShirt(),
									   new SmallTShirt(),
									   new MediumTShirt(),
									   new LargeTShirt(),
									   new XLargeTShirt() };
	
	public double getTotal() { return myTotal; }
	public LinkedList<TShirt> getShirts() { return myShirts; }
	
	public void takeOrder() {
		final String MENU = "To order a t-shirt, enter:\n"
				+ " 0 - for extra small\n"
				+ " 1 - for small\n"
				+ " 2 - for medium\n"
				+ " 3 - for large\n"
				+ " 4 - for extra large\n"
				+ " 5 - to quit\n"
				+ "--> ";
		final int QUIT = 5;
		int choice = 0;
		Scanner kbd = new Scanner(System.in);
		do {
			System.out.print(MENU);
			choice = kbd.nextInt();
			if (choice >= 0 && choice < QUIT) {
				TShirt shirt = myShirtKinds[choice];
				myTotal += shirt.getPrice();
				myShirts.add(shirt);
				System.out.printf("%s: $%.2f%n%n", shirt, shirt.getPrice());
			} 
		} while (choice != QUIT);
	}
		
		private void printSummary() {
			System.out.println();
			for (TShirt shirt : myShirts) {
				System.out.printf("%s: $%.2f\n", shirt, shirt.getPrice());
			}
			System.out.printf("The total price of your order is: $%.2f", this.getTotal());
		}
		
		public static void main(String[] args) {
			TShirtOrder self = new TShirtOrder();
			self.takeOrder();
			self.printSummary();
		}
	}

