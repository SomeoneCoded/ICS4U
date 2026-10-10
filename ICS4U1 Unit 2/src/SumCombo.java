import java.util.*;

public class SumCombo {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 6, 7 };
		int sum = 7;
		int [] comboSet = new int[sum];

		sumCombo(arr, sum, comboSet, 0, 0);

	}

	private static void sumCombo(int[] numSet, int remaining, int[] comboSet, int startIndex, int setLength) {
		if (remaining == 0)
			System.out.println(Arrays.toString(comboSet));
		else {
			for(int i = startIndex; i < numSet.length; i++) {
				if(remaining - numSet[i] >= 0) {
					comboSet[setLength] = numSet[i];
					sumCombo(numSet, remaining - numSet[i], comboSet, i, setLength+1);
				} else
					comboSet[setLength] = 0; // backtrack the numbers
			}
		}
		

	}

}
