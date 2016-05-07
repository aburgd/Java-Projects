import java.util.Arrays;
import java.util.stream.IntStream;

public class FizzBuzz {

	public static void main(String[] args) {
		int[] nums = IntStream.rangeClosed(1, 100).toArray();
		
		for (int i : nums) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
