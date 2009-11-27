package com.googlecode.gwtmvc.client.form;

/**
 * A sub element of a form which is part of the form validation
 * 
 */
public interface FormValidationElement {

	/**
	 * Validate what the user had taped or selected.<br>
	 * Error notification could be done at the same time
	 * 
	 * @return
	 */
	boolean validate();

}
