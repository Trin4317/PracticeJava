
public class Team {
	private String homeTeam,visitTeam;
	private int homeScore,visitScore;
	public Team(String a,String b,int c,int d) {
		this.homeTeam = a;
		this.visitTeam = b;
		this.homeScore = c;
		this.visitScore = d;
	}
	public int getHomeScore() {
		return this.homeScore;
	}
	public int getVisitScore() {
		return this.visitScore;
	}
	public String getHome() {
		return this.homeTeam;
	}
	public String getVisit() {
		return this.visitTeam;
	}
}
