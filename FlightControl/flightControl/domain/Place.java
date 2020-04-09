package flightControl.domain;

public class Place {
	private String placeID;
	public Place(String placeID) {
		this.placeID = placeID;
	}
	@Override
	public String toString() {
		return this.placeID;
	}
}
