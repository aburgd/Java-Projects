import java.util.Scanner;

public class DiscountCalc
{
	public static void main (String[] args)
	{
	    Scanner keyboard = new Scanner(System.in);
	    
		System.out.print("Price of item: ");
		double price = keyboard.nextDouble();
		System.out.print("Discount as decimal: ");
		double discount = keyboard.nextDouble();
		
		double p1 = price * discount;
		double finalp = price - p1;
		
		System.out.printf("The discounted price is $%.2f, which is $%.2f less than $%.2f." , finalp, p1, price);
		System.out.println(" ");
		
	}
}
