/* Receive a string input from user then reverse/uppercase/reserve and uppercase the string */
import java.util.Scanner;

public class ModifyAString {
	public static String getString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the string: ");
		String inputString = scanner.nextLine();
		return inputString;
	}
	public static void getResult(String inputString) {
		System.out.println("Convert string to Upper Case:");
		System.out.println(inputString.toUpperCase());
		System.out.println("Reverse the string:");
		for (int i = inputString.length() - 1; i >= 0; i--) {
			System.out.print(inputString.charAt(i));
		}
		System.out.println("\nReverse the string then convert to Upper Case:");
		for (int i = inputString.length() - 1; i >= 0; i--) {
			System.out.print(inputString.toUpperCase().charAt(i));
		}
	}
	public static void main(String[] args) {
		getResult(getString());
		System.out.println("\nEnd of program!");	
	}
}
