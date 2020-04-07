import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand>{
	private List<Card> cardList;
	public Hand() {
		cardList = new ArrayList<>();
	}
	public List<Card> getList(){
		return this.cardList;
	}
	public void add(Card card) {
		cardList.add(card);
	}
	public void print() {
		Iterator<Card> iter = cardList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	public void sort() {
		Collections.sort(cardList);// sorting using Override compareTo() method in Card class
								   // can not use stream() because it does not modify the original list, only items in the stream
	}
	public void sortBySuitAndValue() {
		Collections.sort(cardList, new SortBySuitInValueOrder()); // sorting using SortBySuitInValueOrder class's Comparator
		print();												  // as Card class can only have 1 compareTo() method
		// alternative way without making SortBySuitInValueOrder class
		// Comparator<Card> comparator = Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);
		// Collections.sort(hand.getList(),comparator);
	}
	
	// Comparing hands based on the sum of values of the cards one is holding
	@Override
	public int compareTo(Hand compared) {
		Integer thisValue = this.cardList.stream().map(l -> l.getValue()).reduce(0, Integer::sum);
		System.out.println("First hand's total value is: " + thisValue);
		// alternative way to get sum from stream list
		Integer comparedValue = compared.cardList.stream().mapToInt(l -> l.getValue()).sum();
		System.out.println("Second hand's total value is: " + comparedValue);
		
		return (thisValue > comparedValue? 1: (thisValue == comparedValue)? 0: -1);
	}
}
