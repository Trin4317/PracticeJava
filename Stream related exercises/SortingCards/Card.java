
public class Card implements Comparable<Card>{
	private int value;
	private Suit suit;
	public Card(int value, Suit suit) {
		if (value < 2 || value > 14) {
			System.out.println("Invalid value!");
			return;
		}
		this.value = value;
		this.suit = suit;
	}
	public int getValue() {
		return this.value;
	}
	public Suit getSuit() {
		return this.suit;
	}
	
	@Override
	public String toString() {
		switch(this.value) {
		case 11: return this.suit + " J";
		case 12: return this.suit + " Q";
		case 13: return this.suit + " K";
		case 14: return this.suit + " A";
		default: return this.suit + " " + this.value;
		}
	}
	
	// Sorting the cards in ascending order
	@Override
	public int compareTo(Card compared) {// need to implement Comparable interface first
		if (this.value != compared.value) {
			return (this.value > compared.value? 1: (this.value == compared.value)? 0: -1); // 2 is smallest and A is biggest
		} else {// if value from both cards are the same
			// sort by order from	 CLUB > DIAMOND > HEART > SPADE
			// value from ordinal()		0		1		2		3
			return (this.suit.ordinal() > compared.suit.ordinal()? 1: (this.suit.ordinal() == compared.suit.ordinal())? 0: -1);
		}
	}
}
