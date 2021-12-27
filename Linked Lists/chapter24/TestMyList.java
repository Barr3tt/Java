/*
 * Name: Barrett A. Williamson
 * Date: 12/2/2021
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: 10
 * Email: bawilliamson0001@student.stcc.edu
 * Test Class for Linked Lists
 */
package chapter24;

import java.util.Scanner;

public class TestMyList {

	private final static String TITLE = "The Linked List Program ";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// **********************************************
	// Put as many methods you need here

	private static String getFirstCharacter(String str) {
		str = str.trim().toUpperCase();
		return str.isEmpty() ? "" : str.substring(0, 1);
	}

	// **********************************************

	@SuppressWarnings("unchecked")
	private static void process(Scanner sc, String args[]) {
		@SuppressWarnings("rawtypes")
		MyLinkedList list = new MyLinkedList<>();
		System.out.print(
				"Select the following: [A]DD, [R]EMOVE, [P]RINT, [I]NDEX OF, [C]ONTAINS, [G]ET, [L]AST INDEX, [S]ET, [Q]UIT ");
		String x = getFirstCharacter(sc.nextLine());
		while (!x.equals("Q")) {

			switch (x) {
			case "A": {
				System.out.println("What value would you like to add? ");
				var addingValue = sc.nextLine();

				list.add(addingValue);
				break;
			}

			case "P": {

				System.out.println(list);
				break;
			}

			case "R": {
				System.out.println("What value that you would like to remove? ");
				var removedValue = sc.nextLine();
				if (list.contains(removedValue)) {
					list.remove(removedValue);
					System.out.println(removedValue + " Has been removed");
					break;
				}
				System.out.println("This value doesn't exist in the List");
				break;
			}

			case "I": {
				System.out.println("What value would you like to find the index of? ");
				var indexOf = sc.nextLine();
				
					System.out.println("The Index of " + indexOf + " = " + list.indexOf(indexOf));
					break;
				
			}
			case "C": {
				System.out.println("What value do you want to find? ");
				var data2 = sc.nextLine();
				System.out.println(data2 + " is in the Linked List = " + list.contains(data2));
				break;
			}
			case "G": {
				System.out.println("What is the index that you are trying to find? ");
				int indexOfValue = sc.nextInt();
				if (indexOfValue < 0) {
					System.out.println("Use a value above 0");
					break;
				}
				System.out.println("The value at index " + indexOfValue + " = " + list.get(indexOfValue));
				break;
			}
			case "L": {
				System.out.println("What value are you trying to find the last index for?");
				var lastIndexValue = sc.nextLine();
				System.out.println(
						"The last occurence of " + lastIndexValue + " is at index " + list.lastIndexOf(lastIndexValue));
				break;

			}

			case "S": {

				System.out.println(
						"Enter the index and then enter the value with a space in between. (Keep on one line!)");
				int index = sc.nextInt();

				var value = sc.nextLine().trim();
				list.set(index, value);
				break;

			}

			default:
				System.out.println("Invalid letter/word");
				break;
			}

			System.out.println(
					"Select the following: [A]DD, [R]EMOVE, [P]RINT, [I]NDEX OF, [C]ONTAINS, [G]ET, [L]AST INDEX, [S]ET, [Q]UIT ");
			x = getFirstCharacter(sc.nextLine());

		}

	}

	// **********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}

	// **********************************************
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