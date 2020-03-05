import java.util.Scanner;
public class TextUI {
	private Scanner scanner;
	private SimpleDictionary dict;//use another Object as parameter for this interface
	public TextUI(Scanner s, SimpleDictionary t) {
		this.scanner = s;
		this.dict = t;
	}
	public void start() {
		while (true) {
			System.out.println("Command:");
			String input = this.scanner.nextLine();
			
			if (input.equals("end")) {
				System.out.println("Bye bye!");
				break;//end the program
				}
			if (input.equals("add")) {
				System.out.println("Adding new vocabulary");
				System.out.println("Word:");
				String word = this.scanner.nextLine();
				System.out.println("Translation:");
				String tran = this.scanner.nextLine();
				dict.add(new Vocabulary(word,tran));//add users' input as new Vocab instance in ArrayList
				//the short form code above can be written as
				//Vocabulary vocab = new Vocabulary(word,tran);
				//dict.add(vocab);
				continue;//go back to the beginning of while loop
				}
			if (input.equals("search")) {
				System.out.println("Searching for translation");
				System.out.println("Word:");
				String word = this.scanner.nextLine();
				System.out.println(dict.translate(word));//search for translation based on users' input
				continue;
				}
			if (input.equals("list")) {
				System.out.println("Listing all available vocabulary");
				System.out.println(this.dict);//list all objects in ArrayList
				continue;
				}
			System.out.println("Unknown command");
			 
		}
	}
}

