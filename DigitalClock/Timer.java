/*The timer has two hands, one for hundredth of a second and one for seconds.
  As it progresses, the number of hundredth of a second grows by one.
  When the hand corresponding to hundredth of a second reaches a value of 100, 
  its value is set to zero, and the number of seconds grows by one. 
  When the hand corresponding to seconds reaches the value of 60, its value is set to zero.
 */
public class Timer {
	ClockHand second = new ClockHand(60);
	ClockHand hundredthOfASecond = new ClockHand(100);
	
	public void advance() {
		while (true) {
			System.out.println(second + "." + hundredthOfASecond);//automatically use toString from ClockHand class
			hundredthOfASecond.advance();
			if (hundredthOfASecond.value() == 0) {
				second.advance();
				if (second.value() == 0) break;//stop the program after reaching 1 minute mark 
			}
		}
	}
}
