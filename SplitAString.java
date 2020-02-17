/*Write a program that reads user input until an empty line. 
For each non-empty string, the program splits the string by spaces  
and then prints the pieces that contain av, each on a new line.
For example: 	java is a programming language >> java
				navy blue shirt >> navy
*/

import java.util.*;
public class SplitAString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Your input: ");
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("")) break;
			String[] readinput = input.split(" ");
			for (int i = 0; i < readinput.length; i++) {
				if (readinput[i].contains("av")) System.out.println(readinput[i]);
			}
		}
		System.out.println("End!");
	}
}
