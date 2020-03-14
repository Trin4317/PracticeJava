
public class Bird {
	private String name;
	private String latinName;
	private int obsCount;
	public Bird(String name, String latinName) {
		this.name = name;
		this.latinName = latinName;
		this.obsCount = 0;
	}
	public String getName() {
		return this.name;
	}
	public String getLatinName() {
		return this.latinName;
	}
	public int getCount() {
		return this.obsCount;
	}
	public void addCount() {
		this.obsCount += 1;
	}
	public String toString() {
		return this.name + " (" + this.latinName + "): " + this.obsCount + ((this.obsCount > 1)?" observations":" observation");
	}
}
