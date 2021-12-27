/*
 * Name: Barrett Williamson
 * Date: October 14, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 9
 * Email: bawilliamson0001@student.stcc.edu
 * The Triangle Class using Shapes.java
 */
package shapes;

public class Triangle extends Shape {
  private double side1;
  private double side2;
  private double side3;
  
  public Triangle() {
  }

  public Triangle(double side1, double side2, double side3) {
    this(side1, side2, side3, "white", false);
  }

  public Triangle(double side1, double side2, double side3, String color, boolean filled) {
	super(color, filled);
    this.side2 = side2;
    this.side1 = side1;
    this.side3 = side3;
  }

  /** Return side2 */
  public double getside2() {
    return side2;
  }

  /** Set a new side2 */
  public void setside2(double side2) {
    this.side2 = side2;
  }

  /** Return side1 */
  public double getside1() {
    return side1;
  }
  
  /** Set a new side1 */
  public void setside1(double side1) {
	 this.side1 = side1;
  }
  
  /** Return side3 */
  public double getside3() {
    return side3;
  }
  
  /** Set a new side3 */
  public void setside3(double side3) {
    this.side1 = side3;
  }

  /** Return area */
  public double getArea() {
    return (this.side2 * this.side3)/2;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return (side2 + side1 + side3);
  }
  
  public String toString() {
	  return "Triangle: " + "Side1: " + this.side1 + ", Side2: " + this.side2 + ", Side3: " + this.side3 + "\n" +
             super.toString();
  }
}
