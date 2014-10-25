package ctrLayer.exceptions;

import javax.swing.JOptionPane;

public class NotEnoughStockException extends Exception {

	private static final long serialVersionUID = 1L;

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

	/**
	 * Show an error popup with the exception message.
	 */
	public void showDialog() {
		JOptionPane.showMessageDialog(null, getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
	}

}
