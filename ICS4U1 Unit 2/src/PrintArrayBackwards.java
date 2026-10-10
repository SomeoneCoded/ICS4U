import java.util.*;

public class PrintArrayBackwards {

	public static void main(String[] args) {
		// receive input and convert into character array
		Scanner input = new Scanner(System.in);
		char[] charArray = input.nextLine().toCharArray();

		// print the string backwards
		printArrayBackwards(charArray, charArray.length - 1);

	}

	private static void printArrayBackwards(char[] charArray, int index) {
		System.out.print(charArray[index]);
		if (index == 0)
			return; // if we reached the end, terminate
		else
			printArrayBackwards(charArray, --index); // otherwise keep shifting from right to left

	}

}
