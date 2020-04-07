
public enum Education {
	PHD("Doctoral degree"),
	MA("Master degree"),
	BA("Bachelor degree"),
	HS("Highschool diploma");
	
	private String degree; // object reference variable
	
	private Education(String degree) { // constructor of enum type must be private
		this.degree = degree;
	}
	
	public String getDegree() {
		return this.degree;
	}
}
