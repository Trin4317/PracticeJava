
public class Item {
	private String product;
	private int quantity;
	private int unitPrice;
	
	public Item(String product, int price) {
		this.product = product;
		this.unitPrice = price;
		this.quantity = 1;
	}
	
	public String getProduct() {
		return this.product;
	}
	
	public int getQty() {
		return this.quantity;
	}
	
	public int price() {
		return this.quantity * this.unitPrice;
	}
	
	public void increaseQty() {
		this.quantity += 1;
	}
	
	public String toString() {
		return this.product + ": " + this.quantity + (this.quantity > 1?" units":" unit");
	}
}
