// sort by order from	CLUB > DIAMOND > HEART > SPADE
// then sort by value	2 - A
import java.util.Comparator;

public class SortBySuitInValueOrder implements Comparator<Card> {
	public int compare(Card c1, Card c2) {
		int suitCompare = c1.getSuit().ordinal() - c2.getSuit().ordinal();
		int valueCompare = c1.getValue() - c2.getValue();
		if (suitCompare == 0) {// if both cards have the same suit
			// if both cards have the same value -> same order priority
			// if different value -> return positive value if c1 is bigger, which means c1 will be placed after c2
			return (valueCompare == 0)? suitCompare: valueCompare;
		} else {// if both cards have different suit
			return suitCompare;// return positive value if c1's suit is smaller, which means c1 will be placed after c2
		}
	}
}
