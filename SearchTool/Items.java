
public class Items {
	private String name;
	private String category;
	private int price;
	public Items(String a, String b, int c) {
		this.name = a;
		this.category = b;
		this.price = c;
	}
	public String getName() {
		return this.name;
	}
	public String getCategory() {
		return this.category;
	}
	public int getPrice() {
		return this.price;
	}
	public String toString() {
		return "We found " + this.name + " in category " + this.category + " for " + this.price + "yen.";
	}
}
