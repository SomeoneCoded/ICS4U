import java.util.*;

public class PrintArray {

	public static void main(String[] args) {
		// receive input size
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		// store values into array
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = input.nextInt();

		// print the array
		printArray(arr, 0, N);

	}

	private static void printArray(int[] arr, int leftIndex, int rightIndex) {
		System.out.print(arr[leftIndex] + " ");
		// from left to right
		if (leftIndex + 1 == rightIndex)
			return;
		else {
			printArray(arr, ++leftIndex, rightIndex);
		}

	}

}
