// Because each Class can only have one compareTo method
// we need to make another class if we want to sort the cards in different ways.

import java.util.Comparator;

// Comparable interface would not be applicable here as its abstract compareTo() method only receives one parameter
// and then compare given parameter object to "this" object, as seen in Card class.
// On the other hand, abstract compare() method from Comparator interface can receive two parameters
// so we can make as many classes as we want to sort Objects in different criteria

public class SortBySuit implements Comparator<Card> {
	public int compare(Card c1, Card c2) {
		// sort by order from	 CLUB > DIAMOND > HEART > SPADE
		// value from ordinal()		0		1		2		3
		return c1.getSuit().ordinal() - c2.getSuit().ordinal();
	}
}
