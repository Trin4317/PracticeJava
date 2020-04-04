import java.nio.file.*;
import java.util.*;

public class BookFromFile {
	public static List<Book> readBook(String filename){
		List<Book> bookList = new ArrayList<>();
		try{
			//lines() method in Files class creates an input stream from a file, processes the rows one by one
			//get() method in Paths class takes a String as file path, and returns that path as parameter for lines() method 
			Files.lines(Paths.get(filename))	//read the file line by line
					.map(row -> row.split(",")) //split each row into 4 parts by comma
					.filter(parts -> parts.length >= 4) //remove rows that don't have enough 4 parts
					.map(part -> new Book(part[0],part[1],Integer.valueOf(part[2]), Integer.valueOf(part[3]))) //create Book object
					.forEach(book -> bookList.add(book)); //add Book objects to the List
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return bookList;					
	}
	public static void main(String[] args) {
		readBook("booklist.txt").forEach(book -> System.out.println(book)); //print each Book object from the List
	}
}
