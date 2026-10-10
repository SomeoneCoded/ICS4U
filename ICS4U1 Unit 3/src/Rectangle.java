/*
 * (Rectangle Class) Create a class Rectangle. 
 * The class has attributes length and width, each of which defaults to 1. 
 * It has methods that calculate the perimeter and the area of the rectangle. 
 * It has set and get methods for both length and width. 
 * The set methods should verify that length and width are each floating-point numbers larger than 0.0 and less than 20.0. 
 * Write a program to test class Rectangle.
 */

// Template class
public class Rectangle { // extends Object is implicit

	// fields, attributes, characteristics, properties, instance variables
	private double length;
	private double width;

	// constructor method
	public Rectangle(double length, double width) {
		super(); // calling the super class constructor (Object class)

		// associate the fields fields with the parameters
		setLength(length);
		setWidth(width);
	}

	// getters (accessors) and setters (mutators)
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0 && length < 20)
			this.length = length;
		else
			this.length = 1.0;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0 && width < 20)
			this.width = width;
		else
			this.width = 1.0;
	}

	// used to display the object's properties
	@Override // preprocessor command --> // overrides the Object class toString
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	// utility methods
	// gets the perimeter of the rectangle
	public double getPerimeter() {
		return (double) 2.0 * (length + width);
	}
	
	// get the area of the rectangle
	public double getArea() {
		return length * width;
	}

}
