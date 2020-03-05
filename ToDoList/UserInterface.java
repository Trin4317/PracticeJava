import java.util.Scanner;
public class UserInterface {
	private Scanner scanner;
	private ToDo list;
	public UserInterface(Scanner s, ToDo t) {
		this.scanner = s;
		this.list = t;
	}
	public void start() {
		while (true) {
			System.out.println("Command (add/list/remove/stop):");
			String cmd = this.scanner.nextLine();
			if (cmd.equals("stop")) {
				System.out.println("Goodbye!");
				break;
			}
			if (cmd.equals("add")) {
				System.out.println("Name of the task:");
				String task = this.scanner.nextLine();
				this.list.add(task);//use method from ToDo class
				continue;
			}
			if (cmd.equals("list")) {
				this.list.print();//use method from ToDo class
				continue;
			}
			if (cmd.equals("remove")) {
				if (this.list.isEmpty()) {//use method from ToDo class
					System.out.println("No task to be removed!");
					continue;
				} 
				System.out.println("Task to be removed");
				int index = Integer.parseInt(this.scanner.nextLine());
				this.list.remove(index);//use method from ToDo class
				continue;
			}
			System.out.println("Invalid command!");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ToDo list = new ToDo();
		UserInterface ui = new UserInterface(scanner,list);
		ui.start();//keep main method clean
	}
}
