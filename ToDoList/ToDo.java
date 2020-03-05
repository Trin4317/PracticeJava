import java.util.ArrayList;
public class ToDo {
	private ArrayList<String> toDoList;//ArrayList that stores String type object
	public ToDo() {
		this.toDoList = new ArrayList<>();
	}
	public void add(String s) {//custom made .add method for ToDo object
		this.toDoList.add(s);//premade .add method of ArrayList object
	}
	public void print() {//print all available objects in Array
		for (int i = 1; i<= this.toDoList.size(); i++) {
			System.out.println("Task " + i + ": " + this.toDoList.get(i-1));
		}
	}
	public void remove(int index) {//remove object from Array based on index from users' input
		this.toDoList.remove(index - 1);
	}
	public boolean isEmpty() {//custom made .isEmpty method for ToDo object
		return toDoList.isEmpty();//premade .isEmpty method of ArrayList object
	}
}
