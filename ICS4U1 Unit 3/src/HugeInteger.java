import java.util.Arrays;

public class HugeInteger {
	private int [] digits;

	public HugeInteger() {
		super();
		digits = new int[40];
	}

	public int[] getDigits() {
		return digits;
	}

	public void setDigits(int[] digits) {
		this.digits = digits;
	}
	
	@Override
	public String toString() {
		return "HugeInteger [digits=" + Arrays.toString(digits) + "]";
	}

	public void input(String number) {
		char[] arr = number.toCharArray();
		// position the number to the rightmost side of the array
		int indexCounter = digits.length - arr.length;
		
		// keep track of our number string
		int currentIndex = 0;
		for (int index = indexCounter; index < arr.length; index++) {
			digits[index] = arr[currentIndex] - '0';
			currentIndex++;
		}
	}
	
	public void output(int [] digits) {
		int firstDigitIndex = 0;
		do {
			if(digits[firstDigitIndex] == 0)
				firstDigitIndex++; // keep moving right until we get to our number
			else break;
		} while (firstDigitIndex < digits.length);
		
		if(firstDigitIndex == digits.length)
			System.out.print(0);
		else
			for(int i = firstDigitIndex; i < digits.length; i++) {
				System.out.print(digits[i]);
			}
		System.out.println();
	}
	
	public HugeInteger add(HugeInteger num2) {
		HugeInteger result = new HugeInteger();
		int carry = 0;
		for(int i = digits.length - 1; i >= 0; i--) {
			int sum = this.digits[i] + num2.digits[i] + carry;
			
			result.digits[i] = sum % 10;
			carry = sum / 10;
		}
		
		return result;
	}
	
	public HugeInteger subtract(HugeInteger num2) {
		HugeInteger result = new HugeInteger();
		int borrow = 0;
		for(int i = digits.length - 1; i >= 0; i--) {
			int difference = this.digits[i] - num2.digits[i] - borrow;
			if(difference < 0) {
				difference += 10;
				borrow += 1;
			} else
				borrow = 0;
			
			result.digits[i] = difference;
		}
		
		return result;

	}
	
	public void multiply(HugeInteger num2) {
		HugeInteger result = new HugeInteger();

	}
	
	public void divide(HugeInteger num2) {
		HugeInteger result = new HugeInteger();

	}
	
	public boolean isEqualTo(HugeInteger num2) {
		return Arrays.equals(this.digits, num2.digits);
		
	}
	
	public boolean isNotEqualTo(HugeInteger num2) {
		return !isEqualTo(num2);

	}

	public boolean isGreaterThan(HugeInteger num2) {
		for (int i = 0; i < digits.length; i++) {
			if (this.digits[i] > num2.digits[i])
				return true;
			else if (this.digits[i] < num2.digits[i])
				return false;
			else
				continue;
		}
		
		return false;
	}

	public boolean isLessThan(HugeInteger num2) {
		return !isGreaterThan(num2);
		
	}
	
	public boolean isGreaterThanOrEqualTo(HugeInteger num2) {
		return isGreaterThan(num2) || isEqualTo(num2);
		
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger num2) {
		return isLessThan(num2) || isEqualTo(num2);
		
	}
}
