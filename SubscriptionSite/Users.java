import java.util.ArrayList;
public class Users {
	static ArrayList<String> mainUser = new ArrayList<String>();
	static ArrayList<Integer> priorityUser = new ArrayList<Integer>();
	public static void addUser(String s,int n) {
		mainUser.add(s);
		priorityUser.add(n);
		System.out.println("Thank you " + s + "! You just made a free account.");
	}
	public static void editName(int index, String s) {
		mainUser.set(index-1,s);
	}
	public static void editPriority(int index, int n) {
		priorityUser.set(index-1,n);
	}
	public static String getName(int i) {
		return mainUser.get(i-1);
	}
	public static void checkUser() {
		System.out.println("Here are the available users: ");
		for (int i = 1; i <= mainUser.size(); i++) {
			System.out.println("User number " + i + " " + (mainUser.get(i-1)) + " has priority of " + (priorityUser.get(i-1)));
		}
		System.out.println();
	}
}
