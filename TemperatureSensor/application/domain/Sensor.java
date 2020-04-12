package application.domain;

public interface Sensor {
	boolean isOn(); // return true if sensor is on
	void setOn();	// set the sensor on
	void setOff();	// set the sensor off
	int read();		// return value if sensor is on, throw IllegalStateException if sensor is off
	
}
