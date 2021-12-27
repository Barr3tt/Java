/*
 * Name: Barrett Williamson
 * Date: October 14, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 9
 * Email: bawilliamson0001@student.stcc.edu
 * Circle
 */

package shapes;

public class Circle extends Shape {
	private double radius;

	public Circle() {
		this(1, "white", false);
	}

	public Circle(double radius) {
		this(radius, "white", false);
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		setRadius(radius);
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		if (radius < 0)
			throw new InvalidRadiusException(radius);
		this.radius = radius;
	}

	/** Return area */
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * this.radius;
	}

	/** Return perimeter */
	public double getPerimeter() {
		return 2 * this.radius * Math.PI;
	}

	public String toString() {
		String retval = "";

		retval += "Circle: Radius = " + this.radius + "\n";
		retval += super.toString();

		return retval;
	}
}

@SuppressWarnings("serial")
class InvalidRadiusException extends RuntimeException {
	private double radius;

	/** Construct an exception */
	public InvalidRadiusException(double radius) {
		super("Invalid radius " + radius);
		this.radius = radius;
	}

	/** Return the radius */
	public double getRadius() {
		return radius;
	}
}
