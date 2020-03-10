//Sorting ArrayList using Comparable is a common approach.
//To compare the objects of the same type based on one field,
//We must implement Comparable and override the compareTo() method
public class Book implements Comparable<Book> {//need to specify which Object we will implement Comparable interface into
	private int id;
	private String name;
	public Book(int i,String s) {
		this.id = i;
		this.name = s;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public int compareTo(Book compareBook) {
		return (this.getId() < compareBook.getId()? -1 ://swap -1 and 1 for descending order
			(this.getId() == compareBook.getId())? 0 : 1);
	}
	@Override
	public String toString() {
		return "[id: " + this.id + ", name: " + this.name + "]";
	}
}
