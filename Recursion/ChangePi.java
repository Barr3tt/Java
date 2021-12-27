/*
 * Name: Barrett Williamson
 * Date: 9/14/2021
 * Course Number: CSC-220-D01
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 18
 * Email: bawilliamson0001@student.stcc.edu
 * Change the word 'pi' to 3.14 in a string
 */

import java.util.Scanner;

public class ChangePi {
	private final static String TITLE = "Change Pi";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	public static String changePi(String str) {
	    if(str.length() <= 1) return str;
	    if(str.substring(0, 2).equals("pi")) return "3.14" + changePi(str.substring(2));
	    return str.charAt(0) + changePi(str.substring(1));
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
				
		// Following code is merely a sample, delete it
		System.out.print("Enter a String to Change Pi: ");
		String x = input.nextLine();
		System.out.println("Processing " + x + " ...");
		String a = changePi(x);
		System.out.println("The new String is: \n" + a);
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
