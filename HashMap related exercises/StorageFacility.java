//Create a class called StorageFacility that can be used to keep track of storage units and their contents

import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
	private HashMap<String, ArrayList<String>> storage;
	public StorageFacility() {
		this.storage = new HashMap<>();
	}
	public void add(String storageUnit, String item) {//adds item to the storage unit given as parameter
		//create a new ArrayList if the key is new and doesn't have any value inside
		this.storage.putIfAbsent(storageUnit, new ArrayList<>());
		//add the value into that ArrayList
		this.storage.get(storageUnit).add(item);
	}
	public ArrayList<String> contents(String storageUnit){//returns a list that contains all the items in the storage unit
		return this.storage.get(storageUnit);
	}
	public void remove(String storageUnit, String item) {//removes the given item from the given storage unit
		this.storage.get(storageUnit).remove(item);
		if (this.storage.get(storageUnit).size() == 0) {//if the storage unit would be empty after the removal, removes the unit
			this.storage.remove(storageUnit);
		}
	}
	public ArrayList<String> storageUnits(){//returns the names of the storage units that aren't empty as a list
		ArrayList<String> list = new ArrayList<>();
		for (String unit:this.storage.keySet()) {
			list.add(unit);
		}
		return list;
	}
	public static void main(String[] args) {
		StorageFacility facility = new StorageFacility();
		facility.add("a14", "ice skates");
		facility.add("a14", "ice hockey stick");
		facility.add("a14", "ice skates");

		facility.add("f156", "rollerblades");
		facility.add("f156", "rollerblades");

		facility.add("g63", "six");
		facility.add("g63", "pi");

		System.out.println(facility.contents("a14"));
		System.out.println(facility.contents("f156"));
		
		facility.remove("f156", "rollerblades");
		System.out.println(facility.contents("f156"));
		facility.remove("f156", "rollerblades");
		System.out.println(facility.contents("f156"));
		
		System.out.println(facility.storageUnits());
	}
}
