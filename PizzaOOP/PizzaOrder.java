import java.util.*;

public class PizzaOrder {
	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		Pizza [] pizzaSizes = { new PersonalPizza(),
								new MediumPizza(),
								new LargePizza(),
								new XLargePizza() };
		
		String [] toppings = { new String("lust"),
							   new String("gluttony"),
							   new String("greed"),
							   new String("sloth"),
							   new String("pride"),
							   new String("wrath"),
							   new String("envy") };
		
		System.out.println("Welcome to the Pizza Shoppe!");
		double subtotal = 0.0;
		int pizzaChoice = 0;
		int toppingChoice = 0;
		Pizza pizza = null;
		LinkedList<Pizza> myPizzas = new LinkedList<Pizza>();
		
		do {
			System.out.println("What size pizza would you like?");
			System.out.println("0 - Personal");
			System.out.println("1 - Medium");
			System.out.println("2 - Large");
			System.out.println("3 - Extra Large");
			System.out.println("4 - Finish order");
			pizzaChoice = kbd.nextInt();
		
			if (pizzaChoice != 4) {
				pizza = pizzaSizes[pizzaChoice];
			
				System.out.print("\nSubtotal: $" + (subtotal + pizza.getPrice() ) ); 
				System.out.println("\nAvailable toppings: ");
				for (int i = 1; i < 7; i++) {
					System.out.println(i + " - " + toppings[i]);
				}
				System.out.print("\nEnter the number of toppings (one per line): ");
			
				do {
					toppingChoice = kbd.nextInt();
					if(toppingChoice != 999) {
						pizza.addTopping(toppings[toppingChoice-1]);
					}
				
					System.out.println("Subtotal: $" + (subtotal + pizza.getPrice() ) );
				} while (toppingChoice != 999);
			
				myPizzas.add(pizza);
			
				subtotal = 0;
				for (Pizza piz : myPizzas) {
					subtotal += piz.getPrice();
				}
			}
		
		} while (pizzaChoice != 4);
		
		System.out.println("\n\nOrder Summary");
		double total = 0;
		for (Pizza pizOrder : myPizzas) {
			System.out.println(pizOrder);
			System.out.println();
		}
		
		System.out.println("\nTotal due: $" + subtotal);
	}
}