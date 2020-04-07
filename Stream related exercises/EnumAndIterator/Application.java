import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		Person a = new Person("John",Education.PHD);
		Person b = new Person("Tim",Education.HS);
		List<Person> listOfAB = new ArrayList<>();
		listOfAB.add(a);
		listOfAB.add(b);

		Employees listOfEmployees = new Employees();
		listOfEmployees.add(new Person("Mark",Education.BA));
		listOfEmployees.add(new Person("Alice",Education.MA));
		listOfEmployees.add(listOfAB);
		listOfEmployees.add(new Person("Tiffany",Education.HS));
		listOfEmployees.add(new Person("Edward",Education.PHD));
		listOfEmployees.add(new Person("Phillip",Education.MA));
		listOfEmployees.add(new Person("Joana",Education.BA));
		
		System.out.println("List of all employees: ");
		listOfEmployees.print();
				
		System.out.println("\nList of employees with PHD education: ");
		listOfEmployees.print(Education.PHD);
		
		System.out.println("\nList of employees with HS education: ");
		listOfEmployees.print(Education.HS);
		
		System.out.println("\nRemoved employees with BA education: ");
		listOfEmployees.fire(Education.BA);
		listOfEmployees.print();
	}
}
