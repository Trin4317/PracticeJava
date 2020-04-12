package dictionary.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
	private Map<String, String> dictionary; // HashMap that saves (word-translation) data
	private String fileName; // store the name of the file to be read from
	//empty dictionary that can only be added manually
	public SaveableDictionary() {
		this.dictionary = new HashMap<>();
	}
	//empty dictionary that can be imported from a text file 
	public SaveableDictionary(String filename) {
		this.dictionary = new HashMap<>();
		this.fileName = filename;
	}
	public void add(String word, String translation) {
		if (this.dictionary.containsKey(word)) {
			System.out.println("Fail to add this word as it already exists in dictionary!");
		} else {
			this.dictionary.put(word,translation);
		}
	}
	public String translate(String word) {
		if (this.dictionary.containsKey(word)) {
			return this.dictionary.get(word);
		} else {
			return null;
		}
	}
	public void delete(String word) {
		if (this.dictionary.containsKey(word)) {
			this.dictionary.remove(word);
		} else {
			System.out.println("Cannot delete nonexistent word!");
		}
	}
	public boolean load() {
		try (Scanner file = new Scanner(Paths.get(this.fileName))){
			if (!file.hasNextLine()) {
				return false;
			}
			while(file.hasNextLine()) {
				String line = file.nextLine();
				String[] part = line.split(":");
				this.dictionary.put(part[0],part[1]);
			}
			return true;
		} catch (IOException e) {
			System.out.println("Error: " + e);
			return false;
		}
	}
	public boolean save() {
		try (FileWriter writer = new FileWriter(this.fileName)){// the writer begins writing at the start of the file
			for (String key:this.dictionary.keySet()) {
				writer.write(key + ":" + this.dictionary.get(key) + "\n");
			}
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error: " + e);
			return false;
		}
	}
	public void print() {
		System.out.println("List of vocabulary: ");
		for (String key:this.dictionary.keySet()) {
			System.out.println(key + ":" + this.dictionary.get(key));
		}
	}
}
