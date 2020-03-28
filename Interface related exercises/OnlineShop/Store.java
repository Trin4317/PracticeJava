import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("Available goods:");

        for (String product : this.warehouse.list()) {//print the available goods in warehouse
            System.out.println(product + " @ " + this.warehouse.price(product) + " dollars (" + this.warehouse.stock(product) + " units)");
        }

        while (true) {
            System.out.println("What do you want to buy (Enter to check out):");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }
            if (this.warehouse.stock(product) == 0) {
            	System.out.println("Sorry, " + product + " is out of stock right now!");
            	continue;
            }
            this.warehouse.take(product);
            cart.add(product, this.warehouse.price(product));
        }

        System.out.println("Your shopping cart:");
        cart.print();
        System.out.println("Total price: " + cart.price() + " dollars");
    }
    public static void main(String[] args) {
    	Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 10);
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("cream", 2, 20);
        warehouse.addProduct("bread", 4, 5);

        Scanner scanner = new Scanner(System.in);

        Store store = new Store(warehouse, scanner);
        store.shop("John");
    }
}