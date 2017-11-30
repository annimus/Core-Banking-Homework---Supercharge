package excpetions;

//Exception for handling insufficient funds
public class InsufficientFundsExcpetion extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Insufficient funds. Could not complete opperation.";
	
	@Override
	public String getMessage() {
		return message;
		
	}
}
