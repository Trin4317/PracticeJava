
public class Item {
	private String name;
	private int weight;
	public Item(String name) {
		this.name = name;
		this.weight = 0;
	}
	public Item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return this.name;
	}
	public int getWeight() {
		return this.weight;
	}
	@Override
	//ArrayList's contains() method will use this override method to check for duplicate item
	public boolean equals(Object compared) {
		if (this == compared) {
			return true;
		}
		if (!(compared instanceof Item)) {
			return false;
		}
		Item comparedItem = (Item) compared;
		if (this.name.equals(comparedItem.getName())) {
			return true;
		}
		return false;
	}
}
