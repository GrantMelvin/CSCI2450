package activity12;

public class City extends KeyedItem<String>{

	private String countryName ; 
	 
	public City(String key) {
		super(key);
	}

	public City(String key, String countryName) {
		super(key) ;
		this.countryName = countryName ;
	}
	
	public String getCountryName() {
		return this.countryName ;
	}
	
	public String toString() {
		return this.getKey() + ", " + this.countryName ;
	}
}
