
public class Application {
	public static void main(String[] args) {
		//Item class stores the name and weight of the item (kg)
		//and has getName(), getWeight() method
		Item book = new Item("Lord of the rings", 2);
        Item phone = new Item("Nokia 3210", 1);
        Item brick = new Item("brick", 4);
        
        //Suitcase class stores items, current weight and maximum weight
        //it has addItem(), totalWeight(), heaviestItem() and printItems() method
        Suitcase adasCase = new Suitcase(10);
        adasCase.addItem(book);
        adasCase.addItem(phone);

        Suitcase pekkasCase = new Suitcase(10);
        pekkasCase.addItem(brick);
        
        System.out.println("Ada's case has " + adasCase);
        adasCase.printItems();
        System.out.println();
        System.out.println("Pekka's case has " + pekkasCase);
        pekkasCase.printItems();
        System.out.println();
        
        //Hold class stores suitcases, current weight and maximum weight
        //it has addSuitcase() and printItems() method
        Hold hold = new Hold(1000);
        hold.addSuitcase(adasCase);
        hold.addSuitcase(pekkasCase);

        System.out.println("The suitcases in the hold contain the following items:");
        hold.printItems();
	}
}
