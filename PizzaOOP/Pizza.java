import java.util.*;
abstract public class Pizza {
	public Pizza(String size, double price, int slices) {
		toppings = new LinkedList<String>();
		mySize = size;
		myPrice = price;
		mySlices = slices;
	}
	
	public double getPrice() { 
		return (myPrice + (double) toppings.size() * getToppingPrice() );
	}
	
	public String getToppings() {
		String myToppings = "";
		
		for (String top : toppings) {
			myToppings += top + " ";
		}
		return myToppings;
		
	}
	
	public void addTopping(String top) {
		toppings.add(top);
	}
	
	public String toString() { 
		String pizza = "";
		pizza += "Size: " + mySize;
		pizza += "\n# of Slices: " + mySlices;
		pizza += "\nToppings: " + getToppings();
		pizza += "\nTotal cost: " + getPrice();
		
		return pizza;
	}
	
	abstract public double getToppingPrice();
	
	private String mySize;
	private double myPrice;
	private int mySlices;
	private LinkedList<String> toppings;
}