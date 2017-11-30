package core_baking;

import java.math.BigDecimal;

import excpetions.InsufficientFundsExcpetion;

//This class is for handling the possible actions for the users.
public class Actions {
	
	public static void deposit(Account account, BigDecimal value) {
		System.out.println("Depositing " + value.toString() + " to balance.");
		BigDecimal balance = account.getBalance();
		account.setBalance(balance.add(value));
		
		Transaction t = new Transaction(value, "-      ", "-", "Deposit ");
		account.getTransactionHistory().addTransaction(t);
		System.out.println("Deposit successful.");
	}
	
	public static void withdraw(Account account, BigDecimal value) throws InsufficientFundsExcpetion {
		System.out.println("Withdrawing " + value.toString() + " of balance.");
		BigDecimal balance = account.getBalance();
		
		if((balance.subtract(value)).compareTo(BigDecimal.ZERO) == -1) {
			throw new InsufficientFundsExcpetion();
			
		} else {
			account.setBalance(balance.subtract(value));
			
			Transaction t = new Transaction(value, "-      ", "-", "Withdraw");
			account.getTransactionHistory().addTransaction(t);
			
			System.out.println("Withdraw successful.");
		}
	}
	
	public static void transfer(Account userAccount, Account favouredAccount, BigDecimal value) {
		try {
			withdraw(userAccount, value);
			favouredAccount.setBalance(favouredAccount.getBalance().add(value));
			
			Transaction t1 = new Transaction(value, favouredAccount.getUser().getName(), "-", "Transfer");
			userAccount.getTransactionHistory().addTransaction(t1);
			Transaction t2 = new Transaction(value, "-      ", userAccount.getUser().getName(), "Deposit ");
			favouredAccount.getTransactionHistory().addTransaction(t2);
			
			System.out.println("Transfer successful.");
			
		} catch (InsufficientFundsExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
}
