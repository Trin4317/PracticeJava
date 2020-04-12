package application;

import application.domain.MultipleSensor;
import application.domain.StandardSensor;
import application.domain.TemperatureSensor;

public class Application {

	public static void main(String[] args) {
		StandardSensor s1 = new StandardSensor(10);
		StandardSensor s2 = new StandardSensor(-5);
	    System.out.println("Value of first sensor: " + s1.read());
	    System.out.println("Value of second sensor: " + s2.read());
	    s2.setOff();
	    System.out.println();
	    
	    TemperatureSensor s3 = new TemperatureSensor();
	    System.out.println("Is third sensor on? " + s3.isOn() + "\n");
	    MultipleSensor mult = new MultipleSensor();
	    mult.addSensor(s1);
	    mult.addSensor(s2);
	    mult.addSensor(s3);
	    System.out.println("Is everything on? " + mult.isOn() + "\n");
	    s3.setOn();
	    System.out.println("Is everything on? " + mult.isOn() + "\n");
	    
	    
	    System.out.println("Average value of all sensors: " + mult.read());
	    // will throw IllegalStateException as s3 is off
	    // mult.setOff();	    
	    System.out.println("Average value of all sensors: " + mult.read());
	    System.out.println("Average value of all sensors: " + mult.read());
	    System.out.println("History of average values: " + mult.readings());
	    MultipleSensor non = new MultipleSensor();
	    // will throw IllegalStateException as there is no sensor inside non
	    // System.out.println("Average value of all sensors: " + non.read());

	}

}
