/*
 * Name:  Prof. Antonio C. Silvestri (STCC)
 * Date:  10/24/2020
 * Course Number:  CSC-220
 * Course Name:  Data Structures and Algorithms
 * Problem Number: HW6
 * Email:  silvestri@stcc.edu
 * Description:  Names Class Driver/Tester
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameClassTesterApp {
	private static final String TITLE = "Name Class Driver/Tester V1.0";
	private static final String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// **********************************************

	private static String getFirstCharacter(String str) {
		str = str.trim().toUpperCase();
		return str.isEmpty() ? "" : str.substring(0, 1);
	}
	
	// **********************************************

	private static void process(Scanner sc, String args[]) {
		try {
			ArrayList<Name> people = new ArrayList<>();
			while (true) {
				System.out.print("Enter [A]dd Name, [P]rint List, or [T]erminate List Processing: ");
				String strShape = getFirstCharacter(sc.nextLine());
				switch (strShape) {
				case "A": {
					System.out.println("Add a Name to List");
					System.out.print("Enter name sex number (space separated): ");
					String name = sc.next();
					String sex = sc.next();
					int number = sc.nextInt();
					sc.nextLine();
					Name person = new Name(name, sex, number);
					int index = people.indexOf(person);
					if (index == -1)
						people.add(person);
					else
						people.get(index).addToNumber(person.getNumber());
					break;
					}
				case "P": {
					System.out.println("Print the List");
					Collections.sort(people);
					System.out.println(people);
					break;
					}
				case "T": {
					System.out.println("Terminating List Processing");
					break;
					}
				default:
					System.out.println("Bad Option Specified.");
					break;
				}
				if (strShape.equals("T"))
					break;
			}

		} 
		catch (NameAppException ex) {
			System.out.println("Name Exception: " + ex.getMessage());
		}
		catch (Exception ex) {
			ex.printStackTrace();
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