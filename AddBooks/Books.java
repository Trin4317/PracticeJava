
public class Books {
	private String name;
	private int year;
	public Books(String s,int i) {
		this.name = s;
		this.year = i;
	}
	public boolean equals(Object compared) {
		if (this == compared) {
			return true;//if both objects refer to the same location
		}
		if (!(compared instanceof Books)) {
			return false;//if compared object is not a Books object
		}
		Books comparedBook = (Books) compared;
		if (this.name.equals(comparedBook.name) && (this.year == comparedBook.year)) {
			return true;
		}
		return false;
	}
	public String toString() {
		return this.name + " is published in " + this.year;
	}
}
