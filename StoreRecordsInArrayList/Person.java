
public class Person {
	private String name;
	private int age;
	public Person(String s,int i){
		this.name = s;
		this.age = i;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	@Override
	public String toString() {
		return "Name is " + getName() + ", age: " + getAge() + (getAge()>1?" years":" year");
	}
}
