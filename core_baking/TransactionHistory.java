package core_baking;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//This class is to represent the transactions performed by an user.
public class TransactionHistory {
	private ArrayList<Transaction> transactions;
	
	//Class constructor
	public TransactionHistory() {
		transactions = new ArrayList<Transaction>();
	}

	public void printHistory(String typeFilter, Date dateFilter) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Date                   | Transaction Type   | Value           | Favoured User | From User" );
		for(Transaction t : transactions) {
			if ((typeFilter == null) && (dateFilter == null)) {
				System.out.println(dateFormat.format(t.getDate()) + "    |       " + t.getTransactionType() + "     |    " 
						+ numberFormat.format(t.getValue().doubleValue()) + "    |    " + t.getFavouredUser() + "    |    " + t.getFromUser());
			} else if(((typeFilter != null) && (typeFilter.equals(t.getTransactionType())))
					|| ((dateFilter != null) && (dateFilter.compareTo(t.getDate()) == 0))) {
				System.out.println(dateFormat.format(t.getDate()) + "    |       " + t.getTransactionType() + "     |    " 
						+ numberFormat.format(t.getValue().doubleValue()) + "    |    " + t.getFavouredUser() + "    |    " + t.getFromUser());
			}
			
		}
	}
	
	//Getter's and Setter's
	public void addTransaction(Transaction t) {
		transactions.add(t);
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
