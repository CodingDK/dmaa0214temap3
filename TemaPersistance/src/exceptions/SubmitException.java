package exceptions;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Thrown to indicate a error in a submitted form.
 */
public class SubmitException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs an SubmitException with the specified detail message and set focus to JTextField if it's not null.
	 * @param arg0 the detail message.
	 * @param field the field to get focus.
	 */
	public SubmitException(String arg0, JTextField field) {
		super(arg0);
		if(field != null) {
			field.requestFocus();
		}
	}
	
	/**
	 * Show an error popup with the error text.
	 */
	public void showError(){
		JOptionPane.showMessageDialog(null, getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}

}
