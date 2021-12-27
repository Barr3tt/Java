/*
 * Name: Barrett Williamson
 * Date: November 11, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 13 HW2
 * Email: bawilliamson0001@student.stcc.edu
 * The NameV2 Class for NameClassApp.java
 */
public class NameV2 implements Comparable<NameV2> {
	private String name;
	private int number;
	
	public NameV2(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public void addToNumber(int number) {
		this.number += number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameV2 other = (NameV2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%15s %,10d", this.name, this.number);
	}

	@Override
	public int compareTo(NameV2 arg) {
		if (this.number < arg.number) 
			return 1;
		if (this.number > arg.number)
			return -1;
		if (this.name.compareTo(arg.name) < 0)
			return -1;
		if (this.name.compareTo(arg.name) > 0)
			return 1;
		return 0;
	}
	
}