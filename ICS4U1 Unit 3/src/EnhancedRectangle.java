
public class EnhancedRectangle {
	
	private Point [] corners;
	
	public EnhancedRectangle(Point [] corners) {
		this.corners = corners;
		for(int i = 0; i < corners.length; i++) {
			setPoint(corners[i], i);
		}
	}

	public void setPoint(Point corner, int num) {
		if (corner.getX() <= 0 || corner.getX() >= 20)
			corner.setX(1.0);
		if (corner.getY() <= 0 || corner.getY() >= 20)
			corner.setY(1.0);
		corners[num] = corner;
	}
	public double distanceTo(Point point1, Point point2) {
		return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + 
				Math.pow(point1.getY() - point2.getY(), 2));
	}

	public boolean verifyRectangle() {
		// two diagonals must be equal
		if(distanceTo(corners[0], corners[2]) == distanceTo(corners[1], corners[3]))
			return true;
		else 
			return false;
			
	}
	
	public boolean isSquare() {
		if (distanceTo(corners[0], corners[1]) == distanceTo(corners[1], corners[2]))
			return true;
		return false;
	}
	
	public double getLength() {
		return Math.max(distanceTo(corners[0], corners[1]), distanceTo(corners[1], corners[2]));
	}
	
	public double getWidth() {
		return Math.min(distanceTo(corners[0], corners[1]), distanceTo(corners[1], corners[2]));
	}
	
	public double getArea() {
		return getLength() * getWidth();
	}
	
	public double getPerimeter() {
		return 2 * (getLength() + getWidth());
	}
	
}
