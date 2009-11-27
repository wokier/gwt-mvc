package com.googlecode.gwtmvc.client.form;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.client.View;

/**
 * A form view, which adds initialisation and validation mechanisms.
 * 
 * @param <T>
 *            type
 * @param <W>
 *            content widget
 * 
 */
public abstract class Form<T, W extends Widget> extends View<T, W> {

	/**
	 * Builds a form
	 * 
	 * @param id
	 * @param controller
	 * @param models
	 */
	public Form(String id, Controller controller, Model... models) {
		super(id, controller, models);
	}

	/**
	 * Initialise the form with the value.<br>
	 * Clear the errors.<br>
	 * Keep value instance to avoid creating new instance and keep non displayed
	 * value (like an id)
	 * 
	 * @param value
	 */
	public abstract void initForm(T value);

	/**
	 * Validate each field element of the form<br>
	 * Errors are displayed at each field element, or at a top level with an
	 * alert.
	 * 
	 * @return
	 */
	protected abstract boolean validateForm();

	/**
	 * (re)populate the value.
	 * 
	 * @return
	 */
	protected abstract T getFormValue();

	/**
	 * Validate the form. the value is (re)populate only if the form is valid
	 * 
	 * @return
	 */
	public FormValidationResult<T> getValidationResult() {
		if (validateForm()) {
			return new FormValidationResult<T>(getFormValue());
		}
		return new FormValidationResult<T>();
	}

	/**
	 * Display a validation error message for the global form, or a validation error concerning multiple fileds. 
	 * @param text
	 */
	public abstract void setFormErrorMessage(String text);
	
	/**
	 * Clear the global validation error message
	 * @see #setFormErrorMessage(String)
	 */
	public abstract void clearFormErrorMessage();
}
