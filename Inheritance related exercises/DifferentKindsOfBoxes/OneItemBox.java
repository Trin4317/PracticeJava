import java.util.ArrayList;
//This class can only hold 1 item
public class OneItemBox extends Box {
	private ArrayList<Item> itemList;
	public OneItemBox() {
		this.itemList = new ArrayList<>();
	}
	@Override
	public void add(Item item) {
		if (this.itemList.size() == 1) {
			return;
		} else {
			this.itemList.add(item);
		}
	}
	
	@Override
	public boolean isInBox(Item item) {
		if (this.itemList.contains(item)) {
			return true;
		} 
		return false;
	}
}
