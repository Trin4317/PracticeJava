import java.util.ArrayList;

public abstract class Box {
	//all abstract methods need to be implemented in subclasses
	public abstract void add(Item item);
	
	//in case adding an ArrayList of Item type Objects instead of single Item object
	//this super method will make sure that its subclass can call their own add() method
	public void add(ArrayList<Item> items) {
		for (Item item:items) {
			Box.this.add(item);
		}
	}
	
	public abstract boolean isInBox(Item item);
}
