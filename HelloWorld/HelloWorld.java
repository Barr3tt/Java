/*
 * Name: Barrett Williamson
 * Date: 9/14/2021
 * Course Number: CSC-220-D01
 * Course Name: Data Structures and Algorithms
 * Problem Number:
 * Email: bawilliamson0001@student.stcc.edu
 * Short Description of the Problem
 */

import java.util.Scanner;

public class HelloWorld {
	private final static String TITLE = "CSC111 Project Template";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
				
		// Following code is merely a sample, delete it
		System.out.print("Enter value: ");
		int x = input.nextInt();
		System.out.println("Processing " + x + " ...");
		
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
