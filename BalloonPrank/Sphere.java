public class Sphere {
	double myRadius;
	
	public Sphere(double rad) {
		myRadius = rad;
	}
	
	public static double volume(double rad) {
		return 4.0 / 3.0 * Math.PI * Math.pow(rad, 3.0);
	}
	
	public double volume() {
		return volume(myRadius);
	}
}
