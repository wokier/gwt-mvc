package com.googlecode.gwtmvc.client.form;
/**
 * Result of a form validation
 *
 * @param <T>
 */
public class FormValidationResult<T> {

	private boolean isValid = true;
	private T value;
		
	protected FormValidationResult(T value) {
		super();
		this.value = value;
	}

	protected FormValidationResult(boolean isValid, T value) {
		super();
		this.isValid = isValid;
		this.value = value;
	}

	/**
	 * Give the final form validation result
	 * @return
	 */
	public boolean isValid() {
		return isValid;
	}
	
	/**
	 * Give the value (re)populated by the form
	 * @return
	 */
	public T getValue() {
		return value;
	}
	
}
