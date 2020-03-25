// Create a dictionary that can store one or many translations for one word
// Here, a single key can contains multiple values by using ArrayList

import java.util.HashMap;
import java.util.ArrayList;

public class AdvancedDictionary {
	private HashMap<String, ArrayList<String>> dictionary;
	public AdvancedDictionary() {
		this.dictionary = new HashMap<>();
	}
	public void add(String word, String translation) {
		//create a new ArrayList if the key is new and doesn't have any value inside  
		this.dictionary.putIfAbsent(word, new ArrayList<>());
		//add the value into that ArrayList
		this.dictionary.get(word).add(translation);
	}
	public ArrayList<String> translate(String word){
		return this.dictionary.get(word);
	}
	public void remove(String word) {
		this.dictionary.remove(word);
	}
	public void print() {
		//print all the keys and its values
		for (String word: this.dictionary.keySet()) {
			System.out.println(word + ": "+ this.dictionary.get(word));
		}
	}
	public static void main(String[] args) {
		AdvancedDictionary dict = new AdvancedDictionary();
		dict.add("cat","neko");
		dict.add("cat","nyan chan");
		dict.add("dog","inu");
		dict.add("dog","wan chan");
		dict.add("connect","tsunagu");
		dict.add("connect","konekuto");
		dict.add("connect","sessuru");
		
		dict.print();
		System.out.println();
		System.out.println(dict.translate("dog"));
		dict.remove("cat");
		System.out.println();
		dict.print();
	}
}
