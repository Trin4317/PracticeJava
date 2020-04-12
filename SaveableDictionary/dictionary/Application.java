package dictionary;

import dictionary.domain.SaveableDictionary;

public class Application {

	public static void main(String[] args) {
		SaveableDictionary dict = new SaveableDictionary();
		dict.add("hello","こんにちは");
		dict.add("bye","さようなら");
		dict.add("thanks","ありがとう");
		dict.add("hello","おはよう"); // fail to add duplicated word
		
		System.out.println("Translation of 'hello' is: " + dict.translate("hello"));
		System.out.println("Translation of 'bye' is: " + dict.translate("bye"));
		System.out.println("Translation of 'thanks' is: " + dict.translate("thanks"));
		System.out.println("Translation of 'sorry' is: " + dict.translate("sorry")); // return null as word doesn't exist in dictionary
		System.out.println();
		
		dict.delete("hello");
		dict.delete("sorry"); //fail to delete nonexistent word	
		System.out.println("Translation of 'hello' is: " + dict.translate("hello")); // word was deleted from dictionary
		System.out.println();
		
		// Paths.get(file.txt) will read the file from its project folder (e.g ~/Project/file.txt),
		// we need to include the relative or absolute path if we place the file inside another folder
		SaveableDictionary dictNew = new SaveableDictionary("src\\dictionary\\anotherwords.txt"); 
		// if the file exists and is not empty, add its content to dictNew object and inform the users
		if (dictNew.load()) {
			System.out.println("Successfully load the file!");
		} else {
			System.out.println("Fail to load the file!");// also inform the users in case it fails to read the file or file is empty
		}
		dictNew.print();
		
		// try to modify the file by adding and removing some words then save it
		System.out.println();
		System.out.println("Translation of 'person' is: " + dictNew.translate("person"));
		dictNew.add("water","みず");
		System.out.println("Translation of 'water' is: " + dictNew.translate("water"));
		System.out.println();
		dictNew.print();
		
		System.out.println();
		dictNew.add("sun","たいよう");
		dictNew.delete("one");
		dictNew.add("kid","こども");
		dictNew.add("word","ことば");
		dictNew.save(); //saving new changes into anotherwords.txt file
		
		// try to load the same file from a new object to check if save() method worked
		SaveableDictionary dictNewCopy = new SaveableDictionary("src\\dictionary\\anotherwords.txt");
		dictNewCopy.load();
		dictNewCopy.print();
	}

}
