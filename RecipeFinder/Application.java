/* Create a program that allows searching for cooking recipes based on their name, cooking time,
 * or the name of an ingredient. The program should read the recipes from a non-CSV file that user provides.
 * 
 * There can be many recipes in a single file. Each recipe consists of three or more rows in the file. 
 * The first row is the name of the recipe, the second row is cooking time,
 * the third and possibly following rows list the ingredients used in the recipe.
 * An empty row marks the end of current recipe.
 */
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Application {
	public static String getFile(Scanner scanner) {
		System.out.println("File to read:");
		String fileName = scanner.nextLine();
		return fileName;
	}
	
	public static ArrayList<Recipe> readFile(String name) {
		ArrayList<Recipe> recipeList = new ArrayList<>();
        try (Scanner reader = new Scanner(Paths.get(name))){
            ArrayList<String> ingredients = new ArrayList<>();
            int lineIndex = 0;
            Recipe recipe = new Recipe();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.equals("") || !reader.hasNextLine()) {
                	recipeList.add(recipe);
                    //reset the temporary variables and objects
                    recipe = new Recipe();
                    ingredients.clear();
                    lineIndex = 0;
                    continue;
                } else if (lineIndex == 0) {
                    recipe.setName(line);
                } else if (lineIndex == 1) {
                    recipe.setTime(Integer.valueOf(line));
                } else {
                	recipe.setIngredients(line);
                }
                lineIndex += 1;
            } 
        }
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return recipeList;	
	}
	
	public static void start(Scanner scanner,ArrayList<Recipe> recipeList) {
		System.out.println("Commands:\n" + "list - lists the recipes\n" + "stop - stops the program\n" 
				+ "find name - searches recipes by name\n" 
				+ "find cooking time - searches recipes by cooking time\n" 
				+ "find ingredient - searches recipes by ingredient\n");
		while(true) {
			System.out.print("Enter command:");
			String cmd = scanner.nextLine();
			if (cmd.equals("list")) {
				list(recipeList);
			} else if (cmd.equals("stop")) {
				System.exit(0);
			} else if (cmd.equals("find name")) {
				findName(scanner,recipeList);
			} else if (cmd.equals("find cooking time")){
				findTime(scanner,recipeList);
			} else if (cmd.equals("find ingredient")) {
				findIngredient(scanner,recipeList);
			}
			System.out.println();
		}	
	}
	
	public static void list(ArrayList<Recipe> recipeList) {
		for (Recipe r:recipeList) {
			System.out.println(r);
		}
	}
	
	public static void findName(Scanner scanner,ArrayList<Recipe> recipeList) {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		for (Recipe r:recipeList) {
			if (r.getName().toLowerCase().contains(name.toLowerCase())) {
				System.out.println(r);
			}
		}
	}
	
	public static void findTime(Scanner scanner,ArrayList<Recipe> recipeList) {
		System.out.print("Time: ");
		String time = scanner.nextLine();
		for (Recipe r:recipeList) {
			if (r.getTime() == Integer.valueOf(time)) {
				System.out.println(r);
			}
		}
	}
	
	public static void findIngredient(Scanner scanner,ArrayList<Recipe> recipeList) {
		System.out.print("Ingredient: ");
		String ingredient = scanner.nextLine();
		for (Recipe r:recipeList) {
			for (String i:r.getIngredients()) {
				if (i.equals(ingredient)) {
					System.out.println(r);
					break;//iterate next r after finding a match on current r
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Recipe> recipeList = readFile(getFile(scanner));
		
		start(scanner,recipeList);
	}
}
