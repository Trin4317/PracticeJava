/*Write a program that prompts the user for a filename, after which it reads the match statistics from the file. 
  The program then prompts the user for the name of a team, 
  and prints the data specified in the following parts for that team.
  
  The data file is stored in CSV format. 
  Each line of the file contains the home team, visiting team,
  home team points, and visiting team points, all separated by commas.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class SportStatistics {
	//add the data from .csv file to an ArrayList that uses Team class
	public static ArrayList<Team> readStat(String file){
		ArrayList<Team> teamStats = new ArrayList<>();
		try (Scanner reader = new Scanner(Paths.get(file))){
			while (reader.hasNextLine()) {
				String dataLine = reader.nextLine();
				String[] dataElement = dataLine.split(",");
				String homeTeam = dataElement[0];
				String visitTeam = dataElement[1];
				int homeScore = Integer.valueOf(dataElement[2]);
				int visitScore = Integer.valueOf(dataElement[3]);
				teamStats.add(new Team(homeTeam,visitTeam,homeScore,visitScore)); 
			}
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(0);
		}
		return teamStats;
	}
	//read the data from ArrayList, then print the number of game, win, loss of specific team input by user
	public static void showStat(String dataName, String teamName) {
		int count = 0;
		int win = 0;
		int lose = 0;
		for (Team teamStat:readStat(dataName)) {
			if (teamStat.getHome().equals(teamName) || teamStat.getVisit().equals(teamName)) {
				count = count + 1;
			}
			if ((teamStat.getHome().equals(teamName) && teamStat.getHomeScore() > teamStat.getVisitScore())
					|| (teamStat.getVisit().equals(teamName) && teamStat.getHomeScore() < teamStat.getVisitScore())) {
				win = win + 1;
			}
			if ((teamStat.getHome().equals(teamName) && teamStat.getHomeScore() < teamStat.getVisitScore())
					|| (teamStat.getVisit().equals(teamName) && teamStat.getHomeScore() > teamStat.getVisitScore())) {
				lose = lose + 1;
			}
		}
		System.out.println("Games: " + count);
		System.out.println("Wins: " + win);
		System.out.println("Losses: " + lose);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("File: ");
		String dataName = scanner.nextLine();//get the .csv file name
		readStat(dataName);//make sure the program will stop if error happens
		while(true) {
			System.out.println("Team: ");
			String teamName = scanner.nextLine();//get the team name
			showStat(dataName,teamName);//show the statistic from that team
			System.out.println("Continue?");
			char c = scanner.next().charAt(0);
			if (c == 'n') {
				System.out.println("End.");
				break;
			} else scanner.nextLine();//prevent newline to be put into dataName
		}
		scanner.close();
	}
}
