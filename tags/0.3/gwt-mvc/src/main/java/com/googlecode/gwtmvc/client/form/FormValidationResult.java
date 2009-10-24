package com.googlecode.gwtmvc.client.form;

/**
 * Result of a form validation.
 * 
 * @param <T>
 *            type
 */
public class FormValidationResult<T> {

	private boolean isValid;
	private T value;

	protected FormValidationResult() {
		super();
		this.isValid = false;
		this.value = null;
	}

	protected FormValidationResult(T value) {
		super();
		this.isValid = true;
		this.value = value;
	}

	/**
	 * Give the final form validation result
	 * 
	 * @return
	 */
	public boolean isValid() {
		return isValid;
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
