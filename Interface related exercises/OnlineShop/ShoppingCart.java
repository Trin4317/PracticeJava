import java.util.*;

public class ShoppingCart {
	private List<Item> cart;
	
	public ShoppingCart() {
		this.cart = new ArrayList<>();
	}
	
	public void add(String product, int price) {
		for (Item i:this.cart) {
			if (i.getProduct().equals(product)) {//if product already exists in Cart, only increase the quantity
				i.increaseQty();
				return;
			}
		}
		this.cart.add(new Item(product,price));//if new product, put it into Cart with quantity = 1
	}
	
	public int price() {//calculate the total value of Cart
		int price = 0;
		for (Item i:this.cart) {
			price += i.price();//sum of each item * its corresponding unit price 
		}
		return price;
	}
	
	public void print() {
		for (Item i:this.cart) {
			System.out.println(i);
		}
	}
}
