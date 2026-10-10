
public class ComplexNumber {
	private float realPart;
	private float imaginaryPart;
	
	public ComplexNumber() {
		realPart = 0;
		imaginaryPart = 0;
	}

	public ComplexNumber(float realPart, float imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public float getRealPart() {
		return realPart;
	}

	public void setRealPart(float realPart) {
		this.realPart = realPart;
	}

	public float getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(float imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	
}
