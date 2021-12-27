/*
 * Name: Barrett Williamson
 * Date: 9/14/2021
 * Course Number: CSC-220-D01
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 6 Assignment 1
 * Email: bawilliamson0001@student.stcc.edu
 * Simplify a fraction using only methods
 */

import java.util.Scanner;

public class SimpleFractions {
	private final static String TITLE = "Reduce Fractions v1";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	private static int gcf(int n1, int n2) {
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		if (n2 == 0) {
			return n1;
		}
		int rem = n1 % n2;
		while (rem != 0) {
			n1 = n2;
			n2 = rem;
			rem = n1 % n2;
		}
		return n2;
	}
	private static String outputFraction(int n1, int n2) {
		String retval = "";
		int n = 0;
		if (n1 > n2) {
			n = (int) Math.floor(n1/n2);
			n1 = n1-(n*n2);
		}
		if (n2 < 0) {
			n1 = -n1;
			n2 = -n2;
		}
		if (n2 == 1) {
			retval = retval + n;
			return retval;
		}if (n == 0) {
			retval = retval + n1 + "/" + n2;
			return retval;
		}else {
			retval = retval + n + " " + n1 + "/" + n2;
			return retval;
		}
	}
	private static int simnum(int x, int y, int gcf) {
		int num = x/gcf;
		return num;
	}
	private static int simden(int x, int y, int gcf) {
		int denom = y/gcf;
		return denom;
	}
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter The Numerator: ");
		int x = input.nextInt();
		System.out.print("Enter The Denominator: ");
		int y = input.nextInt();
		int gcf = gcf(x,y);
		int numerator = simnum(x,y,gcf);
		int denominator = simden(x,y,gcf);
		String Answer = outputFraction(numerator, denominator);
		System.out.println("The Simplified Fraction is: " + Answer);
		input.nextLine();  // Clear the Keyboard
	}
	
	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner input, String prompt) {
		System.out.print(prompt); 
		String doOver = input.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) throws Exception {
		System.out.println("Welcome to " + TITLE);
		Scanner input = new Scanner(System.in);
		do {
			process(input, args);
		} while (doThisAgain(input, CONTINUE_PROMPT));
		input.close();
		System.out.println("Thank you for using " + TITLE);
	}

}
