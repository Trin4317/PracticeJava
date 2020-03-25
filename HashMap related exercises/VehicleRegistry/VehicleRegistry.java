import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
	private HashMap<LicensePlate, String> owners = new HashMap<>();
	
	public boolean add(LicensePlate licensePlate, String owner) {
		if (this.owners.containsKey(licensePlate) && !(this.owners.get(licensePlate) == "")) {
			System.out.println(licensePlate + " is already owned by different person!");
			return false;
		}
		this.owners.put(licensePlate,owner);
		System.out.println("Added " + licensePlate + " successfully!");
		return true;
	}
	
	public String get(LicensePlate licensePlate) {
		return this.owners.get(licensePlate);
	}
	
	public boolean remove(LicensePlate licensePlate) {
		if (!(this.owners.containsKey(licensePlate))){
			System.out.println(licensePlate + " does not exist!");
			return false;
		} 
		this.owners.remove(licensePlate);
		System.out.println("Removed " + licensePlate + " from vehicle registry!");
		return true;
	}
	
	public void printLicensePlates() {
		for (LicensePlate listOfPlates: this.owners.keySet()) {
			System.out.println(listOfPlates);
		}
	}
	
	public void printOwners() {
		ArrayList<String> listOfOwners = new ArrayList<>();
		for (String owner: this.owners.values()) {
			if (listOfOwners.contains(owner)) {
				continue;
			}
			listOfOwners.add(owner);
			System.out.println(owner);
		}
	}
	public static void main(String[] args) {
    	LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FI", "UXE-465");
        LicensePlate li3 = new LicensePlate("D", "B WQ-431");

        /*Part 1
        ArrayList<LicensePlate> finnishPlates = new ArrayList<>();
        finnishPlates.add(li1);
        finnishPlates.add(li2);

        //try making a duplicate LicensePlate instance and add it to ArrayList
        LicensePlate newLi = new LicensePlate("FI", "ABC-123");
        if (!finnishPlates.contains(newLi)) {//ArrayList's contains() method iterates every item in the list
            finnishPlates.add(newLi);		//and compare them to the argument using overwritten equals() method
        }
        System.out.println("Finnish plates: " + finnishPlates);
        // if the equals-method hasn't been overwritten, the same license number will be added to the list again

        HashMap<LicensePlate, String> owners = new HashMap<>();
        owners.put(li1, "Arto");
        owners.put(li3, "Jürgen");

        System.out.println("List of owners:");
        System.out.println(owners.get(new LicensePlate("FI", "ABC-123")));
        System.out.println(owners.get(new LicensePlate("D", "B WQ-431")));
        // if the hasCode-method hasn't been overwritten, the owners won't be found
        */
        
        /*Part 2*/
        VehicleRegistry registry = new VehicleRegistry();
        registry.add(li1,"Artour");
        registry.add(li3,"John");
        registry.add(li1,"Tommy");
        
        System.out.println();
        System.out.println("Owner of " + li3 + " is " + registry.get(li3) + "\n");
        
        registry.remove(li1);
        registry.remove(li1);
        registry.add(li2,"Tommy");
        
        registry.printLicensePlates();
        System.out.println();
        registry.printOwners();
    }
}
