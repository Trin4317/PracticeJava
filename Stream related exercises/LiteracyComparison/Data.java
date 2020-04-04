
public class Data {
	private String country;
	private String gender;
	private int year;
	private double percent;
	public Data(String country, String gender, int year, double percent) {
		this.country = country;
		this.gender = gender;
		this.year = year;
		this.percent = percent;
	}
	public double getPercent() {
		return this.percent;
	}
	public String toString() {
		return this.country + " (" + this.year + "), " + this.gender + ", " + this.percent;
	}
}
