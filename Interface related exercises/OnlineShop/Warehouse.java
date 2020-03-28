import java.util.*;

public class Warehouse {
	private Map<String, Integer> productPrice;
	private Map<String, Integer> productStock;
	
	public Warehouse() {
		this.productPrice = new HashMap<>();
		this.productStock = new HashMap<>();
	}
	
	public void addProduct(String product, int price, int stock) {
		this.productPrice.put(product,price);
		this.productStock.put(product,stock);
	}
	
	public int price(String product) {
		if (this.productPrice.containsKey(product)) {
			return this.productPrice.get(product);
		}
		return -99;
	}
	
	public int stock(String product) {
		if (this.productStock.containsKey(product)) {
			return this.productStock.get(product);
		}
		return 0;
	}
	
	public boolean take(String product) {
		if (!this.productStock.containsKey(product) || this.productStock.get(product) == 0) {
			return false;//product doesn't exist or there's no stock left
		}
		this.productStock.put(product, this.productStock.get(product) - 1);//decrese stock count by 1 
		return true;
	}
	
	public Set<String> list(){
		return this.productPrice.keySet();
	}
}
