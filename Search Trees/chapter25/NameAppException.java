/*
 * Name:  Prof. Antonio C. Silvestri (STCC)
 * Date:  10/26/2020
 * Course Number:  CSC-220
 * Course Name:  Data Structures and Algorithms
 * Problem Number: HW8
 * Email:  silvestri@stcc.edu
 * Description:  Dedicated Exception Class to Support Application 
 */

package chapter25;

@SuppressWarnings("serial")
public class NameAppException extends RuntimeException {

	public NameAppException(String message) {
		super(message);
	}

}
