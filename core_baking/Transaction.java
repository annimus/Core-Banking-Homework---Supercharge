package core_baking;

import java.math.BigDecimal;
import java.util.Date;

//This class is to represent the transaction's properties.
public class Transaction {
	private Date date;
	private BigDecimal value;
	private String favouredUser;
	private String fromUser;
	private String transactionType;
	
	//Class constructor
	public Transaction(BigDecimal v, String favoured, String from, String type) {
		date = new Date();
		value = v;
		favouredUser = favoured;
		fromUser = from;
		transactionType = type;
	}

	//Getter's and Setter's
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getFavouredUser() {
		return favouredUser;
	}

	public void setFavouredUser(String favouredUser) {
		this.favouredUser = favouredUser;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
}
