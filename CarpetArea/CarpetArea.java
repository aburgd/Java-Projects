import java.util.Scanner;

public class CarpetArea
{
	public static void main (String[] args)
	{
	    Scanner keyboard = new Scanner(System.in);
	    
		System.out.print("Length of room in feet: ");
		double length = keyboard.nextDouble();
		System.out.print("Width of room in feet: ");
		double width = keyboard.nextDouble();
		
		double lengthyd = length / 3;
		double widthyd = width / 3;
		
		double areayd = lengthyd * widthyd;
		
		System.out.printf("You need %.2f square yards of carpet." , areayd);
		System.out.println("");
		
	}
}
