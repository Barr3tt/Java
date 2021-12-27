import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ReadNamesFromURL {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new URL("https://cs.stcc.edu/~silvestri/names/yob2015.txt").openStream());
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