package application.domain;

import java.util.ArrayList;
import java.util.List;

// A multiple sensor can contain many different sensors at once
// It is considered as on when all of its contained sensors are on
public class MultipleSensor implements Sensor {
	private List<Sensor> sensors;
	private List<Integer> results;// keep track of result every time read() is called
	public MultipleSensor() {
		this.sensors = new ArrayList<>();
		this.results = new ArrayList<>();
	}
	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}
	@Override
	public boolean isOn() {
		for(Sensor s: this.sensors) {
			if (!s.isOn()) {
				System.out.println("Off sensor detected: " + s);// show the address of Sensor object that is off
				return false;
			}
		}
		//System.out.println("All sensors are on");
		return true;
	}

	@Override
	public void setOn() {// set all sensors on
		for(Sensor s: this.sensors) {
			s.setOn();
		}
	}

	@Override
	public void setOff() {// set all sensors off
		for(Sensor s: this.sensors) {
			s.setOff();
		}
	}

	@Override
	public int read() {
		if (this.sensors.size() == 0 || isOn() == false) {// throw Exception is there is no sensor or there is any off sensor
			throw new IllegalStateException("Can't return value!");
		}
		//return average value of all sensors
		int result = (int) this.sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
		this.results.add(result);
		return result;
	}
	public List<Integer> readings(){
		// return this list that contains past values that read() has created
		return this.results;
	}

}
