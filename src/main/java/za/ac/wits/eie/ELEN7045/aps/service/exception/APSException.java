package za.ac.wits.eie.ELEN7045.aps.service.exception;

public class APSException extends Exception {

	private static final long serialVersionUID = -2030671175750841235L;

	public APSException() {
		super();
	}

	public APSException(String message) {
		super(message);
	}

	public APSException(String message, Throwable cause) {
		super(message, cause);
	}

	public APSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public APSException(Throwable cause) {
		super(cause);
	}
}
