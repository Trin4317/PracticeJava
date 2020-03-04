
public class Person {
	private String name;
	private int height;
	
	public Person(String s, int i) {
		this.name = s;
		this.height = i;
	}
	public int getHeight() {
		return this.height;
	}
	
	public String getName() {
		return this.name;
	}
	public void setHeight(int i) {
		this.height = i;
	}
	public String toString() {
		return this.name + " (" + this.height + " cm)";
	}
}
