/*
 * Name: Barrett Williamson
 * Date: October 14, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 9
 * Email: bawilliamson0001@student.stcc.edu
 * Tests the shapes
 */

package shapes;

import java.util.Scanner;

public class TestShapes {
	private final static String TITLE = "Test Shapes V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	private static String getFirstCharacter(String str) {
		str = str.trim().toUpperCase();
		return str.isEmpty() ? "" : str.substring(0, 1);
	}
	
	
	//**********************************************
	
	private static void process(Scanner sc, String args[]) {
		System.out.print("Enter Shape to create [C]ircle, [R]ectangle, [T]riangle: ");
		String strShape = getFirstCharacter(sc.nextLine());
		Shape shape = null;
		switch (strShape) {
		case "C": {
			System.out.print("Enter radius: ");
			double radius = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Circle(radius, color, isFilled);
			break;
			}
		case "R": {
			System.out.print("Enter length & width: ");
			double length = sc.nextDouble();
			double width = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Rectangle(length, width, color, isFilled);
			break;
			}
		case "T": {
			System.out.print("Enter length, width & height: ");
			double length = sc.nextDouble();
			double width = sc.nextDouble();
			double height = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Triangle(length, width, height, color, isFilled);
			break;
			}
		default:
			System.out.println("Bad Shape Specified.");
			break;
		}
		if (shape != null) {
			System.out.println(shape);
			System.out.printf("Perimeter = %.2f\n", shape.getPerimeter());
			System.out.printf("Area = %.2f\n", shape.getArea());
		}
	}

	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt); 
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) {
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}

/*
public static void main(String[] args) {
Shape s1 = new Circle(2);
System.out.println("A circle " + s1.toString());
System.out.println("The color is " + s1.getColor());
System.out.println("The area is " + s1.getArea());
System.out.println("The perimeter is " + s1.getPerimeter());
Circle circle = (Circle)s1;
System.out.println("The radius is " + circle.getRadius());
System.out.println("The diameter is " + circle.getDiameter());

Shape s2 = new Rectangle(2, 4);
System.out.println("\nA rectangle " + s2);
System.out.println("The color is " + s2.getColor());
System.out.println("The area is " + s2.getArea());
System.out.println("The perimeter is " + s2.getPerimeter());
Rectangle rect = (Rectangle)s2;
System.out.println("The length is " + rect.getLength());
System.out.println("The diameter is " + rect.getWidth());

//Shape s3 = new Triangle(10, 8, 3);
//System.out.println("\nA triangle " + s3);
//System.out.println("The color is " + s3.getColor());
//System.out.println("The area is " + s3.getArea());
//System.out.println("The perimeter is " + s3.getPerimeter());
//Triangle tri = (Triangle)s3;
//System.out.println("Side 1 is " + tri.getSide1());
//System.out.println("Side 2 is " + tri.getSide2());
//System.out.println("Side 3 is " + tri.getSide3());

Shape s4 = null;
switch ((int)(3 * Math.random())) {
case 0:
	s4 = new Rectangle(2, 4);
	break;
case 1:
	s4 = new Circle(5);
	break;
case 2:
	//s4 = new Triangle(1, 2, 2);
	break;
}

System.out.println(s4);

if (s4 instanceof Circle) {
System.out.println("Diameter " + ((Circle)s4).getDiameter());
}
else
	System.out.println("Not a circle");


  
}
*/