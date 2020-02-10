import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Input year: ");
			int yr = scanner.nextInt();
			if ((yr % 100 != 0 && yr % 4 == 0) || (yr % 400 == 0)){
				System.out.println(yr + " is a leap year");
			} else System.out.println(yr + " is not a leap year");
			System.out.println("Do you want to try again: ");
			char a = scanner.next().charAt(0);
			if (a == 'n') {
				System.out.println("Goodbye!");
				break;
			}
		}
	}
}