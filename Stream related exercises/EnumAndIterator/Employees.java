import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
	private List<Person> employeeList;
	
	public Employees() {
		this.employeeList = new ArrayList<>();
	}
	
	public void add(Person employee) {
		this.employeeList.add(employee);
	}
	
	public void add(List<Person> employees) {
		for (Person e:employees) {
			this.employeeList.add(e);
		}
	}
	
	public void print() {
		Iterator<Person> iterator = this.employeeList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void print(Education education) {
		Iterator<Person> iterator = this.employeeList.iterator();
		while (iterator.hasNext()) {
			/* this code would not work because every time we call iterator.next(), the index will increase by one
			 * which leads to getting the incorrect object
			if (iterator.next().getEducation().equals(education)) {
				System.out.println(iterator.next());
			}
			*/
			// instead we assign next index in Iterator to an independent object and check if it fits requirement
			Person nextPerson = iterator.next();  
			if (nextPerson.getEducation().equals(education)) {
				System.out.println(nextPerson);
			}
		}
	}
	
	public void fire(Education education) {
		Iterator<Person> iterator = this.employeeList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getEducation().equals(education)) {// move the index forward by one
				iterator.remove();// then remove that index
			}
		}
	}
}
