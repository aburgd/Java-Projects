public class Box {
	
	double myLength;
	double myWidth;
	double myHeight;
	
    public Box(double length, double width, double height) {
    	myLength = length;
    	myWidth = width;
    	myHeight = height;
    }
    
    public static double volume(double length, double width, double height) {
    	return length * width * height;
    }
    
    public double volume() {
    	return volume(myLength, myWidth, myHeight);
    }
    
}
