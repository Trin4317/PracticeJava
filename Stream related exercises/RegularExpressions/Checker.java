
public class Checker {
	public static boolean isDayOfWeek(String string) {
		// return true if argument is abbreviation of a day of the week (mon, tue, wed, thu, fri, sat, sun)
		if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
			System.out.println("Input value is an abbreviation of a day of the week");
			return true;
		} else {
			System.out.println("Incorrect format");
			return false;
		}
	}
	public static boolean allVowels(String string) {
		// the letters that are considered vowels are: a, e, i, o, and u
		if (string.matches("[aiueo]*")) {
			System.out.println("The string contains only vowel");
			return true;
		} else {
			System.out.println("The string contains consonant");
			return false;
		}
	}
	public static boolean timeOfDay(String string) {
		// acceptable values are between 00:00:00 and 23:59:59
		if (string.matches("((0|1)[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}")) {
			System.out.println("Correct form of 24 hours format");
			return true;
		} else {
			System.out.println("Incorrect form");
			return false;
		}
	}
	public static void main(String[] args) {
		String correctDay = "sun";
		isDayOfWeek(correctDay);
		String incorrectDay = "march";
		isDayOfWeek(incorrectDay);
		
		System.out.println();
		String allVowel = "aoieuoaiueoooaei";
		allVowels(allVowel);
		String notAllVowel = "aaabuuuoooiie";
		allVowels(notAllVowel);
		
		System.out.println();
		String correctTime = "05:59:37";
		timeOfDay(correctTime);
		String incorrectTime = "24:00:01";
		timeOfDay(incorrectTime);
	}
}
