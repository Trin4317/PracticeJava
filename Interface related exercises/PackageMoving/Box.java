import java.util.ArrayList;

public class Box implements Packable {
	private ArrayList<Packable> box;
	//private double weight; //Here we try not to maintain an explicit object variable, instead calculate it only when we need to
	private final double capacity;
	public Box(double capacity) {
		this.box = new ArrayList<>();
		//this.weight = 0; //No longer necessary thanks to weight() method
		this.capacity = capacity;
	}
	public void add(Packable item) {
		if (this.weight() + item.weight() > this.capacity) {
			return;
		}
		this.box.add(item);
		//this.weight += item.weight(); //No longer necessary thanks to weight() method
	}
	@Override
	public double weight() {//Calculate the current weight of box when we need to
		double weight = 0;
		for (Packable item:this.box) {
			weight += item.weight();
		}
		return weight;
	}
	public String toString() {
		return "Box: " + this.box.size() + " items, total weight: " + this.weight();
	}
}
