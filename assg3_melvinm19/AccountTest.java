/*
 * @author Grant Melvin
 * A class to test the components of Account, SavingsAccount, and CheckingAccount
 */
package assg3_melvinm19;

public class AccountTest {

	public static void main(String[] args) {

		// Creates the general account objects
		Account accountOne = new Account("1") ;
		Account accountTwo = new Account("2", 100) ;
		Account accountThree = new Account("3", 150.50) ;

		// Creates the checking accounts from the subclass of account
		CheckingAccount checkingOne = new CheckingAccount("4") ;
		CheckingAccount checkingTwo = new CheckingAccount("5", 200, -100) ;
		CheckingAccount checkingThree = new CheckingAccount("6", 250.50, -150.50) ;

		// Creates the saving accounts from the subclass of account
		SavingsAccount savingsOne = new SavingsAccount("7") ;
		SavingsAccount savingsTwo = new SavingsAccount("8", 300, .05) ;
		SavingsAccount savingsThree = new SavingsAccount("9", 450, .1) ;

		// Creates the mixed accounts from the subclasses of account
		Account mixedOne = new CheckingAccount("10", 500, -250) ;
		Account mixedTwo = new SavingsAccount("11", 700, .03) ;

		// Testing the toString and displayInfo methods
		accountOne.displayInfo();
		System.out.println() ;
		System.out.println(accountTwo) ;
		System.out.println() ;
		System.out.println(accountThree) ;
		System.out.println() ;
		checkingOne.displayInfo();
		System.out.println() ;
		System.out.println(checkingTwo) ;
		System.out.println() ;
		checkingThree.displayInfo();
		System.out.println() ;
		System.out.println(savingsOne) ;
		System.out.println() ;
		savingsTwo.displayInfo();
		System.out.println() ;
		System.out.println(savingsThree) ;
		System.out.println() ;
		mixedOne.displayInfo();
		System.out.println() ;
		System.out.println(mixedTwo) ;
		System.out.println();

		// Testing the setBalance method
		accountOne.setBalance(100);
		checkingTwo.setBalance(340);
		savingsThree.setBalance(570);

		// Testing the getAccountNo and getBalance methods
		// Displays balance of changed accounts
		System.out.println("----------------------------") ;
		System.out.println("account " + accountOne.getAccountNo() + " balance set to: " + accountOne.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + checkingTwo.getAccountNo() + " balance set to: " + checkingTwo.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + savingsThree.getAccountNo() + " balance set to: " + savingsThree.getBalance()) ;
		System.out.println("----------------------------") ;

		System.out.println();

		// Testing the deposit method
		System.out.println("Depositing $50 into account " + accountOne.getAccountNo() + "...") ;
		accountOne.deposit(50);
		System.out.println("Depositing $100 into account " + checkingTwo.getAccountNo() + "...") ;
		checkingTwo.deposit(100);
		System.out.println("Depositing $150 into account " + savingsThree.getAccountNo() + "...") ;
		savingsThree.deposit(150);
		System.out.println("Depositing -$150 into account " + mixedOne.getAccountNo() + "...") ;
		mixedOne.deposit(-150);

		System.out.println();

		// Displays balance of changed accounts
		System.out.println("----------------------------") ;
		System.out.println("account " + accountOne.getAccountNo() + " balance: " + accountOne.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + checkingTwo.getAccountNo() + " balance: " + checkingTwo.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + savingsThree.getAccountNo() + " balance: " + savingsThree.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + mixedOne.getAccountNo() + " balance: " + mixedOne.getBalance()) ;
		System.out.println("----------------------------") ;

		System.out.println();

		// Testing the withdraw method
		System.out.println("Withdrawing $60 from the account: " + accountOne.getAccountNo()) ;
		accountOne.withdraw(60);
		System.out.println("Withdrawing $110 from the account: " + checkingTwo.getAccountNo()) ;
		checkingTwo.withdraw(110);
		System.out.println("Withdrawing $160 from the account: " + savingsThree.getAccountNo()) ;
		savingsThree.withdraw(160);
		System.out.println("Withdrawing $1000 from the account: " + accountThree.getAccountNo()) ;
		accountThree.withdraw(1000);
		System.out.println("Withdrawing -$100 from the account: " + mixedTwo.getAccountNo()) ;
		mixedTwo.withdraw(-100);
		System.out.println("Withdrawing $300 from the account: " + savingsOne.getAccountNo()) ;
		savingsOne.withdraw(300);

		System.out.println();

		// Displays balance of changed accounts
		System.out.println("----------------------------") ;
		System.out.println("account " + accountOne.getAccountNo() + " balance: " + accountOne.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + checkingTwo.getAccountNo() + " balance: " + checkingTwo.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + savingsThree.getAccountNo() + " balance: " + savingsThree.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + accountThree.getAccountNo() + " balance: " + accountThree.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + mixedTwo.getAccountNo() + " balance: " + mixedTwo.getBalance()) ;
		System.out.println("----------------------------") ;
		System.out.println("account " + savingsOne.getAccountNo() + " balance: " + savingsOne.getBalance()) ;
		System.out.println("----------------------------") ;
		
		System.out.println();

		// Testing the transfer method
		System.out.println("Transferring $10 from account " + accountOne.getAccountNo() + " into account " + 
		accountTwo.getAccountNo() + "...") ;
		accountOne.transfer(accountTwo,10);
		System.out.println("Transferring $20 from account " + checkingTwo.getAccountNo() + " into account " + 
				checkingThree.getAccountNo() + "...") ;
		checkingTwo.transfer(checkingThree, 20);
		System.out.println("Transferring $30 from account " + savingsThree.getAccountNo() + " into account " + 
				savingsOne.getAccountNo() + "...") ;
		savingsThree.transfer(savingsOne, 30);

		System.out.println();

		// Displays balance of changed accounts
		System.out.println("----------------------------") ;		
		System.out.println("account " + accountOne.getAccountNo() + " balance: " + accountOne.getBalance()) ;
		System.out.println("account " + accountTwo.getAccountNo() + " balance: " + accountTwo.getBalance()) ;
		System.out.println("----------------------------") ;		
		System.out.println("account " + checkingTwo.getAccountNo() + " balance: " + checkingTwo.getBalance()) ;
		System.out.println("account " + checkingThree.getAccountNo() + " balance: " + checkingThree.getBalance()) ;
		System.out.println("----------------------------") ;		
		System.out.println("account " + savingsThree.getAccountNo() + " balance: " + savingsThree.getBalance()) ;
		System.out.println("account " + savingsOne.getAccountNo() + " balance: " + savingsOne.getBalance()) ;
		System.out.println("----------------------------") ;
		
		System.out.println();

		// Testing the setFee method
		System.out.println("Setting the fee for all checking accounts to $10.0") ;
		checkingOne.setFee(10);
		checkingTwo.setFee(10);
		checkingThree.setFee(10);
		
		System.out.println();
		
		// Testing the transfer method with errors and overdrafts
		System.out.println("Transferring $320 from account " + checkingTwo.getAccountNo() 
				+ " to account " + accountOne.getAccountNo() + "...") ;
		checkingTwo.transfer(accountOne,320);
		System.out.println("Transferring $140 from account " + checkingThree.getAccountNo() 
		+ " to account " + savingsOne.getAccountNo() + "...") ;
		checkingThree.transfer(savingsOne,140);
		System.out.println("Transferring $1000 from account " + checkingThree.getAccountNo() 
		+ " to account " + checkingOne.getAccountNo() + "...") ;
		checkingThree.transfer(checkingOne,1000);
		System.out.println("Transferring -$100 from account " + mixedOne.getAccountNo() 
		+ " to account " + mixedTwo.getAccountNo() + "...") ;
		mixedOne.transfer(mixedTwo,-100);

		System.out.println();
		
		// Displays balance of changed accounts
		System.out.println("----------------------------") ;
		System.out.println("account " + checkingTwo.getAccountNo() + " balance: " + checkingTwo.getBalance()) ;
		System.out.println("account " + accountOne.getAccountNo() + " balance: " + accountOne.getBalance()) ;
		System.out.println("----------------------------") ;		
		System.out.println("account " + checkingThree.getAccountNo() + " balance: " + checkingThree.getBalance()) ;
		System.out.println("account " + savingsOne.getAccountNo() + " balance: " + savingsOne.getBalance()) ;
		System.out.println("----------------------------") ;		
		System.out.println("account " + checkingThree.getAccountNo() + " balance: " + checkingThree.getBalance()) ;
		System.out.println("account " + checkingOne.getAccountNo() + " balance: " + checkingOne.getBalance()) ;
		System.out.println("----------------------------") ;		
		System.out.println("account " + mixedOne.getAccountNo() + " balance: " + mixedOne.getBalance()) ;
		System.out.println("account " + mixedTwo.getAccountNo() + " balance: " + mixedTwo.getBalance()) ;
		System.out.println("----------------------------") ;	
		System.out.println();
		
		System.out.println("The current fee for all checking accounts is: " + checkingOne.getFee()) ;
				
		System.out.println();

		// Testing the equals method
		System.out.print("Is account " + savingsOne.getAccountNo() + " equal to account " 
		+ savingsOne.getAccountNo() + "? ") ;
		if(savingsOne.equals(savingsOne))
			System.out.println("Yes") ;
		else
			System.out.println("No") ;

		System.out.print("Is account " + checkingTwo.getAccountNo() + " equal to account " 
				+ checkingOne.getAccountNo() + "? ") ;
		if(checkingTwo.equals(checkingOne))
			System.out.println("Yes") ;
		else
			System.out.println("No") ;

		System.out.print("Is account " + checkingTwo.getAccountNo() + " equal to account " 
				+ checkingTwo.getAccountNo() + "? ") ;
		if(checkingTwo.equals(checkingTwo))
			System.out.println("Yes") ;
		else
			System.out.println("No") ;

		System.out.print("Is account " + accountOne.getAccountNo() + " equal to account " 
				+ accountTwo.getAccountNo() + "? ") ;
		if(accountOne.equals(accountTwo))
			System.out.println("Yes") ;
		else
			System.out.println("No") ;
		
		System.out.println() ;
		
		// Testing the getInterestRate method
		System.out.println("The current interest rate for account " + savingsOne.getAccountNo() + " is: " + savingsOne.getInterestRate()) ; 
		System.out.println("The current interest rate for account " + savingsTwo.getAccountNo() + " is: " + savingsTwo.getInterestRate()) ;
		System.out.println("The current interest rate for account " + savingsThree.getAccountNo() + " is: " + savingsThree.getInterestRate()) ; 
		
		System.out.println() ;
		
		// Testing the setInterestRate method
		savingsOne.setInterestRate(.07) ;
		savingsTwo.setInterestRate(.09) ;
		savingsThree.setInterestRate(.12) ;
		System.out.println("Setting the interest rate for account " + savingsOne.getAccountNo() + " to: " + savingsOne.getInterestRate()) ; 
		System.out.println("Setting the interest rate for account " + savingsTwo.getAccountNo() + " to: " + savingsTwo.getInterestRate()) ; 
		System.out.println("Setting the interest rate for account " + savingsThree.getAccountNo() + " to: " + savingsThree.getInterestRate()) ; 
		
		System.out.println() ;
		
		// Testing the addInterestRate method
		savingsOne.addInterest();
		savingsTwo.addInterest();
		savingsThree.addInterest();
		
		// Displays balance of changed accounts
		System.out.println("Adding the interest for account " + savingsOne.getAccountNo() + ". "
				+ "The balance is now: " + savingsOne.getBalance()) ; 
		System.out.println("Adding the interest for account " + savingsTwo.getAccountNo() + ". "
				+ "The balance is now: " + savingsTwo.getBalance()) ; 
		System.out.println("Adding the interest for account " + savingsThree.getAccountNo() + ". "
				+ "The balance is now: " + savingsThree.getBalance()) ; 

		
	}

}
