
public class Human /*implements Comparable<Human>*/{
	private String name;
	private int salary;
	public Human(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return this.name;
	}
	public int getSalary() {
		return this.salary;
	}
	public String toString() {
		return this.name + "'s salary is: " + this.salary;
	}
	/*
	@Override
	public int compareTo(Human compared) {
		//if we want to sort based on int variable salary
		//for ascending order, if this (compared object) > parameter (base) then compareTo() needs to return positive value 
		//return (this.salary > compared.salary? -1 : ((this.salary == compared.salary)? 0: 1));
		
		//if we want to sort based on String variable name
		//we can reuse default String.compareTo() method
		return (this.name.compareTo(compared.name)); //swap this and compared instances to sort in descending order
	}
	*/
}
