public class LicensePlate {

    // these instance variables have been defined as final, meaning
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }
    
    @Override
    public boolean equals(Object compared) {
    	if (this == compared) {
    		return true;
    	}
    	if (!(compared instanceof LicensePlate)) {
    		return false;
    	}
    	LicensePlate comparedPlate = (LicensePlate) compared;
    	if (this.liNumber.equals(comparedPlate.liNumber) && this.country.equals(comparedPlate.country)) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public int hashCode() {
    	if (this.liNumber == null) {
    		return -1;
    	}
    	return this.liNumber.hashCode() + this.country.hashCode(); 
    }
}