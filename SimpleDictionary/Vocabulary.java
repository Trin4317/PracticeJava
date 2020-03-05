
public class Vocabulary {
	private String word;
	private String translation;
	public Vocabulary(String s, String t) {
		this.word = s;
		this.translation = t;
	}
	public String getWord() {
		return this.word;
	}
	public String getTran() {
		return this.translation;
	}
	public String toString() {
		return "Word: " + this.word + ". Translation: " + this.translation;
	}
}
