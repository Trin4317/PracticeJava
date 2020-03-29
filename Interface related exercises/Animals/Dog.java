
public class Dog extends Animal implements Noise {
	public Dog() {
		super("Dog");
	}
	public Dog(String name) {
		super(name);
	}
	public void makeNoise() {
		System.out.println(this.getName() + " barks");
	}
}
