import java.util.Scanner;
public class FizzBuzz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("Input a number: ");
		int a = scanner.nextInt();
		if (a % 3 == 0) System.out.print("Fizz");
		if (a % 5 == 0) System.out.print("Buzz");
		System.out.println("\nDo you want to try again: ");
		char b = scanner.next().charAt(0);
		if (b == 'n') {
			System.out.println("Goodbye!");
			break;
			}
		}
	}
				
}
