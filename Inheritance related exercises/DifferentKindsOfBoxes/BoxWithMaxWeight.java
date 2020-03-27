import java.util.ArrayList;
//This class can only hold items that their total weights don't exceed the maximum capacity
public class BoxWithMaxWeight extends Box {
	private final int maxWeight;
	private int currentWeight;
	private ArrayList<Item> itemList;
	
	public BoxWithMaxWeight(int capacity) {
		this.maxWeight = capacity;
		this.currentWeight = 0;
		this.itemList = new ArrayList<>();
	}
	
	public int getCurrent() {
		return this.currentWeight;
	}
	
	public int getMax() {
		return this.maxWeight;
	}
	@Override
	public void add(Item item) {
		if (this.currentWeight + item.getWeight() > this.maxWeight) {
			return;
		} else {
			this.itemList.add(item);
			this.currentWeight += item.getWeight();
		}
	}
	
	@Override
	public boolean isInBox(Item item) {
		if (this.itemList.contains(item)) {
			return true;
		} 
		return false;
	}
	
	public static void main(String[] args) {
		BoxWithMaxWeight coffeeBox = new BoxWithMaxWeight(10);
		coffeeBox.add(new Item("Cappu", 5));
		coffeeBox.add(new Item("Espresso", 4));
		coffeeBox.add(new Item("Mocha", 7));
		System.out.println("Current weight: " + coffeeBox.getCurrent() + "/" + coffeeBox.getMax());
		System.out.println(coffeeBox.isInBox(new Item("Cappu")));//this Cappu instance here is different from above Cappu instance above
																//but thanks to override equals() method, coffeeBox's isInBox() still works
		System.out.println(coffeeBox.isInBox(new Item("Espresso")));
		System.out.println(coffeeBox.isInBox(new Item("Mocha")));
		
		System.out.println();
		OneItemBox presentBox = new OneItemBox();
		presentBox.add(new Item("Shirt"));
		presentBox.add(new Item("Necktie"));
		System.out.println(presentBox.isInBox(new Item("Shirt")));
		System.out.println(presentBox.isInBox(new Item("Necktie")));
		
		Item A = new Item("A",3);
		Item B = new Item("B",2);
		Item C = new Item("C",3);
		Item D = new Item("D",2);
		ArrayList<Item> mangaList = new ArrayList<>();
		mangaList.add(A);
		mangaList.add(B);
		mangaList.add(C);
		mangaList.add(D);
		//try adding an ArrayList instead of Item into Box's subclass object
		BoxWithMaxWeight mangaBox = new BoxWithMaxWeight(8);
		mangaBox.add(mangaList);//works thanks to Box's add(ArrayList<Item> items) method
		System.out.println();
		System.out.println("Current weight: " + mangaBox.getCurrent() + "/" + mangaBox.getMax());
		System.out.println(mangaBox.isInBox(C));
		System.out.println(mangaBox.isInBox(D));
		
	}
}
