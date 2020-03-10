import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Application {
	public static ArrayList<Integer> inputGrade(){
		String testStatistic = "-42\n" + "24\n" + "42\n" + "72\n"+ "80\n" + "52\n" + "-1\n";
		String testStatistic2 = "49\n" + "48\n" + "47\n" + "-1\n";
		Scanner scanner = new Scanner(testStatistic);//use input from above String variable
		ArrayList<Integer> gradeList = new ArrayList<>();
		System.out.println("Please input grade of each student: (-1 to stop)");
		while (true) {
			String grade = scanner.nextLine();
			int gradeInt = Integer.valueOf(grade);
			if (gradeInt == -1) {break;}//input -1 will stop this method
			if (gradeInt >= 0 && gradeInt <= 100) {
				gradeList.add(gradeInt);//only accept scores from [0;100] range
			}
		}
		scanner.close();
		System.out.println(gradeList);
		return gradeList;
	}
	public static double calAverage(ArrayList<Integer> list) {//calculate the average of all valid scores 
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum/list.size();
	}
	public static ArrayList<Integer> getPassGrade(ArrayList<Integer> list){//Be careful that this method will modify the original ArrayList after execute
		Iterator<Integer> itr = list.iterator();//Remove Object From ArrayList using Iterator
		while (itr.hasNext()) {
			Integer number = itr.next();
			if (number < 50) {//remove scores below 50 from the list
				itr.remove();//using list.remove(number) will throw a ConcurrentModificationException
			}
		}
		return list;
	}
	public static double calAveragePassGrade(ArrayList<Integer> list) {//calculate the average of all passing scores
		ArrayList<Integer> listPass = new ArrayList<Integer>(list);
		getPassGrade(listPass);//need to run this method on another copy of list, or the original list will be modified
		if (listPass.size() == 0) return -1;//return -1 when there is no passing score in the list
		return calAverage(listPass);
	}
	public static double calPassPercent(ArrayList<Integer> list) {
		ArrayList<Integer> listPass = new ArrayList<Integer>(list);
		getPassGrade(listPass);//need to run this method on another copy of list, or the original list will be modified
		double total = list.size();//total amount of scores
		double pass = listPass.size();//total amount of passing scores
		return pass * 100 / total;
	}
	public static int[] calRank(ArrayList<Integer> list) {
		int[] rank = {0,0,0,0,0,0};//ranking from Best to Worst
		for (Integer l:list) {
			if (l >= 90) {
				rank[0] += 1;
			} else if (l >= 80) {
				rank[1] += 1;
			} else if (l >= 70) {
				rank[2] += 1;
			} else if (l >= 60) {
				rank[3] += 1;
			} else if (l >= 50) {
				rank[4] += 1;
			} else rank[5] += 1;
		}
		return rank;
	}
	public static void showRank(int[] rank) {
		System.out.println("Grade distribution:");
		String[] rankName = {"A (>=90)","B (>=80)","C (>=70)","D (>=60)","E (>=50)","F (< 50)"};
		for (int i = 0; i < 6; i ++) {
			System.out.print("Rank " + rankName[i] + ": ");
			for (int j = 0; j < rank[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> studentGrade = new ArrayList<Integer>(inputGrade());
		System.out.println("Point average (all): " + calAverage(studentGrade));
		System.out.println("Point average (passing): " + 
				(calAveragePassGrade(studentGrade) == -1? "-" :calAveragePassGrade(studentGrade)));
		System.out.println("Pass percentage is " + calPassPercent(studentGrade) +"%");
		showRank(calRank(studentGrade));
	}
}
