import java.util.*;

public class PowerTest {
	// power function
	public static int power(int base, int exp) {
		if (exp == 1) // return itself
			return base;
		else {
			return base * (power(base, exp - 1)); // we recurse back to when exp = 1
		}
	}

	public static void main(String[] args) {
		// receive user input
		Scanner input = new Scanner(System.in);
		int base = input.nextInt();
		int exp = input.nextInt();

		// alternate to Math.pow();
		System.out.println(power(base, exp));

	}

}
