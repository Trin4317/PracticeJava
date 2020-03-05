import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Joke {
	private ArrayList<String> jokeList;
	public Joke() {
		this.jokeList = new ArrayList<>();
	}
	public void add(String s) {
		this.jokeList.add(s);
	}
	public void print() {
		for (int i = 0; i < this.jokeList.size(); i++) {
			System.out.println(this.jokeList.get(i));
		}
	}
	public String draw() {
		if (this.jokeList.isEmpty()) {
			return "No joke to tell!";
		}
		Random random = new Random();
		int randomIndex = random.nextInt(this.jokeList.size());//randomIndex is in range of [0;size)
		return this.jokeList.get(randomIndex);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Joke joke = new Joke();
		UserInterface ui = new UserInterface(scanner,joke);
		ui.start();
	}
}
