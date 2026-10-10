import java.util.*;

public class TowerOfHanoiTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		towerHanoi(N, 'A', 'C', 'B');

	}

	private static void towerHanoi(int n, char from, char to, char aux) {
		if (n == 0)
			return;
		towerHanoi(n - 1, from, aux, to);
		System.out.println("Move disk: " + n + " from rod " + from + " to rod " + to);
		towerHanoi(n - 1, aux, to, from);

	}

}
