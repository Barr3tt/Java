/*
 * Name: Barrett Williamson
 * Date: November 5, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 13 HW1
 * Email: bawilliamson0001@student.stcc.edu
 * The Name Exception Class for NameClassTesterApp.java
 */
public class NameAppException extends RuntimeException {
	private static final long serialVersionUID = 1L;	
	public NameAppException(String desc) {
		super(desc);
	}
}