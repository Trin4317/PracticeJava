import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LiteratureOrdering {
	public static List<Literature> input(Scanner scanner){
		List<Literature> list = new ArrayList<>();
		while(true) {
			System.out.print("Input the name of the book, empty stops: ");
			String name = scanner.nextLine();
			if (name.isEmpty()) {
				System.out.println();
				break;
			}
			System.out.print("Input the age recommendation: ");
			int age = Integer.valueOf(scanner.nextLine());
			list.add(new Literature(name,age));
			System.out.println();
		}
		return list;
	}
	public static void print(List<Literature> list) {
		System.out.println(list.size() + " books in total");
		list.stream().forEach(l -> System.out.println(l));
	}
	public static List<Literature> sortByAge(List<Literature> list){
		Comparator<Literature> comparator = Comparator.comparing(Literature::getAge);
		Collections.sort(list,comparator);
		return list;
	}
	public static List<Literature> sortByAgeReverse(List<Literature> list){
		Comparator<Literature> comparator = Comparator.comparing(Literature::getAge, (l1,l2) -> l2 - l1);
		Collections.sort(list,comparator);
		return list;
	}
	public static List<Literature> sortByAgeAndName(List<Literature> list){
		Comparator<Literature> comparator = Comparator.comparing(Literature::getAge).thenComparing(Literature::getName);
		Collections.sort(list,comparator);
		return list;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Literature> literatureList = input(scanner);
		
		System.out.println("Sorted by Age:");
		print(sortByAge(literatureList));
		
		System.out.println("Sorted by Age in reverse order:");
		print(sortByAgeReverse(literatureList));
		
		System.out.println("sorted by Age and Name");
		print(sortByAgeAndName(literatureList));
	}
}
