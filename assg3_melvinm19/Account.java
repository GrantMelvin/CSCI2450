/*
 * @author Grant Melvin
 * Class made to hold general accounts to be tested in the AccountTest class
 */
package assg3_melvinm19 ;

public class Account {

	private String accountNo ;
	
	private double balance ; 
	
	/*
	 * Constructor used for one-parameter version for the account object
	 * @param	accountNo	the account number that will be assigned to the newly-created account
	 */
	public Account(String accountNo) {
		this.accountNo = accountNo ;
		this.balance = 0 ;
	}
	
	/*
	 * Constructor used for two-parameter version for the account object
	 * @param	accountNo	the account number that will be assigned to the newly-created account
	 * @param	balance		the account balance that will be assigned to the newly-created account
	 */
	public Account(String accountNo, double balance) {
		this.accountNo = accountNo ;
		this.balance = balance ;
	}
	
	/*
	 * Retrieves the account number of the account it is called on
	 * @return	the account number
	 */
	public String getAccountNo() {
		return this.accountNo ;
	}
	
	/*
	 * Retrieves the account balance of the account it is called on
	 * @return	the account balance
	 */
	public double getBalance() {
		return this.balance ;
	}
	
	/*
	 * Sets the balance of the account it is called on to the parameter passed through
	 * @param	balance		the balance that we want the account to possess
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/*
	 * Adds the amount passed into the method to the balance of the account it's called on
	 * Prints an error if we try to deposit a negative amount
	 * @param	amount		the amount that we want to be added to the account
	 */
	public void deposit(double amount) {
		if(amount < 0)
			System.out.println("ERROR: Deposit amount is negative!\n "
					+ "\tNo deposit will be made.") ;
		else
			this.balance += amount ;
	}
	
	/*
	 * Withdraws the amount passed into the method from the account selected
	 * Prints error if withdrawal amount is negative and leaves account at the same balance
	 * @param	amount	the amount to be subtracted from the account
	 */
	public void withdraw(double amount) {
		if(amount > this.balance)
			System.out.println("ERROR: Withdrawal amount is greater than balance!\n"
					+ "\tNo withdrawal will be made.") ;
		else if(amount < 0) {
			System.out.println("ERROR: Withdrawal amount is negative!\n"
					+ "\tNo withdrawal will be made") ;
		}
		else
			this.balance -= amount ;
	}
	
	/*
	 * Subtracts amount from account called on and adds it to account passed through into the method
	 * Displays an error message if the amount to be transferred is greater than the balance or is negative
	 * @param	toAccount	the account to add the amount to
	 * @param 	amount		the amount to add to the toAccount
	 */
	public void transfer(Account toAccount, double amount){
		if(this.balance < amount)
			System.out.println("ERROR: Transfer amount is greater than balance!\n"
					+ "\tNo transfer will be made.") ;
		else if(amount < 0)
			System.out.println("ERROR: Transfer amount is negative!\n"
					+ "\tNo transfer will be made") ;
		else {
			setBalance(getBalance() - amount) ;
			toAccount.setBalance(toAccount.getBalance() + amount); ;
		}
	}
	
	/*
	 * Displays the account number and balance of the account it is called on
	 */
	public void displayInfo() {
		System.out.println("Account Number: " + this.accountNo) ;
		System.out.println("Current Balance: " + this.balance) ;
	}
	
	/*
	 * Returns the information of the account it is called on
	 * @return the account number an current balance of the account
	 * @override
	 */
	public String toString() {
		return "Account Number: " + this.accountNo + "\n" +
				"Current Balance: " + this.balance ;
	}
	
	/*
	 * Tests to see if one account is equal to the one we are calling on
	 * @param	account		The account to test equality with the account we are evaluating
	 * @return true if the accounts have the same account number
	 * @return false if the accounts do not have the same account number
	 * @override
	 */
	public boolean equals(Account account) {
		if(account == null)
			return false ; 
		
		if(account instanceof Account)
		{
			Account temp = (Account)account ; 
			 	
			return this.accountNo == temp.accountNo ;
		}
		
		else
			return false  ;
	}
}
