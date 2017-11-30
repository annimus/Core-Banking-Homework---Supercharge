package core_baking;

import java.math.BigDecimal;
import java.util.ArrayList;

import excpetions.InsufficientFundsExcpetion;

//This class is to represent the user.
public class User {
	private String name;
	private ArrayList<Account> accounts;
	
	
	//Class constructor
	public User(String n) {
		name = n;
		accounts = new ArrayList<Account>();
	}
	
	public void openAccount(BigDecimal value) {
		Account newAccount = new Account(this, value);
		accounts.add(newAccount);
		System.out.println("Opperation successful. New account open.");
	}
	
	public void closeAccount(Account a) {
		if(BigDecimal.ZERO.compareTo(a.getBalance()) == -1) {
			try {
				Actions.withdraw(a, a.getBalance());
				System.out.println("Opperation successful. Account closed.");
			} catch (InsufficientFundsExcpetion e) {
				System.out.println("Failed to peform opperation.");
			}
		}
	}
	
	//Getter's and Setter's
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(ArrayList<Account> a) {
		accounts = a;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
}
