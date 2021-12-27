/*
 * Name: Barrett Williamson
 * Date: November 11, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 13 HW1
 * Email: bawilliamson0001@student.stcc.edu
 * The NameClassApp.java
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NameClassApp {

	private static void outputNames(ArrayList<NameV2> list, String header) {
		System.out.println(header);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%3d. %s\n", i + 1, list.get(i));
		}
		System.out.println();
	}
	
	private static int[] getStartAndFinalYears(Scanner sc) {
		do {
			try {
				System.out.print("Enter Start Year: ");
				int startYear = sc.nextInt();
				System.out.print("Enter Final Year: ");
				int endYear = sc.nextInt();
				return new int[] {startYear, endYear};
			} catch (InputMismatchException ex) {
				System.out.println("Years must be integers!");
			} finally {
				sc.nextLine();
			}
		} while (true);
	}

	private static int getTopNoOfNames(Scanner sc) {
		do {
			try {
				System.out.print("Number of Names: ");
				int top = sc.nextInt();
				return top;
			} catch (InputMismatchException ex) {
				System.out.println("Number of Names must be a number!");
			} finally {
				sc.nextLine();
			}
		} while (true);
	}

	private static void process(Scanner sc, String args[]) {
		try {
			int years[] = getStartAndFinalYears(sc);
			int top = getTopNoOfNames(sc);
			System.out.println("Searching!");
			NameV2Data stats = new NameV2Data(years[0], years[1], top);
			ArrayList<NameV2> topBoys = stats.getTopMaleNames();
			outputNames(topBoys, "Top " + top + " Boy Names");
			ArrayList<NameV2> topGirls = stats.getTopFemaleNames();
			outputNames(topGirls, "Top " + top + " Girl Names");
		} 
		catch (NameV2AppException ex) {
			System.out.println("NameV2 Exception: " + ex.getMessage());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}

	public static void main(String args[]) {
		final String TITLE = "Name Application V2";
		final String CONTINUE_PROMPT = "Do this again? [y/N] ";

		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}