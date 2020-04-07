import java.util.Collections;

public class Application {
	public static void main(String[] args) {
		Hand hand = new Hand();
		hand.add(new Card(5, Suit.DIAMOND));
		hand.add(new Card(14, Suit.SPADE));
		hand.add(new Card(12, Suit.HEART));
		hand.add(new Card(2, Suit.SPADE));
		hand.add(new Card(5, Suit.CLUB));
		hand.add(new Card(2, Suit.DIAMOND));
		
		//Sorting card in one hand
		System.out.println("Original 'hand':");
		hand.print();
		/*
		System.out.println("\nAfter sorting in ascending order:");
		hand.sort();
		hand.print();
			
		//Sorting card in one hand with different criteria		
		System.out.println("\nOriginal 'hand' sorted by Suit order");
		SortBySuit sortBySuitSorter = new SortBySuit();
		Collections.sort(hand.getList(), sortBySuitSorter);
		// alternative way without making SortBySuit class
		// Collections.sort(cards, (c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());

		*/
		
		System.out.println("\nOriginal 'hand' sorted by Suit and Value order");
		hand.sortBySuitAndValue();
				
		//Ranking two hands based on total value
		System.out.println("\nComparing two new hands:");
		Hand hand1 = new Hand();
		hand1.add(new Card(2, Suit.DIAMOND));
		hand1.add(new Card(14, Suit.SPADE));
		hand1.add(new Card(12, Suit.HEART));
		hand1.add(new Card(2, Suit.SPADE));

		Hand hand2 = new Hand();
		hand2.add(new Card(11, Suit.DIAMOND));
		hand2.add(new Card(11, Suit.SPADE));
		hand2.add(new Card(11, Suit.HEART));

		int comparison = hand1.compareTo(hand2);
		
		if (comparison < 0) {
		    System.out.println("=== Better hand is second hand ===");
		    hand2.print();
		} else if (comparison > 0){
			System.out.println("=== Better hand is first hand ===");
		    hand1.print();
		} else {
		    System.out.println("Both hands are equal");
		}
		
		
	}
}
