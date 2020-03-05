import java.util.ArrayList;
public class SimpleDictionary {
	private ArrayList<Vocabulary> dict;//ArrayList that consists of "Vocabulary" variable type objects
	public SimpleDictionary() {
		this.dict = new ArrayList<>();
	}
	
	//add a new vocabulary (consists of word and its translation) into ArrayList
	public void add(Vocabulary vocab) {//this .add() is custom made method
		this.dict.add(vocab);//this .add() is default method in Java's ArrayList
	}
	
	//return the translation of word input by user as a String
	public String translate(String s) {
		for (Vocabulary vocab:this.dict) {//iterate each vocab exists in current ArrayList
			if (vocab.getWord().equals(s)) {//if there is a match between input and word from any vocab
				return "Translation for " + s + " is: " + vocab.getTran();//return the translation
			}
		}
		return s + " was not found";//inform user that there is no match
	}
	
	public String toString() {//modify the toString method of ArrayList
		String result = new String();//create an empty String to store value from Vocab objects in ArrayList
		for (Vocabulary vocab:this.dict) {
			result += vocab.toString() + "\n";//use the modified toString method from Vocabulary class
		}
		return result;//return the String with formatted form
	}
}
