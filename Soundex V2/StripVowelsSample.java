/*
 * Name: Tony Silvestri
 * Date: 09/23/2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: ???
 * Email: silvestri@stcc.edu
 * Algorithm Description:
 * Just some typical array processing code whose pattern is useful 
 * for the Soundex Algorithm
 */

import java.util.Scanner;

public class StripVowelsSample {
	private final static String TITLE = "Strip Vowels Sample Code V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	private static char[] removeVowels(char[] chars) {
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if ("AEIOU".indexOf(chars[i]) == -1) {
				chars[count] = chars[i];
				count++;
			}			
		}
		char[] temp = new char[count];
		System.arraycopy(chars, 0, temp, 0, count);
		return temp;
	}	
	
	
	private static String removeVowels(String str) {
		str = str.toUpperCase();
		char chars[] = str.toCharArray();
	
		chars = removeVowels(chars);
		
		String code = new String(chars);
		return code;
	}	


	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter string: ");
		var str = input.nextLine();
		var code = removeVowels(str);
		System.out.println("No Vowel String: " + code);
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
