import java.util.Arrays;

public class SearchMethods {

	public static int linearSearch(int[] list, int item) {
		for(int idx = 0; idx < list.length; idx++) {
			// traverse through the array
			if(list[idx] == item) return idx;
		}
		
		// element not found
		return -1;
	}

	public static int binarySearch(int[] list, int item) {
		// sort the array
		Arrays.sort(list);
		// set low point and high point
		int lowIdx = 0, highIdx = list.length - 1;

		while (lowIdx <= highIdx) {
			// find midpoint
			int midpoint = (lowIdx + highIdx) / 2;
			if (list[midpoint] > item) { // midpoint greater than target
				highIdx = midpoint - 1; // lower the high point -1 below mid point
			} else if (list[midpoint] < item) { // midpoint less than target
				lowIdx = midpoint + 1; // raise the low point +1 above midpoint
			} else if (list[midpoint] == item)
				return midpoint; // target item fond
		}
		// not found
		return -1;
	}

	// exponential search
	public static int exponentialSearch(int[] list, int item) {
		// sort the array
		Arrays.sort(list);
		// start at range 1
		int idx = 1;
		// if the first index has our item, return it
		if (list[0] == item)
			return 0;

		while (idx < list.length && list[idx] <= item) { 
			// keep doubling range until we exceed target item
			idx *= 2;
		}
		
		// return binary search of sub array
		return Arrays.binarySearch(list, idx / 2, Math.min(idx, list.length), item);
	}

}
