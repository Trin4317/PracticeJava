
public class Cat extends Animal implements Noise {
	public Cat() {
		super("Cat");
	}
	public Cat(String name) {
		super(name);
	}
	public void makeNoise() {
		System.out.println(this.getName() + " purrs");
	}
}
