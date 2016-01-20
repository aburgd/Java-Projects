package pH;

public class PH {
		// strongly acidic
		public static final double STRONG_AC_MIN = 0.00;
		// acidic
		public static final double AC_MIN = 2.10;
		// weakly acidic
		public static final double WEAK_AC_MIN = 4.10;
		// near neutral bottom range
		public static final double BOT_NEUT_MIN = 6.10;
		//neutral
		public static final double NEUTRAL = 7.00;
		// near neutral top range
		public static final double TOP_NEUT_MIN = 7.01;
		// weakly alkaline
		public static final double WEAK_AL_MIN = 8.10;
		// alkaline
		public static final double AL_MIN = 10.10;
		// strongly alkaline
		public static final double STRONG_AL_MIN = 12.10;
		
		public static final double MIN = 0.00;
		public static final double MAX = 14.00;
		
		public PH(double pH) {
			if (pH < STRONG_AC_MIN || pH > 14.00) {
				System.err.println("PH(): bad argument received: " + pH);
				System.exit(1);
			} else {
				myValue = pH;
			}
		}
		
		public String label() {
			if (myValue < MIN || myValue > MAX) {
				return "error";
			} else if (myValue <= STRONG_AC_MIN) {
				return "strongly acidic";
			} else if (myValue > STRONG_AC_MIN && myValue <= AC_MIN) {
				return "acidic";
			} else if ( (myValue > AC_MIN && myValue < NEUTRAL) || (myValue > NEUTRAL && myValue < WEAK_AL_MIN) ) {
				return "near neutral";
			} else if (myValue >= WEAK_AL_MIN && myValue < AL_MIN) {
				return "weak alkaline";
			} else if (myValue >= AL_MIN && myValue < STRONG_AL_MIN) {
				return "alkaline";
			} else if (myValue >= STRONG_AL_MIN && myValue < MAX) {
				return "strong alkaline";
			} else if (myValue == NEUTRAL) {
				return "neutral";
			} else {
				return null;
			}
			
		}
		
		private double myValue;
		
	}
