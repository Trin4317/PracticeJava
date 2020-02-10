/*
 Value of gift	Tax at the lower limit	Tax rate(%) for exceeding part
5 000 — 25 000			100					8
25 000 — 55 000	 		1 700				10
55 000 — 200 000		4 700				12
200 000 — 1 000 000		22 100				15
1 000 000 —				142 100				17

For example 6000€ gift implies 180€ of gift tax (100 + (6000-5000)*0.08), 
and 75000€ gift implies 7100€ of gift tax (4700 + (75000-55000) * 0.12).

*/
import java.util.Scanner;

public class GiftTax {
	static double calTax(int a) {
		int vl = a;
		double tax;
		if (vl < 5000) {
			tax = 0;
		} else if (vl < 25000) {
			tax = 100 + (vl - 5000)*0.08;
		} else if (vl < 55000) {
			tax = 1700 + (vl - 25000)*0.1;
		} else if (vl < 200000) {
			tax = 4700 + (vl - 55000)*0.12;
		} else if (vl < 1000000) {
			tax = 22100 + (vl - 200000)*0.15;
		} else {
			tax = 142100 + (vl - 1000000)*0.17;
		}
		return tax;
	}
	static void prtTax(double a) {
		double tax = a;
		if (tax != 0) System.out.println("Tax is " + tax);
		else System.out.println("No tax.");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the value of gift: ");
		int vl = scanner.nextInt();
		double tax = calTax(vl);
		prtTax(tax);
	}
}

 