/*
 * @author Grant Melvin
 * Class made to hold checking accounts to be tested in the AccountTest class
 */
package assg3_melvinm19;

public class CheckingAccount extends Account{

	private double overDraft ;
	
	static double fee ;
	
	/*
	 * Creates a checking account using the constructor from the parent class (Account) with one parameter
	 * default balance and overdraft is set to 0
	 * @param	accountNo	The account number that will be used for this checking account
	 */
	public CheckingAccount(String accountNo) {
		super(accountNo);
		this.setBalance(0);
		this.overDraft = 0 ;
	}
	
	/*
	 * Creates a checking account using the constructor from the parent class (Account) with three parameters
	 * default balance and overdraft is set to whatever is passed through
	 * @param	accountNo	The account number that will be used for this checking account
	 * @param	balance		The account balance that will be used for this checking account
	 * @param	overdraft	The account overdraft limit that will be used for this checking account
	 */
	public CheckingAccount(String accountNo, double balance, double overDraft) {
		super(accountNo, balance);
		this.overDraft = overDraft ;
	}
	
	/*
	 * Gathers the overdraft limit for whatever checking account it is called on
	 * @return the overdraft value
	 */
	public double getOverDraft() {
		return this.overDraft ;
	}
	
	/*
	 * Gathers the fee limit whatever checking account it is called on
	 * @return the fee value
	 */
	public double getFee() {
		return fee ;
	}
	
	/*
	 * Changes the overdraft value for whatever account it is being called on to the value passed through it
	 * @param	overDraft	The value that we want to change the current overDraft value to
	 */
	public void setOverDraft(double overDraft){
		this.overDraft = overDraft ; 
	}
	
	/*
	 * Changes the fee value for whatever account it is being called on to the value passed through it
	 * @param	newFee		The value that we want to change the current fee value to
	 */
	public void setFee(double newFee){
		fee = newFee ; 
	}
	
	/*
	 * Prints the checking account statistics to the string
	 * @return the account number, current balance, and overdraft amount in string format
	 * @override
	 */
	public String toString() {
		return "Account Number: " + getAccountNo() + "\n" +
				"Current Balance: " + getBalance() + "\n" +
				"Overdraft Amount: " + getOverDraft() ;
	}
	
	/*
	 * Withdraws the amount passed through the method from the checking account selected
	 * Prints an error message if the withdrawal amount is greater than the account balance + overdraft
	 * @param	amount		the amount to subtract from the current account
	 * @override
	 */
	public void withdraw(double amount) {
		if(getBalance() - amount - getFee() < getOverDraft()) {
			System.out.println("ERROR: Withdrawal amount is greater than balance including overdraft!\n"
					+ "\tNo withdrawal will be made.") ;
		}
		else if(amount < 0) {
			System.out.println("ERROR: Withdrawal amount is negative!\n"
					+ "\tNo withdrawal will be made.") ;
		}
		else if((getBalance() - amount > getOverDraft()) && (getBalance() - amount < 0)) 
			setBalance(getBalance() - amount - getFee());
		else
			setBalance(getBalance() - amount);
	}
	
	/*
	 * Subtracts the amount passed to the method from the account selected and 
	 * 		adds it to the account passed into the method
	 * Prints an error message if the transfer amount is greater than the account balance + overdraft
	 * Prints an error message if the transfer amount is negative
	 * @param	toAccount	the account to add the amount to
	 * @param 	amount		the amount to add to the toAccount
	 * @override
	 */
	public void transfer(Account toAccount, double amount) {
		if(getBalance() - amount < getOverDraft()) {
			System.out.println("ERROR: Transfer amount is greater than account balance including overdraft!\n"
					+ "\tNo transfer will be made.") ;
		}
		else if(amount < 0) {
			System.out.println("ERROR: Transfer amount is negative!\n"
					+ "\tNo transfer will be made.") ;
		}
		else if(getBalance() - amount - getFee() > getOverDraft() && (getBalance() - amount < 0)) {
			setBalance(getBalance() - amount - getFee());
			toAccount.setBalance(toAccount.getBalance() + amount);
		}
		else {
			setBalance(getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
		}
	}
	
	/*
	 * Displays the checking account statitics selected to the screen
	 * @override
	 */
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Overdraft amount: " + getOverDraft()) ;
	}
}
