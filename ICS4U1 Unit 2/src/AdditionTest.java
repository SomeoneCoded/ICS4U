
public class AdditionTest {

	public static void main(String[] args) {
		System.out.print(add(5, 9));

	}

	private static int add(int num1, int num2) {
		if(num2 == 0) return num1;
		else return add(num1 + 1, num2 - 1);
	}

}
