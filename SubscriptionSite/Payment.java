
public class Payment {
	public static void makePayment(int index,int pri) {
		Users.editPriority(index,pri);
		System.out.println("Thank you " + Users.getName(index) + " for your subscribing! You now have priority of " + pri);
	}
}
