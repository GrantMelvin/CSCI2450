package assg9_melvinm19;

public class Customer extends KeyedItem<String> {

	// Traits of a customer to go along with key
	private String name ;
	private String phone ;
	
	/*
	 * Constructor for a customer when only given a key
	 * @param	key		the ID of a customer
	 */
	public Customer(String key) {
		super(key);
	}
	
	/*
	 * Constructor for a customer when given a key, name, and phone number
	 * @param	key			the ID of a customer
	 * @param	name		the name of a customer
	 * @param	phone		the phone number of a customer
	 */
	public Customer(String key, String name, String phone) {
		super(key);
		this.name = name ; 
		this.phone = phone ;
	}
	
	/*
	 * Changes the name of the selected customer to the name passed by parameter
	 * @param	name	the name we want to change the customer to
	 */
	public void setName(String name) {
		this.name = name ;
	}
	
	/*
	 * Changes the phone number of the selected customer to the name passed by parameter
	 * @param	phone	the phone number we want to change the customer to
	 */
	public void setPhone(String phone) {
		this.phone = phone ;
	}
	
	/*
	 * Retrieves the name of the currently selected customer
	 * @return the name of the currently selected customer
	 */
	public String getName() {
		return this.name ;
	}
	
	/*
	 * Retrieves the phone number of the currently selected customer
	 * @return the phone number of the currently selected customer
	 */
	public String getPhone() {
		return this.phone ;
	}
	
	/*
	 * Prints the customer in order of ID, name, and phone number
	 * @return the ID, name, and phne number of the currently selected customer
	 */
	public String toString() { 
		return this.getKey() + "\t" + this.getName() + "\t" + this.getPhone() ;
	}
	
}
