/*Require user to choose a name list from name.txt or other-name.txt
then check whether names entered by user are on the guest list
name.txt includes {ada, arto, leena, test, , skip}
other-name.txt includes {leo, jarmo, alicia}
*/
import java.util.*;
import java.nio.file.Paths;

public class ReadAFile {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<>();
		System.out.println("Name of the file: ");
		String s = scanner.nextLine();
		try(Scanner reader = new Scanner(Paths.get(s))){
			//read all the lines of the file then added to an ArrayList
			while (reader.hasNextLine()) {
				nameList.add(reader.nextLine());
			}
				
			System.out.println("Enter name, an empty line quits.");
			while (true) {
				String z = scanner.nextLine();
				//read the file until all lines have been read
				if (z.isEmpty()) break;
				int flag = 0;
				for (String nameL:nameList) {
					if (z.equals(nameL)) {
						System.out.println("The name is on the list");
						flag = flag + 1;
						break;
					}
					//if match is found, end the for loop
					//if match is not found yet, print the previous element of ArrayList
					System.out.println(nameL);
				}
				if (flag == 0) {
					System.out.println("The name is not on the list");
					}
			}
			System.out.println("Thank you!");
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		scanner.close();
	}
}
