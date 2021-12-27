/*
 * Name: Barrett A. Williamson
 * Date: 9/29/2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW3
 * Email: bawilliamson0001@student.stcc.edu
 * Algorithm Description:  
 *    Searching a Database of surnames (lastnames) using Soundex
 *    This version reads a file off a webserver 
 *    Shows Comparison of linear search and binary search
 *    Shows Selection Search
 *    Starter Code by Prof. A.C. Silvestri
 */

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import soundex.Soundex;

public class SurnameSoundexLookup2 {
	private final static String TITLE = "Surname Soundex Lookup System V2.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	private final static String SURNAME_TEXTFILE = "https://cs.stcc.edu/~silvestri/csc220/us.txt";

	private static String surNames[];
	private static String soundex[];

	// **********************************************
	// Put as many methods you need here

	private static int findNumberOfNames(String filename) throws IOException {
		var url = new URL(filename);
		var input = new Scanner(url.openStream());
		var count = 0;
		while (input.hasNextLine()) {
			input.nextLine();
			count++;
		}
		input.close();
		return count;
	}

	private static void initSoundexDataStructures(String inFileName) throws IOException {
		var numberOfNames = findNumberOfNames(SURNAME_TEXTFILE);
		SurnameSoundexLookup2.surNames = new String[numberOfNames];
		SurnameSoundexLookup2.soundex = new String[numberOfNames];

		var url = new URL(inFileName);
		var input = new Scanner(url.openStream());
		var count = 0;
		while (input.hasNextLine()) {
			var surName = input.nextLine();
			SurnameSoundexLookup2.surNames[count] = surName;
			var soundex = Soundex.soundex(surName);
			SurnameSoundexLookup2.soundex[count] = soundex;
			count++;
		}
		input.close();
	}

	// See Animation Page for How binary Search Works
	// http://liveexample.pearsoncmg.com/liang/animation/animation.html
	private static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;
		}

		return -low - 1; // Now high < low
	}

	private static int binarySearch(String[] list, String key) {
		int low = 0;
		int high = list.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key.compareToIgnoreCase(list[mid]) < 0)
				high = mid - 1;
			else if (key.compareToIgnoreCase(list[mid]) == 0)
				return mid;
			else
				low = mid + 1;
		}

		return -low - 1; // Now high < low
	}

	private static int linearSearch(String[] list, String key) {
		for (int i = 0; i < list.length; i++) {
			if (key.compareToIgnoreCase(list[i]) == 0)
				return i;
		}
		return -1;
	}
	
	// See Animation for How SelectionSort Works
	// http://liveexample.pearsoncmg.com/liang/animation/animation.html
	private static void sortBySoundex(String surNames[], String[] soundex) {
		for (int i = 0; i < soundex.length - 1; i++) {
			String min = soundex[i];
			int minIndex = i;
			for (int j = i + 1; j < soundex.length; j++)
				if (soundex[j].compareToIgnoreCase(min) < 0) {
					min = soundex[j];
					minIndex = j;
				}
			if (minIndex != i) {
				soundex[minIndex] = soundex[i];
				soundex[i] = min;
				String temp = surNames[minIndex];
				surNames[minIndex] = surNames[i];
				surNames[i] = temp;
			}
		}
	}

	private static String[] possibleMatches(String surName) {
		var tmpsurNamesPossible = new String[100_000];
 		var surNameSoundex = Soundex.soundex(surName);
		var count = 0;
		for (var i = 0; i < soundex.length; i++) {
			if(soundex[i].equals(surNameSoundex)) {
				tmpsurNamesPossible[count] = surNames[i];
				count++;
			}
		}
		var surNamesPossible = new String[count];
		System.arraycopy(tmpsurNamesPossible, 0, surNamesPossible, 0, count);
		
 		return surNamesPossible;
	}

	private static void outputMatches(String surName, String[] possibleMatches) {
		// Output All possible Matches
		// Also output if surName is in the database exactly
		{
			long start = System.nanoTime();
			if (binarySearch(surNames, surName) >= 0)
				System.out.println(surName + " is found");
			else
				System.out.println(surName + " is NOT found");
			long end = System.nanoTime();
			System.out.println(end - start);
		}

		{
			long start = System.nanoTime();
			if (linearSearch(surNames, surName) >= 0)
				System.out.println(surName + " is found");
			else
				System.out.println(surName + " is NOT found");
			long end = System.nanoTime();
			System.out.println(end - start);
		}
		
		String copyOfSurNames[] = Arrays.copyOf(surNames, surNames.length);
		String copyOfSoundex[] = Arrays.copyOf(soundex, soundex.length);
		sortBySoundex(copyOfSurNames, copyOfSoundex);
		for (int i = 0; i < surNames.length; i++) {
			System.out.printf("%-20s%s\n", copyOfSurNames[i], copyOfSoundex[i]);
		}

	}

	// **********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter Surname: ");
		var surName = input.nextLine();
		var possibleMatches = possibleMatches(surName);
		outputMatches(surName, possibleMatches);
	}

	private static void preProcess(Scanner input, String[] args) throws Exception {
		initSoundexDataStructures(SURNAME_TEXTFILE);
	}

	// **********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner input, String prompt) {
		System.out.print(prompt);
		String doOver = input.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}

	// **********************************************
	// Do not change the main method (Well maybe a little. :-))
	public static void main(String args[]) throws Exception {
		System.out.println("Welcome to " + TITLE);
		Scanner input = new Scanner(System.in);
		preProcess(input, args);
		do {
			process(input, args);
		} while (doThisAgain(input, CONTINUE_PROMPT));
		input.close();
		System.out.println("Thank you for using " + TITLE);
	}

}
