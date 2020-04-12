package application.domain;

import java.util.Random;

// At the beginning, temperature sensor is off. 
// When sensor is on, its value will be randomly chosen as an integer in the range -30...30
public class TemperatureSensor implements Sensor {
	private boolean status;
	private int value;
	public TemperatureSensor() {
		this.status = false;
	}
	@Override
	public boolean isOn() {
		return this.status;
	}

	@Override
	public void setOn() {
		this.status = true;
	}

	@Override
	public void setOff() {
		this.status = false;
	}

	@Override
	public int read() {
		if (isOn() == false) {// throw an Exception if we try to call read() when sensor is off
			throw new IllegalStateException("Sensor is off!");
		}
		Random rand = new Random();
		this.value = rand.nextInt(61) - 30;
		return this.value;
	}

}
