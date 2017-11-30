package core_baking;

import java.math.BigDecimal;

//This class is to represent the user's account.
public class Account {
	
	private User user;
	private TransactionHistory transactionHistory;
	private BigDecimal balance;
	
	//Class Constructors
	public Account(User u) {
		user = u;
		transactionHistory = new TransactionHistory();
		balance = new BigDecimal(0);
	}
	
	public Account(User u, BigDecimal b) {
		user = u;
		transactionHistory = new TransactionHistory();
		balance = b;
	}
	
	//Get and Set Methods
	public User getUser() {
		return user;
	}
	
	public void setUser(User newUser) {
		user = newUser;
	}
	
	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}
	
	public void setTransactionHistory(TransactionHistory newTH) {
		transactionHistory = newTH;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal newBalance) {
		balance = newBalance;
	}
}
