/*A program that first prompts the user for the name of the file they want to read
then prints the content of the file
The file is data.txt that has CSV-format, contains name and age separated by commas
*/
import java.util.Scanner;
import java.nio.file.Paths;
public class ReadRecordsFromCSVformat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name of the file: ");
		String fileName = scanner.nextLine();
		//read the file that has the same name as user's input
		try(Scanner reader = new Scanner(Paths.get(fileName))){
			while (reader.hasNextLine()) {
				String fileContent = reader.nextLine();
				//separate name and age by comma 
				String[] fileData = fileContent.split(",");
				String name = fileData[0];
				int age = Integer.valueOf(fileData[1]);
				//if age is 1 then print year instead of years
				System.out.println("Name is " + name + ", age: " + age + (age > 1?" years":" year"));
			}
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		scanner.close();
	}
}
