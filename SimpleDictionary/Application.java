/* Create a program that separates the user interface from its logic in different classes. 
 * This program will allow users to store multiple sets of vocabulary consists of word and its translation.
 * Users can also search for translation of specific word, as well as list all available vocabulary.  
 */
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SimpleDictionary dict = new SimpleDictionary();
		
		TextUI ui = new TextUI(scanner,dict);//create TextUI interface
		ui.start();//call the method that starts this program
		
	}
}
