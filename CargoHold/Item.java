
public class Item {
	private String name;
	private int weight;
	public Item(String s,int i) {
		this.name = s;
		this.weight = i;
	}
	public String getName() {
		return this.name;
	}
	public int getWeight() {
		return this.weight;
	}
	public String toString() {
		return this.name + " (" + this.weight + " kg)";
	}
}
