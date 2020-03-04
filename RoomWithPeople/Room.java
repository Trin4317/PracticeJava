import java.util.ArrayList;

public class Room {
	ArrayList<Person> people = new ArrayList<>();
	public Room() {
		this.people = new ArrayList<>();
	}
	public void addPerson(Person p) {
		this.people.add(p);
	}
	public boolean isEmpty() {
		return (this.people.size() == 0);
	}
	public ArrayList<Person> getPeople(){
		return this.people;//returns a list of the people in the room
	}
	public Person shortest() {
		if (this.people.isEmpty()) {
			return null;//if the room is empty, a null reference is returned
		}
		Person shortest = this.people.get(0);
		for (Person p:this.people) {
			if (p.getHeight() < shortest.getHeight()) {
				shortest = p;
			}
		}
		return shortest;
	}
	public Person take() {
		if (this.people.isEmpty()) {
			return null;
		}
		Person p = this.people.get(this.people.indexOf(this.shortest()));
		this.people.remove(this.people.indexOf(this.shortest()));
		return p;
		
	}
}
