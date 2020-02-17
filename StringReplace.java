//replace twitter's downscaled image links with original resolution links

import java.util.Scanner;
import java.util.ArrayList;

public class StringReplace {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> stringSet = new ArrayList<>();
		String replaceInput;
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("")) break;
			replaceInput = input.replaceAll("\\?(.*)", ".jpg:orig");
			//or String replaceInput = input.replaceAll(":large",":orig");
			stringSet.add(replaceInput);
		}
		
		for (int i = 0; i < stringSet.size(); i++) {
			System.out.println(stringSet.get(i));
			if ((i+1)%5 == 0) System.out.println();
		}
		scanner.close();
	}
}
