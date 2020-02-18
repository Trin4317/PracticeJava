/*	Make a Person class, and StoringRecords class 
  that has a body for the method public static ArrayList<Person> readPeople(String file). 
  	Implement the readPeople method such that it reads the elements 
  (from the file called record.txt in this example) passed as a parameter,
  then returns them in ArrayList.
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class StoringRecords {
	public static ArrayList<Person> readPeople(String file){
		ArrayList<Person> people = new ArrayList<>();
		try (Scanner reader = new Scanner(Paths.get(file))){
			while (reader.hasNextLine()) {
				String dataContent = reader.nextLine();
				String[] lineContent = dataContent.split(",");
				String s = lineContent[0];
				int i = Integer.valueOf(lineContent[1]);
				people.add(new Person(s,i));
			}
		}
		
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return people;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//prompt user to input the name of datafile
		System.out.println("Name of the file: ");
		String dataName = scanner.nextLine();
		//readPeople(dataName); method would return an ArrayList that has
		//people's name and age in each index
		System.out.println("Total amount of people read: " + readPeople(dataName).size());
		//Override toString method of ArrayList in Person.java
		for (Person person:readPeople(dataName)) System.out.println(person.toString());
		scanner.close();
	}
}
