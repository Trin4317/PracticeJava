/*	Program that asks for books from the user and adds them to a list.
	Modify the program so that books that are already on the list are not added to it again. 
	Two books should be considered the same if they have the same name and publication year.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
	public static ArrayList<Books> addBook() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Books> bookList = new ArrayList<>();
		while (true) {
			System.out.println("Name (empty will stop):");
			String name = scanner.nextLine();
			if (name.isEmpty()) break;
			System.out.println("Publication year:");
			int year = Integer.parseInt(scanner.nextLine());
			Books books = new Books(name,year);
			if (bookList.contains(books)){//using .equals method from Books class
				System.out.println("The book is already on the list. Let's not add the same book again.");
			} else bookList.add(books);
		}
		scanner.close();
		System.out.println("Thank you! Books added: " + bookList.size());
		return bookList;
	}
	public static void main(String[] args) {
		ArrayList<Books> bookList = new ArrayList<>(addBook());
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}
}
