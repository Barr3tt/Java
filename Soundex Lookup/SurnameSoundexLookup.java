/*
 * Name: Barrett A. Williamson
 * Date: 9/21/2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW3
 * Email: bawilliamson0001@student.stcc.edu
 * Algorithm Description:  
 *    Searching a Database of surnames (lastnames) using Soundex 
 *    Starter Code by Prof. A.C. Silvestri
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import soundex.Soundex;

public class SurnameSoundexLookup {
	private final static String TITLE = "Surname Soundex Lookup System V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	private final static String SURNAME_TEXTFILE = "us.txt";
	
	private static String surNames[];
	private static String soundex[];
	
	//**********************************************
	// Put as many methods you need here
	
	private static int findNumberOfNames(String filename) throws FileNotFoundException {
		File file = new File(filename);
		var input = new Scanner(file);
		var count = 0;
		while (input.hasNextLine()) {
			input.nextLine();
			count++;
		}
		input.close();
		return count;		
	}
	
 	private static void initSoundexDataStructures(String inFileName) throws FileNotFoundException {
		var numberOfNames = findNumberOfNames(SURNAME_TEXTFILE);
		SurnameSoundexLookup.surNames = new String[numberOfNames];
		SurnameSoundexLookup.soundex = new String[numberOfNames];
		
		File inFile = new File(inFileName);
		var input = new Scanner(inFile);
		var count = 0;
		while (input.hasNextLine()) {
			var surName = input.nextLine();
			SurnameSoundexLookup.surNames[count] = surName;
			var soundex = Soundex.soundex(surName);
			SurnameSoundexLookup.soundex[count] = soundex;
			count++;
		}
		input.close();
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
 	
 	private static int linearSearch(String list[], String key) {
 		for (int i = 0; i < list.length; i++)
 			if (list[i].equalsIgnoreCase(key))
 				return i;
 		return -1;
 	}
 	
	private static void outputMatches(String surName, String[] possibleMatches) {
		if (linearSearch(possibleMatches, surName) != -1) {
			System.out.println(surName + " Found in Database");
		}else {
			System.out.println(surName + " Not Found in Database");
		}
		System.out.println("Possible Matches:");
		for (var i = 0; i < possibleMatches.length; i++) {
			System.out.printf(" %s %s\n",i, possibleMatches[i]);
		}
	}	

	//**********************************************
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

	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner input, String prompt) {
		System.out.print(prompt); 
		String doOver = input.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
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
