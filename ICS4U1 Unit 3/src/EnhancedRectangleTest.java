
public class EnhancedRectangleTest {

	public static void main(String[] args) {
		Point [] corners = {new Point(1.0,1.0), 
				new Point(1.0,2.0),
				new Point(2.0,2.0),
				new Point(2.0,1.0)};
		EnhancedRectangle rectangle = new EnhancedRectangle(corners);

		System.out.printf("Length: %.1f units\nWidth: %.1f units\nArea: %.1f units^2\nPerimeter: %.1f units",
				rectangle.getLength(), rectangle.getWidth(), rectangle.getArea(), rectangle.getPerimeter());
	}

}
