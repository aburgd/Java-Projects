import java.util.Scanner;

public class Friend {
	public Friend() {
		myName = "";
		myEmail = "";
		myPhone = 0;
	}
	
	public String getName() { return myName; }
	public String getEmail() { return myEmail; }
	public long getPhone() { return myPhone; }
	
	public String toString() { return myName + "<" + myEmail + ">" + "," + myPhone; }
	
	public void read(Scanner in) {
		String name = in.next() + " " + in.next();
		String email = in.next();
		long phone = in.nextInt();
		if (phone < 0) {
			throw new IllegalArgumentException("read(): bad name");
		}
		
		myEmail = email;
		myPhone = phone;
		myName = name;
	}
	
	private String myName;
	private String myEmail;
	private long myPhone;
}
