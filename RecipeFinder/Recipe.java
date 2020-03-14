import java.util.ArrayList;
public class Recipe {
	private String name;
	private int time;
	private ArrayList<String> ingredients;
	public Recipe() {
		this.name = "";
		this.time = 0;
		this.ingredients = new ArrayList<>();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setIngredients(String ingredients) {
        this.ingredients.add(ingredients);
    }
	public String getName() {
		return this.name;
	}
	public int getTime() {
		return this.time;
	}
	public ArrayList<String> getIngredients() {
		return this.ingredients;
	}
	public String toString() {
		return this.name + ", cooking time: " + this.time + " minutes, ingredients: " + this.ingredients;
	}
}
