/*
 A simple calculator that can receive 2 different values from user and calculate the result based on desirable function
*/
import java.util.Scanner;

public class Calculator {
	public static void introCal() {
		System.out.println("Welcome to Calculator 1.0");
		System.out.println("=========================");
		System.out.println("Please choose one function");
		System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
	}
	public static void funcCal() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true) {
			do {
				System.out.println("Input your choice: ");
				choice = scanner.nextInt();
			} while (choice > 4);
			
			System.out.println("Input your first number: ");
			int num1 = scanner.nextInt();
			System.out.println("Input your second number: ");
			int num2 = scanner.nextInt();
			
			switch(choice) {
			case 1: addCal(num1,num2);break;
			case 2: subCal(num1,num2);break;
			case 3: mulCal(num1,num2);break;
			case 4: divCal(num1,num2);break;
			
			}
			System.out.println("Do you want to continue? ");
			char cont = scanner.next().charAt(0);
			if (cont == 'n') {
				System.out.println("Goodbye!");
				break;
			}
		} 
	}
	public static void addCal(int a,int b) {
		System.out.println("Your result is " + (a+b));
	}
	public static void subCal(int a,int b) {
		System.out.println("Your result is " + (a-b));
	}
	public static void mulCal(int a,int b) {
		System.out.println("Your result is " + (a*b));
	}
	public static void divCal(double a,double b) {
		System.out.println(String.format("Your result is %5.2f", a/b));
	}
	public static void main(String[] args) {
		introCal();
		funcCal();
	}
}
