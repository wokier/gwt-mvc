package com.googlecode.gwtmvc.client.form;

/**
 * Result of a form validation.
 * 
 * @param <T>
 *            type
 */
public class FormValidationResult<T> {

	private boolean valid;
	private T value;

	protected FormValidationResult() {
		super();
		this.valid = false;
//		this.value = null;
	}

	protected FormValidationResult(T value) {
		super();
		this.valid = true;
		this.value = value;
	}

	/**
	 * Give the final form validation result
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}
	
	/**
	 * Give the final form validation result
	 * @see FormValidationResult#isValid()
	 * @return
	 */
	protected boolean getValid() {
		return valid;
	}
	
	/**
	 * Give the value (re)populated by the form
	 * 
	 * @return
	 */
	public T getValue() {
		return value;
	}

}
