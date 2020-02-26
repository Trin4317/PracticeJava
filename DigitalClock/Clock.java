// the clock contains three hands
public class Clock {
	ClockHand second = new ClockHand(60);
	ClockHand minute = new ClockHand(60);
	ClockHand hour = new ClockHand(24);
	
	public void advance() {
		while (true) {
			//print the start time 00:00:00
			System.out.println(hour + ":" + minute + ":" + second);
			
			//move time by 1 second
			second.advance();
			if (second.value() == 0) {
				//if second hits 60, reset it to 0 and move time by 1 minute 
				minute.advance();
				if (minute.value() == 0) {
					//if second hits 60, reset it to 0 and move time by 1 minute
					hour.advance();
					//stop the clock when 24 hours pass
					if (hour.value()==0) break;
				}
			}
			
		}
	}
}
