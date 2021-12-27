/*
 * Name: Barrett Williamson
 * Date: October 14, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 9
 * Email: bawilliamson0001@student.stcc.edu
 * Plays TicTacToe using PlayTicTacToe.java
 */

package tictactoe;

import java.util.Arrays;

public class TicTacToe {
	private char[][] board;
	private int turns = 0;
	private int[][] winningRow; 

	public TicTacToe() {
		board = new char[3][3];
		for (char[] row : board)
			Arrays.fill(row, ' ');
	}

	public int getTurns() {
		return turns;
	}

	public char playerAt(int r, int c) {
		return board[r][c];
	}

	public int[][] getWinningRow() {
		return winningRow;
	}

	@Override
	public String toString() {
		String output = "";
		for (char[] y : board) {
			output += "+---+---+---+\n";
			for (char x : y)
				output += "| " + x + " ";
			output += "|\n";
		}
		return output += "+---+---+---+";
	}

	public boolean isTied(char p1, char p2) {
		return isFull() && !isWinner(p1) && !isWinner(p2);
	}

	public boolean isWinner(char p) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == p ) {
				winningRow = new int[][] { { i, 0 }, { i, 1 }, { i, 2 } };
				return true;
			}
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == p) {
				winningRow = new int[][] { { 0, i }, { 1, i }, { 2, i } };
				return true;
			}
		}
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == p) {
			winningRow = new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 } };
			return true;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == p) {
			winningRow = new int[][] { { 0, 2 }, { 1, 1 }, { 2, 0 } };
			return true;
		}
		return false;
	}

	public boolean isFull() {
		return turns == 9;
	}

	public boolean isValid(int r, int c) {
		return r < 3 && r >= 0 && c < 3 && c >= 0;
	}

	public void playMove(char p, int r, int c) {
		board[r][c] = p;
		turns++;
	}

}