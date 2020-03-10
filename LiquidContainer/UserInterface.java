import java.util.Scanner;
public class UserInterface {
	private Scanner scanner;
	private Container container1;
	private Container container2;
	public UserInterface(Scanner s, Container c1, Container c2) {
		this.scanner = s;
		this.container1 = c1;
		this.container2 = c2;
	}
	public void move(String s, int i) {
		switch(s.toLowerCase()) {
		case "add":
			this.container1.add(i);
			break;
		case "move":
			this.container1.move(this.container2,i);
			break;
		case "remove":
			this.container2.remove(i);
			break;
		default:
			System.out.println("Invalid input!");
			break;
		}
	}
	public void start() {
		while (true) {
			System.out.println("First container: " + this.container1);
			System.out.println("Second container: " + this.container2);
			System.out.println("Command: ");
			String input = this.scanner.nextLine();
			String[] split = input.split(" ");
			String command = split[0];
			if (command.equals("quit")) {
				System.out.println("End!");
				break;
			}
			try {
				int amount = Integer.valueOf(split[1]);
				if (amount < 0) continue;
				move(command,amount);
			}
			catch (Exception e) {
				System.out.println("Please input in format 'Command' 'Amount' \n"
						+ "or input 'quit' to stop the program.");
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Container c1 = new Container();
		Container c2 = new Container();
		UserInterface ui = new UserInterface(scanner,c1,c2);
		ui.start();
	}
}
