import java.util.ArrayList;
public class Hold {
	private ArrayList<Suitcase> suitcases = new ArrayList<>();
	private final int maxWeight;
	private int curWeight;
	public Hold(int i) {
		this.maxWeight = i;
		this.curWeight = 0;
	}
	public void addSuitcase(Suitcase suitcase) {	//if total weight exceeds maximum weight limit
		if (!(this.curWeight + suitcase.totalWeight() > this.maxWeight)){//do not add new suitcase
			this.suitcases.add(suitcase);
			this.curWeight += suitcase.totalWeight();
		}	
	}
	public String toString() {//format the statement in proper English
		if (this.suitcases.size() != 0) {
			if (this.suitcases.size() == 1) {
				return this.suitcases.size() + " suitcase (" + this.curWeight + " kg)"; 
			}
			return this.suitcases.size() + " suitcases (" + this.curWeight + " kg)";
		}
		return "no suitcase";
	}
	public void printItems() {//prints all the items contained in the hold's suitcases
		for (Suitcase s:this.suitcases) {
			s.printItems();//prints all the items in the corresponding suitcase
		}
	}
}
