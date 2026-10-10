import java.util.*;

public class FactorialTest {
	
	// factorial function
	public static int factorial(int N) {
		if (N == 0) // 0! = 1
			return 0;
		else if (N == 1) // 1! = 1
			return 1;
		else {
			return N * factorial(N - 1); // x! = x * (x-1)!
		}
	}

	public static void main(String[] args) {
		// receive user input
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		
		// factorial function
		System.out.println(factorial(N));

	}

}
