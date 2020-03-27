
public class ProductWarehouseWithHistory extends ProductWarehouse{
	private ChangeHistory history = new ChangeHistory();
	public ProductWarehouseWithHistory(String product, double capacity, double initialBalance) {
		super(product,capacity);
		super.addToWarehouse(initialBalance);
		this.history.add(initialBalance); 
	}
	public String history() {
		return "History: " + this.history.toString();
	}
	public void addToWarehouse(double amount) {
		super.addToWarehouse(amount);
		this.history.add(super.getBalance());
	}
	public double takeFromWarehouse(double amount) {
		double takenAmount = super.takeFromWarehouse(amount);
		this.history.add(super.getBalance());
		return takenAmount;
	}
	public void printAnalysis() {
		System.out.println("Largest amount of product: " + this.history.maxValue());
		System.out.println("Smallest amount of product: " + this.history.minValue());
		System.out.println("Average: " + String.format("%.1f",this.history.average()));
	}
}
