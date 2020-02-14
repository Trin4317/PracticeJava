/*
 Define a method called christmasTree(int height) that prints the correct Christmas tree. 
 The Christmas tree consists of a triangle with the specified height as well as the base. 
 The base is two stars high and three stars wide, and is placed at the center of the triangle's bottom. 
 The tree is to be constructed by using the methods printSpaces and printStars.
 */

import java.util.Scanner;
public class XmasTree {
	public static void printSpace(int n) {
		for (int i = 1 ; i <= (n-1) ; i++) {
				System.out.print(" ");
			}
	}
	public static void printStar(int n,int row) {
		for (int i = (n*2) ; i <= (row*2) ; i++) {
				System.out.print("*");
			}
			System.out.println("");
	}
	public static void christmasTree(int row) {
		for (int n = row; n > 0; n--) {
			printSpace(n);
			printStar(n,row);
		}
		for (int j = 1; j <= 2; j++) {
			for (int i = 1 ; i <= (row-2) ; i++) System.out.print(" ");
			for (int k = 1; k <=3; k++) System.out.print("*");
			System.out.println();
			
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the row: ");
		int row = scanner.nextInt();
		christmasTree(row);		
	}
}
