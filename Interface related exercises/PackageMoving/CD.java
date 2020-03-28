
public class CD implements Packable {
	private String artist;
	private String album;
	private int year;
	private double weight;
	public CD(String artist, String album, int year) {
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.weight = 0.1;
	}
	@Override
	public double weight() {
		return this.weight;
	}
	public String toString() {
		return this.artist + ": " + this.album + " (" + this.year + ")";
	}
}
