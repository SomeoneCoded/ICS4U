
public class ComplexNumberTest {

	public static void main(String[] args) {
		ComplexNumber complexNumber1 = new ComplexNumber(6, 9);
		ComplexNumber complexNumber2 = new ComplexNumber(4, 16);

		addComplexNumber(complexNumber1, complexNumber2);
		subtractComplexNumber(complexNumber1, complexNumber2);
		printComplexNumber(complexNumber1);
		printComplexNumber(complexNumber2);

	}

	private static void addComplexNumber(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
		float real = complexNumber1.getRealPart() + complexNumber2.getRealPart();
		float imaginary = complexNumber1.getImaginaryPart() + complexNumber2.getImaginaryPart();
		System.out.printf("%.1f + %.1fi\n", real, imaginary);

	}

	private static void subtractComplexNumber(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
		float real = complexNumber2.getRealPart() - complexNumber1.getRealPart();
		float imaginary = complexNumber2.getImaginaryPart() - complexNumber1.getImaginaryPart();
		if (imaginary < 0)
			System.out.printf("%.1f - %.1fi\n", real, Math.abs(imaginary));
		else
			System.out.printf("%.1f + %.1fi\n", real, imaginary);

	}

	private static void printComplexNumber(ComplexNumber complexNumber) {
		System.out.printf("(%.1f, %.1f)\n", complexNumber.getRealPart(), complexNumber.getImaginaryPart());

	}



}
