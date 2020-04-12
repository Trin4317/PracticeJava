package application.domain;

// A standard sensor is always on. Calling the methods setOn and setOff has no effect.
public class StandardSensor implements Sensor {
	private final boolean status;
	private int value;
	public StandardSensor(int value) {
		this.status = true;
		this.value = value;
	}
	@Override
	public boolean isOn() {
		return this.status;
	}

	@Override
	public void setOn() {
		System.out.println("Standard Sensor is always on");
		return;
	}

	@Override
	public void setOff() {
		System.out.println("Standard Sensor is always on");
		return;
	}

	@Override
	public int read() {
		return this.value;
	}

}
