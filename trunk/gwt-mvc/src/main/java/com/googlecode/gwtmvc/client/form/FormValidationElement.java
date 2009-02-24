package com.googlecode.gwtmvc.client.form;
/**
 * a sub element of a form which is part of the form validation
 *
 * @param <T>
 */
public interface FormValidationElement<T> {

	/**
	 * Valid what the user had taped or selected.<br />
	 * Error notification could be done at the same time  
	 * @return
	 */
	public boolean isValid();

	/**
	 * Populate the value with the user input 
	 * @param value
	 * @return
	 */
	public T populate(T value);	
	
}
