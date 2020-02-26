/* A program that reads data from a CSV file (Name,Category,Price) 
 * then prompt user for any relevant keyword to find correct item
 * and print all available results
 */

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class Application {
	public static ArrayList<Items> readFile(String file) {
		ArrayList<Items> items = new ArrayList<>();
		try (Scanner reader = new Scanner(Paths.get(file))){
			while (reader.hasNextLine()) {
				String fileRecord = reader.nextLine();
				String[] fileElement = fileRecord.split(",");
				items.add(new Items(
						fileElement[0],//name
						fileElement[1],//category
						Integer.valueOf(fileElement[2])//price
					));					
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1);
		}
		return items;
	}
	public static void searchItems(ArrayList<Items> items) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What are you looking for? (Input nothing to skip)");
		System.out.println("Name: ");
		String qName = scanner.nextLine();
			
		System.out.println("Category: ");
		String qCat = scanner.nextLine();
			
		System.out.println("Price from: ");
		String qPriceMin = scanner.nextLine();
		int PriceMin = qPriceMin.isEmpty()? -1 : Integer.valueOf(qPriceMin);
		//if there is no input for Price, set it as -1, else get the value from users' input
		System.out.println("Prince to: ");
		String qPriceMax = scanner.nextLine();
		int PriceMax = qPriceMax.isEmpty()? -1 : Integer.valueOf(qPriceMax);
			
		ArrayList<Items> results = new ArrayList<>();
		for (Items item:items) {										//skips the following items
			if (PriceMin != -1 && item.getPrice() < PriceMin) continue;//items that are cheaper than requirement
			if (PriceMax != -1 && item.getPrice() > PriceMax) continue;//items that are more expensive than requirement
			if (!qCat.isEmpty() && !item.getCategory().equalsIgnoreCase(qCat)) continue;//no category has this name
			if(!qName.isEmpty() && !item.getName().toLowerCase().contains(qName)) continue;//no item has this name
			results.add(item);
		}
		if (results.size() == 0) System.out.println("No result found."); 
		else {
			for (Items result:results) System.out.println(result);
			}
		scanner.close();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a file: ");
		String file = scanner.nextLine();
		searchItems(readFile(file));
		scanner.close();
	}
}
