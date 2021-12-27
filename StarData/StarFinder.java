/*
 * Name: Barrett Williamson
 * Date: 9/14/2021
 * Course Number: CSC-220-D01
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 8 HW
 * Email: bawilliamson0001@student.stcc.edu
 * Displays possible star locations based on given information
 */

import java.net.URL;
import java.util.Scanner;

public class StarFinder {
	private final static String TITLE = "Star Finder V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	static String chooseStarData(Scanner sc) {
		System.out.println("Which Star Data would you like to display? (1-4)");
		String c = null;
		while (c == null) {
			int n = sc.nextInt();
			switch(n) {
				case 1: c = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData1.txt";
					break;
				case 2: c = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData2.txt";
					break;
				case 3: c = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData3.txt";
					break;
				case 4: c = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData4.txt";
					break;
				default: System.out.println("Must be a number between 1 and 4"); c = null;
					break;
			}
			sc.nextLine();
		} 
		return c;
	}
	
	static int[][] readStarData(Scanner sc) {
		int y = sc.nextInt();
		int x = sc.nextInt();
		int [][] data = new int[y][x];
		for (int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				data[row][col] = sc.nextInt();	
			}
		}
		sc.close();
		return data;
	}
	//if:  (array[i][j] + sum of the 8 surrounding intensities)/5 > 6.0
	static char[][] analyzeStarData(int stardata[][]){
		int x = 0;
		char[][] chart = new char[stardata.length][stardata[0].length];
		for (int row = 0; row < stardata.length; row++) {
			for(int col = 0; col < stardata[row].length; col++) {
				int result = 0;
				if(col > 0)
	                result += stardata[row][col-1];
	            if(col < stardata[row].length - 1)
	                result += stardata[row][col+1];
	            if(row > 0)
	                result += stardata[row-1][col];
	            if(row > 0 && col > 0)
	                result += stardata[row-1][col-1];
	            if(row > 0 && col < stardata[row].length - 1)
	                result += stardata[row-1][col+1];
	            if(col > 0 && row < stardata.length -1)
	                result += stardata[row+1][col-1];
	            if(col < stardata[row].length - 1 && row < stardata.length -1)
	                result += stardata[row+1][col+1];
	            if(row < stardata.length -1)
	                result += stardata[row+1][col];
				x = result;
				if ((((stardata[row][col] + x) /5) > 6) && (row > 0) && (col > 0)  && (row < stardata.length-1) && (col < stardata[row].length-1)){
					chart[row][col] = '*';
				}
				else
					chart[row][col] = ' ';
				}
			}	
		return chart;
	}
	
	static void outputStarData(char pattern[][]) {
		for (int row = 0; row < pattern.length; row++) {
			System.out.println("");
		    for (int printrow = 0; printrow < pattern[row].length; printrow++){
		    	System.out.print("+---");
		    }
		    System.out.println("");
			for(int col = 0; col < pattern[row].length; col++) {
				System.out.print("| ");
				System.out.print(pattern[row][col]+" ");
			}
		}
		System.out.println();
	}

	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		String file = chooseStarData(input);
		var url = new URL(file);
		var inputf = new Scanner(url.openStream());
		int[][] star = readStarData(inputf);
		char[][] chart = analyzeStarData(star);
		outputStarData(chart);
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
