public class PetLicense {
	public PetLicense(char PetCode) {
		switch (PetCode) {
			case 'd': case 'h':
				myFee = 10.00;
				break;
			case 'b': case 'c': case 'r':
				myFee = 5.00;
				break;
			case 'f':
				myFee = 1.00;
				break;
			case 'o':
				myFee = 0.00;
				break;
			default:
				System.out.println("License(code): code '" + petCode "' is invalid");
				System.exit(1);
			}
		myCode = petCode;

	}

	public double getFee() { return myFee; }
	
	private char myCode;
	private double myFee;
}
