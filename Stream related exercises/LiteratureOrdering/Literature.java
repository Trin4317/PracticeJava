
public class Literature {
	private String name;
	private int age;
	public Literature(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String toString() {
		return this.name + " (recommended for " + this.age + "+ years old)";
	}
}
