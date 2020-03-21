import java.util.HashMap;

public class IOU {
	HashMap<String,Double> IOweYou;
	public IOU() {
		this.IOweYou = new HashMap<>();
	}
	public void setSum(String toWhom,double amount) {
		/*
		if (!this.IOweYou.containsKey(toWhom)) {
			this.IOweYou.put(toWhom,0.0);//if Key doesn't exist then create a new entry
		}
		double amountOwed = this.IOweYou.get(toWhom);//get the Value from Key passed as toWhom parameter
		*/
		double amountOwed = this.IOweYou.getOrDefault(toWhom,0.0);//use getOrDefault method of HashMap to return 0 if value doesn't exist
		amountOwed += amount;
		this.IOweYou.put(toWhom,amountOwed);//
	}
	public double howMuchDoIOweTo(String toWhom) {
		/*
		if (!this.IOweYou.containsKey(toWhom)) {
			return 0.0;
		}
		return this.IOweYou.get(toWhom);
		*/
		return this.IOweYou.getOrDefault(toWhom,0.0);//use getOrDefault method of HashMap to return 0 if value doesn't exist
	}
	public void printIOU(String toWhom) {
		if (howMuchDoIOweTo(toWhom) == 0.0) {
			System.out.println("I don't owe any money to " + toWhom);
		} else {
			System.out.println("The amount I current owe to " + toWhom + " is: " + howMuchDoIOweTo(toWhom) + " dollars");
		}
	}
	public static void main(String[] args) {
		IOU myIOU = new IOU();
		myIOU.setSum("Arthur", 51.5);
		myIOU.setSum("Michael", 30);

		myIOU.printIOU("Arthur");
		myIOU.printIOU("Michael");
		myIOU.printIOU("James");

	}
}
