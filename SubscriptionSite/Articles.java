import java.util.ArrayList;
public class Articles {
	static ArrayList<String> mainArticle = new ArrayList<String>();
	static ArrayList<Integer> priorityArticle = new ArrayList<Integer>();
	
	public static void addArticle(String s,int n) {
		mainArticle.add(s);
		priorityArticle.add(n);
	}
	public static void removeArticle(int n) {
		mainArticle.remove(n-1);
		priorityArticle.remove(n-1);
	}
	public static void editArticle(int index, String s,int n) {
		mainArticle.set(index-1,s);
		priorityArticle.set(index-1,n);
	}
	public static void checkArticle() {
		System.out.println("Here are "
				+ "the available articles: ");
		for (int i = 1; i <= mainArticle.size(); i++) {
			System.out.println("Article number " + i + " " + (mainArticle.get(i-1)) + " has priority of " + (priorityArticle.get(i-1)));
		}
		System.out.println();
	}
	public static String viewArticle(int index, int i) {
		if ( Users.priorityUser.get(i-1) >= priorityArticle.get(index-1)){
			return mainArticle.get(index-1);
		} return null;
	}
	
}
