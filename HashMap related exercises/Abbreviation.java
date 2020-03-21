import java.util.HashMap;

public class Abbreviation {
	private HashMap<String, String> Abbreviation;//using HashMap as instance variable
	public Abbreviation() {
		this.Abbreviation = new HashMap<>();
	}
	
	public static String sanitizedString(String s) {//static method since it doesn't handle object variables
		if (s == null) {
			return "";
		}
		s = s.trim().toLowerCase();//enables case-independent search for abbreviation
		return s;
	}
	
	public boolean hasAbbr(String abbreviation) {//checks if an abbreviation has already been added
		if (this.Abbreviation.containsKey(sanitizedString(abbreviation))) {//containsKey is a default method of HashMap
			return true;
		} else {
			return false;
		}
	}
	
	public void addAbbr(String abbreviation, String explanation) {//adds new abbreviation and explanation
		if (hasAbbr(abbreviation)) {//hadAbbr is a custom method of Abbreviation object, no need to include this.Abbreviation
			System.out.println("Duplicate abberviation already exists!");
		} else {
			this.Abbreviation.put(abbreviation,explanation);
		}
	}
	
	public String findExplanation(String abbreviation) {//finds the explanation for an abbreviation
		if (hasAbbr(abbreviation)) {
			return this.Abbreviation.get(sanitizedString(abbreviation));
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Abbreviation abbreviation = new Abbreviation();
		abbreviation.addAbbr("e.g", "for example");
		abbreviation.addAbbr("etc.", "and so on");
		abbreviation.addAbbr("i.e", "more precisely");
		abbreviation.addAbbr(" e.g ", "for example");//add duplicate abbreviation

		String text = "e.g i.e etc. lol";

		for (String part: text.split(" ")) {
	        part = abbreviation.findExplanation(part);
		    System.out.println(part);
		}

		abbreviation.addAbbr("lol", "laugh out loud");//add new abbreviation
		System.out.println(abbreviation.findExplanation("  lol   "));
	}
}
