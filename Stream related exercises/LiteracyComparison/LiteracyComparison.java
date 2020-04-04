import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
	public static List<Data> compare(String filename){
		List<Data> list = new ArrayList<>();
		try {
			Files.lines(Paths.get(filename)).map(row -> row.split(","))
									.filter(part -> part.length == 6)
									.map(part -> new Data(part[3],part[2].trim().replace(" (%)",""),Integer.valueOf(part[4]),Double.valueOf(part[5])))
									.sorted((p1,p2) -> (p1.getPercent() > p2.getPercent()? 1: (p1.getPercent() == p2.getPercent())? 0: -1))
									.forEach(data -> list.add(data));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println("Literacy rate in ascending order based on country, gender and year:");
		compare("literacy.csv").forEach(l -> System.out.println(l));
	}
}
