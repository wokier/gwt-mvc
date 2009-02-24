package com.googlecode.gwtmvc.client.form;
/**
 * Convenient way to build a Validation result by appending different sub results
 *
 * @param <T>
 */
public class FormValidationBuilder<T> {
	
	private FormValidationResult<T> result;
	private boolean stopAtFirstError = false;
	
	/**
	 * Build a builder
	 * @param value
	 */
	public FormValidationBuilder(T value) {
		super();
		result = new FormValidationResult<T>(value);
	}
	
	/**
	 * Build a builder and specify if the validation of sub elements bust stop at the first validation returning false
	 * @param value
	 * @param stopAtFirstError (default is false)
	 */
	public FormValidationBuilder(T value, boolean stopAtFirstError) {
		super();
		result = new FormValidationResult<T>(value);
		this.stopAtFirstError = stopAtFirstError;
	}
	
	protected FormValidationBuilder(boolean isValid, T value, boolean stopAtFirstError) {
		super();
		result = new FormValidationResult<T>(value);
		this.stopAtFirstError = stopAtFirstError;
	}
	
	/**
	 * Append a new sub element to build the global validation result
	 * @param formValidationElement
	 * @return
	 */
	public FormValidationBuilder append(FormValidationElement<T> formValidationElement){
		if(stopAtFirstError && ! result.isValid()){
			return this;
		}
		boolean isValid = false;
		if(stopAtFirstError){
			isValid = isValid && formValidationElement.isValid();
		} else {
			isValid = formValidationElement.isValid() && isValid;
		}
		T value = result.getValue();
		if(isValid){
			value = formValidationElement.populate(value); 
		}
		return new FormValidationBuilder<T>(isValid, value, stopAtFirstError);
	}
	
	/**
	 * Give the final result of this builder
	 * @return
	 */
	public FormValidationResult<T> getResult() {
		return result;
	}
	
}
