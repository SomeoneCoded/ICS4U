import java.util.*;

public class MinimumValueArray {

	public static void main(String[] args) {
		// receive array size
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		// store values
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = input.nextInt();

		// find minimum value
		System.out.println(minimumValue(arr, N - 1, Integer.MAX_VALUE));
	}

	private static int minimumValue(int[] arr, int index, int minValue) {
		if (arr[index] < minValue)
			minValue = arr[index]; // if we found smaller value, mark that as the smallest
		if (index == 0) // once we went through the array
			return minValue; // return the smallest value
		return minimumValue(arr, --index, minValue);

	}

}
