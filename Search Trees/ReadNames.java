import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadNames {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("yob2015.txt"));
		sc.useDelimiter("\\s*,\\s*|\\s+");
		while (sc.hasNextLine()) {
			String name = sc.next();
			String sex = sc.next();
			int number = sc.nextInt();
			sc.nextLine();
			System.out.printf("%15s%2s%10d\n", name, sex, number);
		}
		sc.close();
	}

}