/*
 * Name: Tony Silvestri
 * Date: 09/23/2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW4
 * Email: silvestri@stcc.edu
 * Algorithm Description:
 * Implements Soundex Algorithm described here:
 * https://web.stanford.edu/class/archive/cs/cs106b/cs106b.1208/assignments/assign1/soundex
 * Sample Starter Code
 */

package soundex;

public class Soundex {
	private static char[] discardAllNonLetters(char[] chars) {
		int count = 0;
	    for (int i = 0; i < chars.length; i++) {
	    	if (Character.isLetter(chars[i])) {
	    		chars[count] = chars[i];
	    		count++;
	    	} 
	    } 
	    char[] al = new char[count];
	    System.arraycopy(chars, 0, al, 0, count);
	    return al;
	  }
	
	private static char[] encodeEachLetterAsDigit(char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if ("AEIOUHWY".indexOf(chars[i]) != -1) {
		    	chars[i] = '0';
		    } else if ("BFPV".indexOf(chars[i]) != -1) {
		        chars[i] = '1';
		    } else if ("CGJKQSXZ".indexOf(chars[i]) != -1) {
		        chars[i] = '2';
		    } else if ("DT".indexOf(chars[i]) != -1) {
		        chars[i] = '3';
		    } else if ("L".indexOf(chars[i]) != -1) {
		        chars[i] = '4';
		    } else if ("MN".indexOf(chars[i]) != -1) {
		        chars[i] = '5';
		    } else {
		    	chars[i] = '6';
		    } 
		} 
		return chars;
	}

	private static char[] removeDuplicateRepeatingDigits(char[] chars) {
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != chars[count-1]) {
				chars[count] = chars[i];
				count++;				
			}
		}
		char[] temp = new char[count];
		System.arraycopy(chars, 0, temp, 0, count);
		return temp;
	}	
	
	private static char[] removeAllZeros(char[] chars) {
		int count = 0;
	    for (int i = 0; i < chars.length; i++) {
	    	if (chars[i] != '0') {
	    		chars[count] = chars[i];
	    		count++;
	    	} 
	    } 
	    char[] noz = new char[count];
	    System.arraycopy(chars, 0, noz, 0, count);
	    return noz;
	}

	private static char[] makeCodeExactlyLengthN(char[] chars, int n) {
		char[] charsl = new char[n];
	    int i;
	    for (i = 0; i < ((chars.length >= n) ? n : chars.length); i++)
	    	charsl[i] = chars[i]; 
	    for (i = chars.length; i < n; i++)
	    	charsl[i] = '0'; 
	    return charsl;
	}	
	
	public static String soundex(String str) {
		str = str.toUpperCase();
		char chars[] = str.toCharArray();
	
		// Step 1: Discard all non-letter characters
		chars = discardAllNonLetters(chars);
		if (chars.length == 0)
			return "0000";
		
		// Step 2: Encode each letter as a digit 
		chars = encodeEachLetterAsDigit(chars);
		
		// Step 3: Coalesce adjacent duplicate digits from code (e.g. 222025 becomes 2025)
		chars = removeDuplicateRepeatingDigits(chars);
				
		// Step 4: Replace the first digit of code with the first letter of the original name
		chars[0] = str.charAt(0);
		
		// Step 5: Remove all zeros from code
		chars = removeAllZeros(chars);

		// Step 6: Make the code exactly length 4 by padding with zeros or truncating the excess
		chars = makeCodeExactlyLengthN(chars, 4);
		
		String code = new String(chars);
		return code;
	}	

}
