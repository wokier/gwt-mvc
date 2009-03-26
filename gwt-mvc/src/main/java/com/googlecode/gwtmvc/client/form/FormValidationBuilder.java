package com.googlecode.gwtmvc.client.form;

/**
 * Convenient way to build a Validation result by appending different sub
 * results
 * 
 */
public class FormValidationBuilder {

	private boolean result = true;
	private boolean stopAtFirstError = false;

	/**
	 * Build a builder
	 */
	public FormValidationBuilder() {
		super();
	}

	/**
	 * Build a builder and specify if the validation of sub elements bust stop
	 * at the first validation returning false
	 * 
	 * @param stopAtFirstError
	 *            (default is false)
	 */
	public FormValidationBuilder(boolean stopAtFirstError) {
		super();
		this.stopAtFirstError = stopAtFirstError;
	}

	protected FormValidationBuilder(boolean isValid, boolean stopAtFirstError) {
		super();
		result = isValid;
		this.stopAtFirstError = stopAtFirstError;
	}

	/**
	 * Append a new sub element to build the global validation result
	 * 
	 * @param formValidationElement
	 * @return
	 */
	public FormValidationBuilder append(FormValidationElement formValidationElement) {
		if (stopAtFirstError && !result) {
			return this;
		}
		boolean isValid = false;
		if (stopAtFirstError) {
			isValid = isValid && formValidationElement.validate();
		} else {
			isValid = formValidationElement.validate() && isValid;
		}
		return new FormValidationBuilder(isValid, stopAtFirstError);
	}

	/**
	 * Give the final result of this builder
	 * 
	 * @return
	 */
	public boolean getResult() {
		return result;
	}

}
