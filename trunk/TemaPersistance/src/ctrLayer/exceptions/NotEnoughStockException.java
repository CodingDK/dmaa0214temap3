package ctrLayer.exceptions;

public class NotEnoughStockException extends Exception {

	public NotEnoughStockException() {
		
	}

	public NotEnoughStockException(String message) {
		super(message);
		
	}

	public NotEnoughStockException(Throwable cause) {
		super(cause);
		
	}

	public NotEnoughStockException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NotEnoughStockException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
