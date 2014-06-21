package za.ac.wits.eie.ELEN7045.aps.service.exception;


public class InvalidUserException extends Exception{

	public InvalidUserException() {
		super();
	}
	
	public InvalidUserException(String message) {
		super(message);
	}
	
	public InvalidUserException(Throwable cause) {
		super(cause == null ? null : cause.getMessage());
		initCause(cause);
	}

	@Override
	public String toString() {
		String s = getClass().getName();
		String message = getLocalizedMessage();
		return (message != null)? (message) : s;
	}
}
