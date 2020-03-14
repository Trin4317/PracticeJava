import java.util.Scanner;
import java.util.ArrayList;

public class Application {
	public static void command(Scanner scanner,ArrayList<Bird> birds) {
		System.out.println("Add - adds a bird\nObservation - observates a bird\n"
				+ "All - prints all birds\nOne - prints one bird\nQuit - ends the program");
		while(true) {
			System.out.print("? ");
			String cmd = scanner.nextLine();
			if (cmd.equals("quit")) {
				System.exit(0);
			}
			if (cmd.equals("add")) {
				add(scanner,birds);
				continue;
			}
			if (cmd.equals("observation")) {
				observate(scanner,birds);
				continue;
			}
			if (cmd.equals("all")) {
				printAll(birds);
				continue;
			}
			if (cmd.equals("one")) {
				printOne(scanner,birds);
				continue;
			} 
			System.out.println("Invalid command!");
		}
	}
	public static void add(Scanner scanner,ArrayList<Bird> birds) {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Name in Latin: ");
		String latinName = scanner.nextLine();
		birds.add(new Bird(name,latinName));
	}
	public static void observate(Scanner scanner,ArrayList<Bird> birds) {
		System.out.print("Bird to observate: ");
		String name = scanner.nextLine();
		for (Bird b:birds) {
			if (b.getName().toLowerCase().equals(name.toLowerCase())) {
				b.addCount();
				return;
			} 
		}
		System.out.println("This bird is not available in database. Use 'add' command to create a new entry.");
	}
	public static void printAll(ArrayList<Bird> birds) {
		for (Bird b:birds) {
			System.out.println(b);
		}
	}
	public static void printOne(Scanner scanner,ArrayList<Bird> birds) {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		for (Bird b:birds) {
			if (b.getName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println(b);
				return;
			}
		}
		System.out.println("This bird is not available in database.");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Bird> birds = new ArrayList<>();
		command(scanner,birds);
	}
}
