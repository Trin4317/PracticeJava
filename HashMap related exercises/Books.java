//Make a Books class that has Name, Published Year and Content as instance variables, then use it as Key for HashMap.
//This HashMap will keep track of the books that are being borrowed, where borrowers' name is the Value of HashMap.

import java.util.*;

public class Books {
	private String name;
	private int year;
	private String content;
	public Books(String name,int year,String content) {
		this.name = name;
		this.year = year;
		this.content = content;
	}
	
	//We need to overwrite the default equals() and hashCode() method in Object class first
	//so it can do APPROXIMATE comparison when we use custom Object (eg. not String/Integer) as HashMap's key 
	@Override
	public boolean equals(Object compared) {
		// if the variables are located in the same place, they're the same
		if (this == compared) {
			return true;
		}
		// if compared Object is not of type Books, the objects aren't the same
		if (!(compared instanceof Books)) {
			return false;
		}
		// convert the object to a Books type
		Books comparedBook = (Books) compared;
		// if the instance variables of the compared object are the same, so are the objects
		if (this.name.equals(comparedBook.name) && this.year == comparedBook.year && this.content.equals(comparedBook.content)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		if (this.name == null) {
			return this.year;//int is a primitive type variable so it doesn't have any default method
		}
		return this.name.hashCode() + this.year;//hashCode() is a default method that return a Hash value based on object's reference
		//^ the object here is String variable	//which means objects that share the same reference with receive the same Hash value 
	}
	public static void main(String[] args) {
		HashMap<Books,String> borrowers = new HashMap<>();//create new HashMap with Books as Key and borrowers' name as Value
		Books book = new Books("Book A",2010,"...");//create new Books object
		
		//start keeping track of borrowed book
		borrowers.put(book,"James");
		borrowers.put(new Books("Book B",2015,"..."),"Louis");
		
		//check who is borrowing the book
		System.out.println(borrowers.get(book));
		
		//without overriding equals() and hashCode(), the following codes would print "null"
		//because these new Books type objects don't share the same reference with above objects
		//which means the HashCode created by default method would be different, hence HashMap can't find the value based on these Keys
		System.out.println(borrowers.get(new Books("Book A",2010,"...")));
		System.out.println(borrowers.get(new Books("Book B",2015,"...")));
	}
}