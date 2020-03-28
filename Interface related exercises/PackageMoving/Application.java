
public class Application {
	public static void main(String[] args) {
	    Box box = new Box(10);

	    box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2)) ;
	    box.add(new Book("Robert Martin", "Clean Code", 1));
	    box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

	    box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
	    box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
	    box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

	    System.out.println(box);
	    
	    Box biggerBox = new Box(20);
	    
	    biggerBox.add(new Book("Sam Esmail","Mr. Robot",1.4));
	    biggerBox.add(new CD("Mac Quayle","Mr. Robot OST Vol 8",2020));
	    biggerBox.add(box);
	    
	    System.out.println(biggerBox);
	}
}
