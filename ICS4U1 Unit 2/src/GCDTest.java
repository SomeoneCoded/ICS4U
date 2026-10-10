import java.util.*;

public class GCDTest {

	public static void main(String[] args) {
		// obtain user input
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		
		// determine GCD
		System.out.println(gcd(x, y));

	}
	
	// GCD method
	private static int gcd(int x, int y) {
		if (y == 0) 
			return x;
		else {
			// Similar to tiling algorithm (Euclid algorithm)
			return gcd(y, x % y);
		}
	}

}
