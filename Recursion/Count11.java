/*
 * Name: Barrett Williamson
 * Date: 9/14/2021
 * Course Number: CSC-220-D01
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 18
 * Email: bawilliamson0001@student.stcc.edu
 * Count the Number of 11s in a String
 */

import java.util.Scanner;

public class Count11 {
	private final static String TITLE = "Count11";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	public static int count11(String str) {
	    if(str.length() <= 1) return 0;
	    if(str.substring(0, 2).equals("11")) return 1 + count11(str.substring(2));
	    return count11(str.substring(1));
	}

	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter a String to count all the 11s: ");
		String x = input.nextLine();
		System.out.println("Processing " + x + " ...");
		int a = count11(x);
		System.out.println("There are " + a + " 11s!");
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
