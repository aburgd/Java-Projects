public class PH {
	public static final double MIN = 0.0;
	public static final double MAX = 14.0;
	public static final double NEUTRAL = 7.0;
	
	public PH( double pH ) {
		if (pH < MIN || pH > MAX) {
			System.err.println("PH(): bad argument received: " + pH);
			System.exit(1);
		} else {
			myValue = pH;
		}
	}

	public String label() {
		if (myValue < MIN || myValue > MAX) {
			return "error";
		} else if (myValue < NEUTRAL) {
			return "acidic";
		} else if (myValue > NEUTRAL) {
			return "alkaline";
		} else {
			return "neutral";
		}
	}

	private double myValue;
}
		
