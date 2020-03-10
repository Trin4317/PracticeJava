//Implement linear search and binary search algorithms for searching for books by their numeric id

import java.util.ArrayList;
import java.util.Collections;
public class Searching {
	public static int linearSearch(ArrayList<Book> books,int searchID) {
		for (Book b:books) {
			System.out.println(b);
		}
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == searchID) {
				return i;
			}
		}
		return -1;
	}
	public static int binarySearch(ArrayList<Book> books,long searchID) {//the list must be in order
		Collections.sort(books);//Collections.sort() will call the overwritten compareTo() method
		for (Book b:books) {
			System.out.println(b);
		}
		int begin = 0;
		int end = books.size() - 1;
		while (!(begin > end)) {
			int middle = (begin + end) / 2;
			if (books.get(middle).getId() == searchID) {
				return middle;
			}
			if (books.get(middle).getId() < searchID) {
				begin = middle + 1;
			}
			if (books.get(middle).getId() > searchID) {
				end = middle - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book(500,"Elderberry"));
		books.add(new Book(200,"Banana"));
		books.add(new Book(600,"Fig"));
		books.add(new Book(100,"Apple"));
		books.add(new Book(300,"Citrus"));
		books.add(new Book(700,"Grape"));
		books.add(new Book(400,"Durian"));
		
		int index = linearSearch(books,300);
		System.out.println("[linearSearch] Result for ID 300 found at index #" + (index == -1? "No result" : index + 1));
		
		System.out.println();
		int index2 = binarySearch(books,600);
		System.out.println("[binarySearch] Result for ID 600 found at index #" + (index2 == -1? "No result" : index2 + 1));
	}
}
