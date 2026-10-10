
public class RationalNumber {
	private int numerator, denominator;

	public RationalNumber(int numerator, int denominator) {
		super();
		simplify(numerator, denominator);
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return "RationalNumbers [numerator=" + numerator + ", denominator=" + denominator + "]";
	}
	
	private void simplify(int numerator2, int denominator2) {
		int gcd = gcd(Math.abs(numerator2), Math.abs(denominator2));
		setNumerator(numerator/gcd);
		setDenominator(denominator/gcd);
		
	}

	private int gcd(int numerator, int denominator) {
		if(numerator % denominator == 0) return numerator;
		else 
			return gcd(denominator, numerator % denominator);
	}

	private void add(RationalNumber num2) {
		RationalNumber num3 = new RationalNumber(this.numerator * num2.denominator + num2.numerator * this.denominator,
				this.denominator * num2.denominator);
		num3.simplify(num3.numerator, num3.denominator);
	}

	private void subtract(RationalNumber num2) {
		RationalNumber num3 = new RationalNumber(this.numerator * num2.denominator - num2.numerator * this.denominator,
				this.denominator * num2.denominator);
		num3.simplify(num3.numerator, num3.denominator);
	}

	private void multiply(RationalNumber num2) {
		RationalNumber num3 = new RationalNumber(this.numerator * num2.numerator, this.denominator * num2.denominator);
		num3.simplify(num3.numerator, num3.denominator);
	}

	private void divide(RationalNumber num2) {
		RationalNumber num3 = new RationalNumber(this.numerator * num2.denominator, this.denominator * num2.numerator);
		num3.simplify(num3.numerator, num3.denominator);
	}
	
	private String printRationalNumber() {
		simplify(numerator, denominator);
		return numerator + "/" + denominator;
	}
	
	private String printFloatRationalNumbers(int decimalPlace) {
		String floatNumber = String.format("%." + decimalPlace + "f", (double) numerator/denominator);
		return floatNumber;
	}
}
