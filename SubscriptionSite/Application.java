import java.util.*;
public class Application {
	public static void printArticle(String s, String n) {
		if (s != null) {
			System.out.println("Thank you " + n + "! Here is your article: " + s);
		} else System.out.println("Sorry " + n + "! You can not view this article.");
	}
	public static void welcomeScreen() {
		System.out.println("Welcome to our Database!");
		System.out.println("------------------------");
		System.out.println("1. Check available articles");
		System.out.println("2. Check current users");
		System.out.println("3. Make new account");
		System.out.println("4. Edit your name");
		System.out.println("5. Purchase new subscription");
		System.out.println("6. Read an article");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Articles.addArticle("Mr Robot",3);
		Articles.addArticle("Dark",1);
		Articles.addArticle("Utopia",3);
		Articles.editArticle(3,"Sherlock",2);
		Articles.addArticle("Breaking Bad",3);
		Articles.addArticle("Utopia",2);
		
				
		Users.addUser("John",1);
		Users.addUser("Tim",2);
		Users.addUser("Kimberly",1);
		
		welcomeScreen();
		while(true) {
			System.out.println("Please choose an option: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Articles.checkArticle();
				break;
			case 2:
				Users.checkUser();
				break;
			case 3:
				System.out.println("What is your name: ");
				scanner.nextLine();
				String usName1 = scanner.nextLine();
				Users.addUser(usName1, 1);
				//Users.checkUser();
				break;
			case 4:
				System.out.println("What is your ID: ");
				int usID1 = scanner.nextInt();
				System.out.println("Input your new name: ");
				scanner.nextLine();
				String usName2 = scanner.nextLine();
				Users.editName(usID1, usName2);
				//Users.checkUser();
				break;
			case 5:
				System.out.println("What is your ID: ");
				int usID2 = scanner.nextInt();
				System.out.println("Please choose your new subscription: ");
				int usPri = scanner.nextInt();
				Payment.makePayment(usID2, usPri);
				break;
			case 6:
				System.out.println("What is your ID: ");
				int usID3 = scanner.nextInt();
				System.out.println("What article do you want to read: ");
				int artID = scanner.nextInt();
				printArticle(Articles.viewArticle(artID, usID3), Users.getName(usID3));
				break;
			default:
				System.out.println("Invalid choice!");
			}
			System.out.println("Continue?");
			char confirm = scanner.next().charAt(0);
			if (confirm == 'n') {
				System.out.println("Thank you and see you again!");
				break;
			}
		}
		scanner.close();
	}
}
