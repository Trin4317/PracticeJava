import java.util.Scanner;
public class UserInterface {
	private Scanner scanner;
	private Joke joke;
	public UserInterface(Scanner s, Joke t) {
		this.scanner = s;
		this.joke = t;
	}
	public void start() {
		while(true) {
			System.out.println("Command: (Type h for help)");
			String input = this.scanner.nextLine();
			if (input.equals("x")) {
				System.out.println("See you again!");
				break;
			}
			if (input.equals("1")) {
				System.out.println("What's your joke?");
				String joke = this.scanner.nextLine();
				this.joke.add(joke);
				continue;
			}
			if (input.equals("2")) {
				System.out.println("Here's a funny joke:");
				System.out.println(this.joke.draw());;
				continue;
			}
			if (input.equals("3")) {
				System.out.println("Check out all of my favorite jokes!");
				this.joke.print();
				continue;
			}
			if (input.equals("h")) {
				System.out.println("Available commands:\n1.Add a joke\n"
						+ "2.Draw a joke\n3.List all joke\nx.Close");
			}
		}
	}
	
}
