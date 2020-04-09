package flightControl.logic;

import java.util.Collection;
import java.util.HashMap;

import flightControl.domain.Airplane;
import flightControl.domain.Flight;
import flightControl.domain.Place;

public class FlightControl {
	private HashMap<String, Airplane> airplanes;
	private HashMap<String, Place> places;
	private HashMap<String, Flight> flights;
	// We use HashMap to store values of Airplane, Place and Flight to prevent creating duplicate value
	// and allow searching value easily with unique key
	public FlightControl() {
		this.airplanes = new HashMap<>();
		this.places = new HashMap<>();
		this.flights = new HashMap<>();
	}
	// There are multiple airplanes at a single airport
	// We use planeID as a key to store an Airplane object (which has information about it's own ID and capacity)
	public void addPlane(String planeID, int planeCapacity) {
		this.airplanes.put(planeID, new Airplane(planeID,planeCapacity));
	}
	// There are also multiple flights from and to a single airport
	// At first we register location if it hasn't existed in Places HashMap yet
	// The key for it would be location's name in String format, and value is Place object
	// Then we create a Flight object by using Airplane object given as argument, and 2 values from Place HashMap
	// Finally, we put this Flight object into Flights HashMap, and use its toString() method value as a key
	public void addFlight(Airplane plane, String departure, String destination) {
		this.places.putIfAbsent(departure, new Place(departure));
		this.places.putIfAbsent(destination, new Place(destination));
		
		Flight flight = new Flight(plane, this.places.get(departure), this.places.get(destination));
		this.flights.put(flight.toString(), flight);
	}
	// Return a Collection of values from Airplanes and Flights HashMap
	public Collection<Airplane> getAirplanes(){
		return this.airplanes.values();
	}
	public Collection<Flight> getFlights(){
		return this.flights.values();
	}
	// Return a single value from Airplanes HashMap
	public Airplane getAirplane(String planeID) {
		return this.airplanes.get(planeID);
	}
}
