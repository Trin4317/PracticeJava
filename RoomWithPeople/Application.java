
public class Application {
	public static void main(String[] args) {
		//part 1: creating Room class with ArrayList of Person as instance variable
		//with parameterless constructor, add(), isEmpty, getPeople() methods
		Room room = new Room();
		System.out.println("Shortest: " + room.shortest());
		System.out.println("Empty room? " + room.isEmpty());
		room.addPerson(new Person("Lea", 183));
		room.addPerson(new Person("Kenya", 182));
		room.addPerson(new Person("Auli", 186));
		room.addPerson(new Person("Nina", 172));
		room.addPerson(new Person("Terhi", 185));
		System.out.println("Empty room? " + room.isEmpty());

		System.out.println("");
		for (Person person : room.getPeople()) {
		    System.out.println(person);
		}
		//part 2: add shortest() method which returns the shortest person in the room
		//if the room is empty, a null reference is returned
		//this method will not remove any person from the room
		System.out.println("");
		System.out.println("Getting shortest person: " + room.shortest());
		System.out.println("");
		for (Person person : room.getPeople()) {
		    System.out.println(person);
		}
		//part 3: add take() method which takes the shortest person out of the room
		//if the room is empty, a null reference is returned
		System.out.println();
		System.out.println("Removing shortest person: " + room.take());
		System.out.println("Remaining people in the room:");
		
		for (Person person : room.getPeople()) {
		    System.out.println(person);
		}
		System.out.println("\nRemoving everyone based on height's order\n");
		while (!room.isEmpty()) {
		    System.out.println("Removing: " + room.take());
		}
	}
}
