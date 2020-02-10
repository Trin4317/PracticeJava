//making multiplication table using StringFormat

import java.util.Scanner;

public class StringFormat {
	public static String padLeft(int d, int n) {
		return String.format( "%" + n + "d", d);
	}
	public static void mulTable(int row, int coefficient) {
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= coefficient; j++ ) {
				int k = i*j;
				if (row < 10) {
					if (j != 1) System.out.print(padLeft(k,2) + " ");
					else if (j == 1) System.out.print(padLeft(k,1) + " ");
				} else if (row >= 10){
					if (j != 1) System.out.print(padLeft(k,3) + " ");
					else if (j == 1) System.out.print(padLeft(k,2) + " ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    while(true) {
	    	System.out.println("Input the number of row less than 100: ");
		    int a = scanner.nextInt();
		    System.out.println("Input the coefficient from 1 to 9: ");
		    int b = scanner.nextInt();
		    mulTable(a,b);
		    System.out.println("Try again? ");
		    char c = scanner.next().charAt(0);
		    if (c == 'n') break;
	    } 
	    System.out.println("Goodbye!");
	}
}
