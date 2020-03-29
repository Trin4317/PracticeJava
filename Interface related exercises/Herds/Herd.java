import java.util.ArrayList;

public class Herd implements Movable {
	private ArrayList<Movable> herd;
	public Herd() {
		this.herd = new ArrayList<>();
	}
	public void addToHerd(Movable movable) {
		this.herd.add(movable);
	}
	@Override
	public String toString() {
		String s = "";
		for (Movable m: this.herd) {
			s = s + m + "\n"; 
		}
		return s;
	}
	@Override
	public void move(int dx, int dy) {//move every member of the herd
		for (Movable m: this.herd) {
			m.move(dx, dy);
		}
	}

}
