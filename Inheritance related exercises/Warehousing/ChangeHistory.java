import java.util.ArrayList;
public class ChangeHistory {
	private ArrayList<Double> history;
	public ChangeHistory() {
		this.history = new ArrayList<>();
	}
	public void add(double status) {
		this.history.add(status);
	}
	public void clear() {
		this.history.clear();
	}
	public double maxValue() {
		if (this.history.isEmpty()) {
			return 0;
		}
		double max = 0;
		for (double d: this.history) {
			if (d > max) {
				max = d;
			}
		}
		return max;
	}
	public double minValue() {
		if (this.history.isEmpty()) {
			return 0;
		}
		double min = this.history.get(0);
		for (double d: this.history) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}
	public double average() {
		if (this.history.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for (double d: this.history) {
			sum += d;
		}
		return sum/this.history.size();
	}
	public String toString() {
		return this.history.toString();
	}
}
