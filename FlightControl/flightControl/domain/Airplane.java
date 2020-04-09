package flightControl.domain;

public class Airplane {
	private String planeID;
	private int planeCapacity;
	public Airplane(String planeID, int planeCapacity) {
		this.planeID = planeID;
		this.planeCapacity = planeCapacity;
	}
	@Override
	public String toString() {
		return this.planeID + " (" + this.planeCapacity + " capacity)";
	}
}
