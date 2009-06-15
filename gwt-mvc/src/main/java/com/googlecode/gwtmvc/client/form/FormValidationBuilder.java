package com.googlecode.gwtmvc.client.form;

/**
 * Convenient way to build a Validation result by appending different sub
 * results.
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
	 * Build a builder and specify if the validation of sub elements must stop
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
		this.result = isValid;
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
			//no more validation is necessary
			return this;
		}
		boolean isValid;
		if (stopAtFirstError) {
			isValid = result && formValidationElement.validate();
		} else {
			isValid = formValidationElement.validate() && result;
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
