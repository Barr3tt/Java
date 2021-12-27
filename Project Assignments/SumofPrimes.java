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

public class SumofPrimes {
	private final static String TITLE = "Sum of Special Primes v1";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= (int)Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		return true; 
	}
	public static boolean isSpecial(int n) {
		int reversed = 0, remainder, original;
		original = n;
		while (n != 0) {
	        remainder = n % 10;
	        reversed = reversed * 10 + remainder;
	        n /= 10;
	    }
		if (original == reversed) {
			return false;
		}else {
			if(isPrime(reversed)) {
				return true;
			}else {
				return false;
			}
		}
	}
	public static int findPrimes(int start, int end) {
		int sum=0;
		while (start <= end) {
			if (isPrime(start)) {
				if (isSpecial(start)) {
					sum=sum+start;
				}
			}
			start++;
		}
		return sum;
	}
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter start: ");
		int x = input.nextInt();
		System.out.print("Enter end: ");
		int y = input.nextInt();
		int sum = findPrimes(x,y);
		System.out.println("Sum of Special Primes between " + x +" and " + y +" = " + sum);
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
