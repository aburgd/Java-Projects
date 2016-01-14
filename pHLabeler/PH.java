package pH;

public class PH {
		// strongly acidic
		public static final double STRONG_AC_MIN = 0.0;
		public static final double STRONG_AC_MAX = 2.0;
		// acidic
		public static final double AC_MIN = 2.1;
		public static final double AC_MAX = 4.0;
		// weakly acidic
		public static final double WEAK_AC_MIN = 4.1;
		public static final double WEAK_AC_MAX = 6.0;
		// near neutral bottom range
		public static final double BOT_NEUT_MIN = 6.1;
		public static final double BOT_NEUT_MAX = 6.99;
		//neutral
		public static final double NEUTRAL = 7.0;
		// near neutral top range
		public static final double TOP_NEUT_MIN = 7.01;
		public static final double TOP_NEUT_MAX = 8.0;
		// weakly alkaline
		public static final double WEAK_AL_MIN = 8.1;
		public static final double WEAK_AL_MAX = 10.0;
		// alkaline
		public static final double AL_MIN = 10.1;
		public static final double AL_MAX = 12.0;
		// strongly alkaline
		public static final double STRONG_AL_MIN = 12.1;
		public static final double STRONG_AL_MAX = 14.0;
		
		public PH(double PH) {
			if (pH < STRONG_AC_MIN || pH > STRONG_AL_MAX) {
				System.err.println("PH(): bad argument received: " + pH);
				System.exit(1);
			} else {
				myValue = pH;
			}
		}
		
		public String label() {
			if (myValue < STRONG_AC_MIN || myValue > STRONG_AL_MAX) {
				return "error";
			} 
			if (myValue >= STRONG_AC_MIN && myValue <= STRONG_AC_MAX) {
				return "strongly acidic";
			} else if (myValue >= AC_MIN && myValue <= AC_MAX) {
				return "acidic";
			} else if (myValue >= WEAK_AC_MIN && myValue <= WEAK_AC_MAX) {
				return "weakly acidic";
			} else if (myValue >= BOT_NEUT_MIN && myValue <= BOT_NEUT_MAX) {
				return "nearly neutral";
			} else if (myValue == NEUTRAL) {
				return "nearly";
			} else if (myValue >= TOP_NEUT_MIN && myValue <= TOP_NEUT_MAX) {
				return "nearly neutral";
			} else if (myValue >=WEAK_AL_MIN && myValue <= WEAK_AL_MAX) {
				return "weakly alkaline";
			} else if (myValue >= AL_MIN && myValue <= AL_MAX) {
				return "alkaline";
			} else if (myValue >= STRONG_AL_MIN && myValue <= STRONG_AL_MAX) {
				return "strongly alkaline";
			} else {
				System.err.println("PH(): bad argument received: " + pH);
				System.exit(1);
			}
			
		private double myValue;
		
	}