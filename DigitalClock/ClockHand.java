/* ClockHand class that describes a clock hand, which contains information about its value, upper limit,
   and provides methods for advancing the hand, viewing its value, and also printing the value in string form.
 */
public class ClockHand {
	private int value;
	private int limit;
	public ClockHand(int i) {
		this.limit = i;
		this.value = 0;
	}
	public int value() {
		return this.value;
	}
	public void advance() {
		this.value = this.value + 1;
		if (this.value >= this.limit) {
			this.value = 0;
		}
	}
	//if the value of hour/minute/second only consists of 1 digit, add 0 before to follow HH:MM:SS format
	public String toString() {
		if (value < 10) return "0" + value;
		else return "" + value;
	}
}
