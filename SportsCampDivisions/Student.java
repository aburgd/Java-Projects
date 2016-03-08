import java.util.Scanner;

public class Student implements Comparable<Student> {
	public Student() {
		myName = "";
		myScore = 0;
	}
	
	public String getName() { return myName; }
	public int getScore() { return myScore; }
	public String toString() { return myName + "(" + myScore + ")"; }
	
	public int compareTo(Student stu) {
		return myScore = stu.getScore();
	}
	
	public void read(Scanner in) {
		String name = in.next() + " " + in.next();
		int score = in.nextInt();
		if (score < 0 || score > 100) {
			throw new IllegalArgumentException("read(): bad score");
		}
		myScore = score;
		myName = name;
	}
	
	private String myName;
	private int myScore;
}
