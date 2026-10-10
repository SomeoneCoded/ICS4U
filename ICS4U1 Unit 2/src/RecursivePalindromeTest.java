import java.util.*;

public class RecursivePalindromeTest {
	// Palindrome test
	public static boolean isPalindrome(char[] s, int left, int right) {
		if (s[left] != s[right]) // if leftmost is not the same as rightmost, it is not a palindrome
			return false;
		else if (left == right) // if we have reached the same index, it is a palindrome
			return true;
		else if (right > left) // this happens if the number of characters is even
			return true;
		else {
			return isPalindrome(s, left + 1, right - 1); // move your pointers closer
		}
	}

	public static void main(String[] args) {
		// get user inpit
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		// clean the string --> Removes punctuation and spaces 	
		// https://stackoverflow.com/a/49568506 --> Regex
		String clean = str.replaceAll("\\p{Punct}", "").toLowerCase().trim();
		
		// convert string to array
		char[] s = clean.toCharArray();
		
		// check for a palindrome
		System.out.println(isPalindrome(s, 0, s.length - 1));
	}

//	private static String removePunctuation(String str) {
//		for (int i = 0; i < str.length(); i++) {
//			if ((str.charAt(i) >= (char) 65 && str.charAt(i) <= (char) 90) || (str.charAt(i) >= (char) 97 && str.charAt(i) <= (char) 112)) {
//				continue;
//			} else {
//				String character = "" + str.charAt(i);
//				str.replaceAll(character, "");
//			}
//		}
//		
//		return str;
//	}

}
