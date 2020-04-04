import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WageOrder  {
	public static void main(String[] args) {
		List<Human> list = new ArrayList<>();
		list.add(new Human("John",3000));
		list.add(new Human("Tim",2000));
		list.add(new Human("Hong",6000));
		list.add(new Human("Jack",4000));
		list.add(new Human("Athony",1000));
		
		/*
		//sorting using Comparable interface
		//Note that stream() doesn't modify the List so actual order will remain the same as before 
		list.stream().sorted().forEach(l -> System.out.println(l));
		System.out.println();
				
		//To actually modify the List, we need to use Collections.sort()
		Collections.sort(list);
		list.stream().forEach(l -> System.out.println(l));
		*/
		
		//sorting without using Comparable interface
		//both stream().sorted() and Collections.sort() method can accept lambda expression as parameter that defines sorting criteria
		list.stream().sorted((l1,l2) -> { //l1 is compared object, l2 is base
			return (l1.getSalary() > l2.getSalary()? 1: (l1.getSalary() == l2.getSalary())? 0: -1); //ascending order
		}).forEach(l -> System.out.println(l));
		System.out.println();
		
		list.stream().sorted((l1,l2) -> { //l1 is compared object, l2 is base
			return l2.getName().compareTo(l1.getName()); // reuse String.compareTo() and sort in descending order
		}).forEach(l -> System.out.println(l));
		System.out.println();
		
		Collections.sort(list, (l1,l2) -> (l1.getSalary() > l2.getSalary()? -1: (l1.getSalary() == l2.getSalary())? 0: 1)); //descending order
		list.stream().forEach(l -> System.out.println(l));
		
	}
}
