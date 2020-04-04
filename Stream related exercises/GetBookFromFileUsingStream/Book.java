
public class Book {
	private String name;
	private String author;
	private int year;
	private int page;
	public Book(String name, String author, int year, int page) {
		this.name = name;
		this.author = author;
		this.year = year;
		this.page = page;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getYear() {
		return this.year;
	}
	public int getPage() {
		return this.page;
	}
	@Override
	public String toString() {
		return this.name + " (" + this.page + " pages), written by " + this.author + " in " + this.year; 
	}
}
