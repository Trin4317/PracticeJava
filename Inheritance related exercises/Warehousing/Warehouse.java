
public class Warehouse {
	private double capacity;
	private double balance;
	public Warehouse(double capacity) {
		if (capacity < 0) {
			this.capacity = 0;
		} else {
			this.capacity = capacity;
			this.balance = 0;
		}
	}
	public double getBalance() {
		return this.balance;
	}
	public double getCapacity() {
		return this.capacity;
	}
	public double howMuchSpaceLeft() {
		return this.capacity - this.balance;
	}
	public void addToWarehouse(double amount) {
		if (amount < 0) {
			return;
		}
		this.balance = (this.balance + amount > this.capacity)? this.capacity: this.balance + amount;
	}
	public double takeFromWarehouse(double amount) {
		if (amount < 0) {
			return 0;
		}
		if (amount > this.balance) {
			amount = this.balance;
			this.balance = 0;
			return amount;
		} else {
			this.balance -= amount;
			return amount;
		}
	}
	public String toString() {
		return "balance = " + String.format("%.1f",this.balance) + ", space left = " + String.format("%.1f",howMuchSpaceLeft());
	}
	public static void main(String[] args) {
		ProductWarehouseWithHistory juice = new ProductWarehouseWithHistory("Juice", 1000, 600);
		System.out.println("Name of this warehouse: " + juice.getName());
		System.out.println(juice);
		
		juice.takeFromWarehouse(11.3);
		System.out.println(juice);
		
		juice.addToWarehouse(5.5);
		System.out.println(juice);
		
		juice.takeFromWarehouse(59.7);
		System.out.println(juice);
		
		System.out.println(juice.history());
		juice.printAnalysis();
		
	}
}
