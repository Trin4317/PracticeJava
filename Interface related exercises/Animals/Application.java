import java.util.ArrayList;
public class Application {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.makeNoise();
		dog.eat();

		Dog fido = new Dog("Fido");
		fido.makeNoise();
		System.out.println();
		
		Cat cat = new Cat();
		cat.makeNoise();
		cat.sleep();

		Cat garfield = new Cat("Garfield");
		garfield.makeNoise();
		System.out.println();
		
		ArrayList<Noise> animal = new ArrayList<>();
		animal.add(dog);
		animal.add(cat);
		animal.add(fido);
		animal.add(garfield);
		for (Noise n:animal) {
			n.makeNoise();
		}
	}
}
