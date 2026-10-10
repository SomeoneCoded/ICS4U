import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMethods {
	// Comparison Sorting Algorithms: Bubble Sort, Selection Sort, Insertion Sort
	// In place algorithms
	public static void bubbleSort(int[] list) {
		// set the rightmost point
		for (int x = list.length - 1; x > 0; x--) {
			// tells us if we swapped values
			boolean swapped = false;
			for (int y = 0; y < x; y++) {
				// look through each adjacent pair and see if we need to swap
				if (list[y] > list[y + 1]) {
					int temp = list[y + 1];
					list[y + 1] = list[y];
					list[y] = temp;
					swapped = true;
				}
			}

			// if we didn't need to swap anything, our array is sorted
			if (!swapped)
				break;
		}

	}

	public static void selectionSort(int[] list) {
		for (int x = 0; x < list.length - 1; x++) {
			// consider index x as the smallest number
			int smallest = x;

			for (int y = x + 1; y < list.length; y++) {
				if (list[y] < list[smallest]) {
					// if we find a smaller value, mark that as the smallest
					smallest = y;
				}
			}

			// swap the original index with the smallest index
			int temp = list[smallest];
			list[smallest] = list[x];
			list[x] = temp;

		}

	}

	public static void insertionSort(int[] list) {
		// considered the first element to be sorted
		for (int idx = 1; idx < list.length; idx++) {
			// iterate through the array and get its element and index
			int key = list[idx];
			// iterate through the sorted array
			for (int j = idx - 1; j > -1; j--) {
				// check if our key value is less than the left value
				if (key < list[j]) { // if our key value is smaller than the left value, swap places
					// swap values
					// left value swaps with right
					list[j + 1] = list[j];
					// right value swaps with left
					list[j] = key;
				} else
					break; // otherwise we have properly inserted the value
			}
		}

	}

	// Integer Sorting Algorithms: Counting Sort, Bucket Sort, Radix Sort
	public static void countingSort(int[] list) {
		// Find the possible largest range of data set
		// In this case, we assume we have nonnegative numbers
		int maxValue = Integer.MIN_VALUE;
		for (int idx = 0; idx < list.length; idx++) {
			maxValue = Math.max(maxValue, list[idx]);
		}
		
		/*
		 * int minValue = Integer.MAX_VALUE; for (int idx = 0; idx < list.length; idx++)
		 * { minValue = Math.min(minValue, list[idx]); }
		 */	

		// Make a counter array with a size of your maximum value
		int[] count = new int[maxValue + 1];
		for (int idx = 0; idx < list.length; idx++) {
			count[list[idx]]++; // tallying
		}

		// Traverse through the array
		// Keep an index counter for your output array
		int index = 0;
		for (int idx = 0; idx <= maxValue; idx++) {
			// while there is still more of a specific number to be sorted
			while (count[idx] > 0) {
				// set the index value of the counter array in your output data index and
				// increment your output data index by 1
				list[index++] = idx;
				// subtract a count of your index in counter array
				count[idx]--;
			}
		}

	}

	public static void bucketSort(int[] list) {
		// find max value to figure out the amount of buckets we will need
		int maxValue = 0;
		for(int idx = 0; idx < list.length; idx++) {
			maxValue = Math.max(maxValue, list[idx]);
		}
		
		// set your bucket size
		int bucketSize = (int) Math.sqrt(list.length);
		@SuppressWarnings("unchecked")
		List<Integer> [] buckets = new ArrayList[maxValue/bucketSize+1]; // Create an array to store buckets
		// create buckets
		for(int idx = 0; idx < buckets.length; idx++) {
			buckets[idx] = new ArrayList<>();
		}
		
		for(int idx = 0; idx < list.length; idx++) {
			// distribute your values accordingly
			buckets[list[idx]/bucketSize].add(list[idx]);
		}
		
		for(int idx = 0; idx < buckets.length; idx++) {
			// sort each bucket
			Collections.sort(buckets[idx]);
		}
		
		// sort the buckets and later combine them
		int index = 0;
		for(int idx = 0; idx < buckets.length; idx++) {
			if(buckets[idx].size() > 0) {
				int [] tempBucket = new int[buckets[idx].size()];
				
				for(int y = 0; y < tempBucket.length; y++) {
					tempBucket[y] = buckets[idx].get(y);
				}
				
				insertionSort(tempBucket);
				
				for (int idxx = 0; idxx < tempBucket.length; idxx++) {
					list[index++] = tempBucket[idxx];
				}
			}
			
		}

	}

	public static void radixSort(int[] list) {
		// find the max value in the array to find the largest digit plac
		int maxValue = 0;
		for (int idx = 0; idx < list.length; idx++) {
			maxValue = Math.max(maxValue, list[idx]);
		}

		// create an array of buckets that will store the digits
		List<Integer>[] radixArray = new ArrayList[10];
		for (int idx = 0; idx < radixArray.length; idx++) {
			radixArray[idx] = new ArrayList<Integer>();
		}

		// start with ones digit, move up to the max digit
		int exp = 1;
		// traverse through as many digits
		while (maxValue / exp > 0) {
			// add elements into corresponding digits
			for (int idx = 0; idx < list.length; idx++) {
				radixArray[(int) ((list[idx] / exp) % 10)].add(list[idx]);
			}

			// put the array back together in their sorted digit order
			int index = 0;
			for (int digit = 0; digit < 10; digit++) {
				while (!radixArray[digit].isEmpty()) {
					list[index++] = radixArray[digit].remove(0);
				}
			}

			// check the next digit
			exp *= 10;
		}

	}

	public static void shellSort(int[] list) {
		boolean swapped; // variable to check if we swapped values
		int gap = list.length / 2; // gap size

		do {
			do {

				swapped = false;
				for (int x = 0; x < list.length - gap; x++) {
					if (list[x] > list[x + gap]) {
						int temp = list[x];
						list[x] = list[x + gap];
						list[x + gap] = temp;
						swapped = true;
					}
				}

			} while (swapped); // ensures we did not cause a ripple effect that causes another unsorted pair

			gap /= 2; // reduce the gap once we have successfully sorted
		} while (gap >= 1);
	}

	public static void quickSort(int[] list, int start, int end) {
		// in this algorithm, think about a see-saw
		int left = start;
		int right = end;
		int pivot = list[(start + end) / 2]; // create a pivot point
		while (left <= right) { // while we have not crossed sides
			while (list[left] < pivot) // stop when our left side is equal to greater than our pivot point
				left++;
			while (list[right] > pivot) // stop when our right sides is equal to or less than or pivot point
				right--;
			if (left <= right) { // see if a swap is required
				int temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left++;
				right--;
			}
		}

		if (start < right) // if there's more unchecked values
			quickSort(list, start, right); // create a mini see-saw on our left
		if (left < end) // if there's more unchecked values
			quickSort(list, left, end); // create a mini see-saw on our right
	}

	// Alternate sorting algorithms
	// Divide portion
	public static void mergeSort(int[] list, int start, int end) {
		if ((end - start) >= 1) {
			// divide large array into smaller arrays
			int middle = (start + end) / 2;
			mergeSort(list, start, middle);
			mergeSort(list, middle + 1, end);

			// once we get the smallest unit of array, sort and merge them
			merge(list, start, end);
		}

	}

	// merge portion
	public static void merge(int[] list, int start, int end) {
		int mergeIndex = 0;
		int middle = (start + end) / 2;

		int leftIndex = start;
		int rightIndex = middle + 1;

		int[] mergedSubArray = new int[end - start + 1];

		while (leftIndex <= middle && rightIndex <= end) {
			if (list[leftIndex] < list[rightIndex]) { // if value at left sub-array index is smaller than the right
				mergedSubArray[mergeIndex] = list[leftIndex]; // add the left side value to merged sub-array
				leftIndex++; // move onto next number in left sub-array
			} else { // if value at right sub-array index is smaller than the left
				mergedSubArray[mergeIndex] = list[rightIndex]; // add the right side value to merged sub-array
				rightIndex++; // move onto next number in right sub-array
			}

			mergeIndex++; // shift position in merged sub-array
		}

		if (leftIndex > middle) { // see if any values are left over from the sort and merge them (these values
									// should be sorted in this subarray if they have been left over
			while (rightIndex <= end) {
				mergedSubArray[mergeIndex] = list[rightIndex];
				mergeIndex++;
				rightIndex++;
			}
		} else {
			while (leftIndex <= middle) {
				mergedSubArray[mergeIndex] = list[leftIndex];
				mergeIndex++;
				leftIndex++;
			}
		}

		for (int index = 0; index < mergedSubArray.length; index++) { //merge everything back
			list[start + index] = mergedSubArray[index];
		}
	}

}
