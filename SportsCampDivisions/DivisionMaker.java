import java.util.*;
import java.io.*;

public class DivisionMaker {
	public static void main(String[] args) {
		System.out.println("To make the 'A' and 'AA' divisions,");
		System.out.print(" enter the name of the input file: ");
		kbd = new Scanner(System.in);
		String inFileName  = kbd.nextLine();
		DivisionMaker dm = new DivisionMaker();
		dm.readStudents(inFileName);
		dm.makeDivisions();
		System.out.print("\nDivision A :\n" + dm.getDivA() );
		System.out.print("\nDivision AA : \n" + dm.getDivAA() );
	}
	
	public void readStudents(String inputFile) {
		myStudents = new ArrayList<Student>();
		Scanner fin = null;
		try {
			fin = new Scanner( new File(inputFile) );
			while ( fin.hasNext() ) {
				Student student = new Student();
				student.read(fin);
				myStudents.add(student);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			fin.close();
		}
	}
	
	public void makeDivisions() {
		double median = findMedian();
		myDivAA = new LinkedList<Student>();
		myDivA = new LinkedList<Student>();
		for (Student stu : myStudents) {
			if (stu.getScore() > median) {
				myDivAA.add(stu);
			} else {
				myDivA.add(stu);
			}
		}
	}
	
	public double findMedian() {
		Collections.sort(myStudents);
		int numStu = myStudents.size();
		int median, midInd1, midInd2;
		midInd1 = numStu / 2;
		if ( numStu % 2 != 0 ) {
			median = myStudents.get(midInd1).getScore();
		} else {
			midInd2 = midInd1 - 1;
			median = ( myStudents.get(midInd1).getScore() + myStudents.get(midInd2).getScore() ) / 2;
		}
		
		return median;
	}
	
	public LinkedList<Student> getDivA() { return myDivA; }
	public LinkedList<Student> getDivAA() { return myDivAA; }
	
	private ArrayList<Student> myStudents = null;
	private LinkedList<Student> myDivA = null;
	private LinkedList<Student> myDivAA = null;
	private static Scanner kbd;
}
