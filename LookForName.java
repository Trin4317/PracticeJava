//The exercise contains a base that asks the user for strings and adds them to a list. 
//The program stops reading when the user enters an empty string.
//The program then prints the Xth element of the list.

import java.util.ArrayList;
import java.util.Scanner;

public class LookForName {
	public static ArrayList<String> inputName() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		while(true) {
			System.out.println("Input names here: (Input nothing to end the loop)");
			String name = scanner.nextLine();
			if (name.equals("")) {
				System.out.println("End of input");
				break;
			} else nameList.add(name);
		}
		System.out.println(nameList.toString());
		return nameList;
	}
	public static void findName(ArrayList<String> nameList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Start looking for index:");
		int index = scanner.nextInt();
		System.out.println(nameList.get(index-1));
	}
	public static void main(String[] args) {
		findName(inputName());
		System.out.println("End of program.");
	}
}
