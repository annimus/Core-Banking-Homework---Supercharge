package main;

import java.math.BigDecimal;

import core_baking.Actions;
import core_baking.User;
import excpetions.InsufficientFundsExcpetion;

//This class is used to do unitary tests of the program's functions.
public class Main {

	public static void main(String[] args) {
		User u1 = new User("User 1 ");
		User u2 = new User("User 2 ");
		
		
		//Open account test
		System.out.println("\n\nOpen Account Test **************************************************************************");
		u1.openAccount(new BigDecimal(1000));
		System.out.println("-------------------------------------------------------------------------------------------");
		u1.openAccount(new BigDecimal(0));
		System.out.println("-------------------------------------------------------------------------------------------");
		u2.openAccount(new BigDecimal(100));
		
		System.out.println("\n\nDeposit Test *******************************************************************************");
		//Deposit test
		Actions.deposit(u1.getAccounts().get(0), new BigDecimal(150));
		System.out.println("-------------------------------------------------------------------------------------------");
		Actions.deposit(u2.getAccounts().get(0), new BigDecimal(50));
		System.out.println("-------------------------------------------------------------------------------------------");
		Actions.deposit(u1.getAccounts().get(1), new BigDecimal(235));
		
		//Withdraw test
		System.out.println("\n\nWithdraw Test ******************************************************************************");
		try {
			Actions.withdraw(u1.getAccounts().get(0), new BigDecimal(700));
		} catch (InsufficientFundsExcpetion e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------------------------------------------------------");
		try {
			Actions.withdraw(u2.getAccounts().get(0), new BigDecimal(250));
		} catch (InsufficientFundsExcpetion e1) {
			System.out.println(e1.getMessage());
		}
		
		//Transfer test
		System.out.println("\n\nTransfer Test ******************************************************************************");
		Actions.transfer(u1.getAccounts().get(0), u1.getAccounts().get(1), new BigDecimal(100));
		System.out.println("-------------------------------------------------------------------------------------------");
		Actions.transfer(u1.getAccounts().get(1), u2.getAccounts().get(0), new BigDecimal(500));
		
		//Transaction history print test
		System.out.println("\n\nTransaction History Print Test ************************************************************");
		u1.getAccounts().get(0).getTransactionHistory().printHistory(null, null);
		System.out.println("-------------------------------------------------------------------------------------------");
		u1.getAccounts().get(0).getTransactionHistory().printHistory("Withdraw", null);
		System.out.println("-------------------------------------------------------------------------------------------");
		u1.getAccounts().get(0).getTransactionHistory().printHistory(null, u1.getAccounts().get(0).getTransactionHistory().getTransactions().get(0).getDate());
		System.out.println("-------------------------------------------------------------------------------------------");
		u1.getAccounts().get(0).getTransactionHistory().printHistory("Transfer", u1.getAccounts().get(0).getTransactionHistory().getTransactions().get(0).getDate());
		
		//Close account test
		System.out.println("\n\nClose Account Test ************************************************************************");
		u1.closeAccount(u1.getAccounts().get(1));
		System.out.println("-------------------------------------------------------------------------------------------");
		u1.closeAccount(u1.getAccounts().get(0));
		System.out.println("-------------------------------------------------------------------------------------------");
		u2.closeAccount(u2.getAccounts().get(0));
	}

}
