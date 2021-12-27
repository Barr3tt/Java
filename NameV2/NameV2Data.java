/*
 * Name: Barrett Williamson
 * Date: November 11, 2021
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms 
 * Problem Number: Chapter 13 HW2
 * Email: bawilliamson0001@student.stcc.edu
 * The Class to grab data for NameClassApp.java
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameV2Data {
	private int startYear;
	private int endYear;
	private int top;

	private TreeMap<String, Integer> boys, girls;

	public NameV2Data(int startYear, int endYear, int top) {
		this.setStartEndYears(startYear, endYear);
		this.setTop(top);
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public int getTop() {
		return top;
	}

	public void setStartEndYears(int startYear, int endYear) {
		if (startYear > endYear)
			throw new NameV2AppException(String.format("StartYear %d must be <= EndYear %d", startYear, endYear));
		if (startYear < 1880)
			throw new NameV2AppException(String.format("The year %d is not accounted for. Must use 1880 or after!", startYear));
		if (endYear > 2020)
			throw new NameV2AppException(String.format("The year %d is not accounted for. Must use 2020 or earlier!", endYear));
		if (this.startYear != startYear) {
			this.startYear = startYear;
			this.boys = this.girls = null;
		}
		if (this.endYear != endYear) {
			this.endYear = endYear;
			this.boys = this.girls = null;
		}

	}

	public void setTop(int top) {
		if (top <= 0)
			throw new NameV2AppException(String.format("Top %d passed must be > 0", top));
		this.top = top;
	}

	private void generateStats() throws MalformedURLException, IOException {
		TreeMap<String, Integer> localBoys = new TreeMap<String, Integer>();
		TreeMap<String, Integer> localGirls = new TreeMap<String, Integer>();

		for (int year = startYear; year <= endYear; year++) {
			if ((year + 1 - startYear) % 10 == 0)
				System.out.println();
			try (Scanner sc = new Scanner(new URL("https://cs.stcc.edu/~silvestri/names/yob" + year + ".txt").openStream())) {
				sc.useDelimiter("\\s*,\\s*|\\s+");
				while (sc.hasNextLine()) {
					String name = sc.next();
					String sex = sc.next();
					int number = sc.nextInt();
					sc.nextLine();
					TreeMap<String, Integer> list = sex.equals("M") ? localBoys : localGirls;
					if (list.containsKey(name))
						list.put(name, (list.get(name).intValue() + number));
					else
						list.put(name, number);
				}
			}
		}
		System.out.println();
		
		this.boys = sortByValues(localBoys);
		this.girls = sortByValues(localGirls);
		
	}

	private ArrayList<NameV2> getTopNames(boolean male) {
		try {
			ArrayList<NameV2> topNames = new ArrayList<>();
			TreeMap<String, Integer> list = male ? this.boys : this.girls;
			if (list == null)
				this.generateStats();
			list = male ? this.boys : this.girls;
			
			int count = 0;
			for (Map.Entry<String, Integer> entry : list.entrySet()) {
				String key = entry.getKey();
                Integer value = entry.getValue();
                if (count >= top)
                	break;
                topNames.add(new NameV2(key, value));
                count++;
			}
			
			return topNames;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ArrayList<NameV2> getTopMaleNames() {
		return getTopNames(true);
	}

	public ArrayList<NameV2> getTopFemaleNames() {
		return getTopNames(false);
	}
	
	private static <K, V extends Comparable<V>> TreeMap<K, V> sortByValues(Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				return -compare;
			}
		};
		
		TreeMap<K, V> sortedByValues = new TreeMap<>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
	
}