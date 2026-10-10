import java.util.*;

public class TimeFibonacciNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		long start = System.nanoTime();
		System.out.printf("Time: %d", fibonacciTimeCalculator(start, N));

	}

	private static long fibonacciTimeCalculator(long time, int N) {
		int sum = fibonacciCalculator(N);
		System.out.println(sum);
		return System.nanoTime() - time;

	}

	private static int fibonacciCalculator(int n) {
		if (n == 0) {
			return 0;
		}

		else if (n == 1) {
			return 1;
		}

		else if (n == 2) {
			return 1;
		}

		else {
			return fibonacciCalculator(n - 1) + fibonacciCalculator(n - 2);
		}

	}

}
