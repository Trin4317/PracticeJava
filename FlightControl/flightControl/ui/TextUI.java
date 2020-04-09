package flightControl.ui;

import java.util.Scanner;

import flightControl.domain.Airplane;
import flightControl.logic.FlightControl;

public class TextUI {
	private FlightControl flightControl;
	private Scanner scanner;
	public TextUI(FlightControl flightControl, Scanner scanner) {
		this.flightControl = flightControl;
		this.scanner = scanner;
	}
	public void start() {
		startAssetControl();
		System.out.println();
		startFlightControl();
		System.out.println();
	}
	// Any other method besides start() should be defined as private so it can't be accessed by other Classes
	private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("---------------------");
        System.out.println();
        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            
            System.out.print("> ");
            String choice = scanner.nextLine();
            if (choice.toLowerCase().equals("x")) {
            	System.out.println("Exiting Airport Asset Control...");
            	break;
            }
            if (choice.equals("1")) {
            	addAirplane();
            } else if (choice.equals("2")) {
            	addFlight();
            } else {
            	System.out.println("Invalid choice!");
            }
        }
	}
	private void addAirplane() {
		System.out.print("Input Airplane ID: ");
    	String airplaneID = scanner.nextLine();
    	System.out.print("Input Airplane Capacity: ");
    	String airplaneCap = scanner.nextLine();
    	
    	this.flightControl.addPlane(airplaneID, Integer.valueOf(airplaneCap));
    	System.out.println();
	}
	private void addFlight() {
		System.out.print("Input Airplane ID: ");
    	Airplane airplane = askForAirplane();
    	System.out.print("Input Depature ID: ");
    	String departureID = scanner.nextLine();
    	System.out.print("Input Destination ID: ");
    	String destinationID = scanner.nextLine();
    	
    	this.flightControl.addFlight(airplane, departureID, destinationID);
    	System.out.println();
	}
	private Airplane askForAirplane() {
		Airplane airplane = null;
		// keep asking until found an existed Airplane
		while (airplane == null) {
			String id = scanner.nextLine();
			airplane = this.flightControl.getAirplane(id);
			
			if(airplane == null) {
				System.out.println("No airplane with the id: " + id + ".");
				System.out.print("Input Airplane ID: ");
			}
		}
		return airplane;
	}
	private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("--------------");
        System.out.println();
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            
            System.out.print("> ");
            String choice = scanner.nextLine();
            if (choice.toLowerCase().equals("x")) {
            	System.out.println("Exiting Flight Control...");
            	break;
            }
            if (choice.equals("1")) {
            	printAirplanes();
            } else if (choice.equals("2")) {
            	printFlights();
            } else if (choice.equals("3")){
            	printAirplane();
            } else {
            	System.out.println("Invalid choice!");
            }
        }
	}
	private void printAirplanes() {
		this.flightControl.getAirplanes().forEach(p -> System.out.println(p));
		System.out.println();
	}
	private void printFlights() {
		this.flightControl.getFlights().forEach(f -> System.out.println(f));
		System.out.println();
	}
	private void printAirplane() {
		System.out.print("Input Airplane ID: ");
    	Airplane airplane = askForAirplane();
    	System.out.println(airplane);
    	System.out.println();
	}
}
