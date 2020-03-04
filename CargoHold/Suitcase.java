import java.util.ArrayList;
public class Suitcase {
	private ArrayList<Item> items = new ArrayList<>();
	private final int maxWeight;
	private int curWeight;
	public Suitcase(int i) {
		this.maxWeight = i;
		this.curWeight = 0;
	}
	public void addItem(Item item) {//if total weight exceeds maximum weight limit, do not add new item
		if (!(this.curWeight + item.getWeight() > this.maxWeight)) {
			this.items.add(item);
			this.curWeight += item.getWeight();
		} 	
	}
	public String toString() {//format the statement in proper English
		if (this.items.size() != 0) {
			if (this.items.size() == 1) {
				return this.items.size() + " item (" + this.curWeight + " kg)";
			}
			return this.items.size() + " items (" + this.curWeight + " kg)";
		}
		return "no item";
	}
	public void printItems() {//prints all the items in the suitcase
		for (Item i:this.items) {
			System.out.println(i);
		}
	}
	public int totalWeight() {//returns the total weight of the items
		return this.curWeight;
	}
	public Item heaviestItem() {//returns the largest item based on weight
		if (this.items.isEmpty()) {
			return null;//if the suitcase is empty, return the value null
		}
		Item heavy = this.items.get(0);
		for (Item i:items) {
			if (i.getWeight() > heavy.getWeight()) {
				heavy = i;
			}
		}
		return heavy;
	}
}
