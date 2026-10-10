
public class ReverseWord {

	public static void main(String[] args) {
		System.out.println(reverseWord("The fitness gram pacer test is a multi-aerobic test"));

	}

	private static String reverseWord(String phrase) {
		if(!phrase.contains(" ")) return phrase;
		else {
			return reverseWord(phrase.substring(phrase.indexOf(" ") + 1, phrase.length())) 
					+ " " + phrase.substring(0, phrase.indexOf(" "));
		}
	}

}
