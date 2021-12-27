/*
 * Name: Antonio Silvestri
 * Date: 10/1/2018
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: HW4
 * Email: silvestri@stcc.edu
 * Main Program to Drive TicTacToe Class
 */

package tictactoe;

import java.util.Scanner;

import TicTacToe;

public class PlayTicTacToe {

	private static void playGame(Scanner keyboard) {

		char p = 'X';
		TicTacToe ttt = new TicTacToe();
		int r, c;

		do {
			System.out.println(ttt);
			do {
				System.out.print("'" + p + "', choose your location (row, column): ");
				try {
					r = keyboard.nextInt();
					c = keyboard.nextInt();
					if (!ttt.isValid(r, c))
						System.out.println("That is not a valid location. Try again.");
					else if (ttt.playerAt(r, c) != ' ')
						System.out.println("That location is already full. Try again.");
					else
						break;
				}
				catch (Exception e) {
					System.out.println("Bad Integer Entered. Try Again.");
					keyboard.nextLine();  //IMPORTANT! Clear keyboard!!!
				}
			} while (true);

			ttt.playMove(p, r, c);

			if (p == 'X')
				p = 'O';
			else
				p = 'X';

		} while (!ttt.isWinner('X') && !ttt.isWinner('O') && !ttt.isFull());

		System.out.println(ttt);
		
		String status;
		if (ttt.isWinner('X'))
			status = "X is the winner!";
		else if (ttt.isWinner('O'))
			status = "O is the winner!";
		else
			status = "The game is a tie.";
		status += " After " + ttt.getTurns() + " plays.";
		System.out.println(status);
	}

	// **********************************************

	private static void process(Scanner sc, String args[]) {
		playGame(sc);
		sc.nextLine(); // IMPORTANT!! Reset Scanner
	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}

	// **********************************************

	public static void main(String args[]) {
		final String TITLE = "Play Tic Tac Toe V1.0";
		final String CONTINUE_PROMPT = "Play again? [y/N] ";

		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}