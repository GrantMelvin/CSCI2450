/*
 * @author Grant Melvin
 * Class made to hold savings accounts to be tested in the AccountTest class
 */
package assg3_melvinm19;

public class SavingsAccount extends Account {

	private double interestRate ;
	
	/*
	 * Constructor used for one-parameter version for the savings account object with one parameter
	 * default balance and interest rate is set to 0
	 * @param	accountNo	the account number that will be assigned to the newly-created account
	 */
	public SavingsAccount(String accountNo) {
		super(accountNo);
		setBalance(0);
		this.interestRate = 0 ; 
	}
	
	/*
	 * Constructor used for the savings account object with three parameters
	 * @param	accountNo		the account number that will be assigned to the newly-created savings account
	 * @param	balance	 		the account balance that will be passed into the newly-created savings account
	 * @param	interestRate	the interest rate that will be passed into the newly-created savings account
	 */
	public SavingsAccount(String accountNo, double balance, double interestRate) {
		super(accountNo, balance);
		this.interestRate = interestRate ; 
	}
	
	/*
	 * Gathers the interest rate from the currently selected savings account
	 * @return the interest rate 
	 */
	public double getInterestRate() {
		return this.interestRate ; 
	}
	
	/*
	 * Changes the interest rate from the currently selected savings account to the value passed into the method
	 * @param	interestRate	the value we want to change the current interest rate to
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate ; 
	}
	
	/*
	 * Adds the interest rate of the savings account to the account balance
	 */
	public void addInterest() {
		setBalance((1+this.interestRate)*getBalance());
	}
	
	/*
	 * Prints the account number, current balance, and interest rate to the screen
	 * @return the values of the account number, current balance, and interest rate
	 * @override
	 */
	public String toString() {
		return "Account Number: " + getAccountNo() + "\n" +
				"Current Balance: " + getBalance() + "\n" +
				"Interest Rate: " + getInterestRate() ;
	}
	
	/*
	 * Displays the statistics of the savings account selected to the screen
	 * @override
	 */
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Interest Rate: " + getInterestRate()) ;
	}
}
