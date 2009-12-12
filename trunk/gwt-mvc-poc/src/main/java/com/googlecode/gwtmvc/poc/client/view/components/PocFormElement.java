package com.googlecode.gwtmvc.poc.client.view.components;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.form.FormValidationElement;

public class PocFormElement extends HorizontalPanel implements FormValidationElement {

	private FormValidationElement element;
	private Label errorLabel;

	public PocFormElement(String label, FormValidationElement element) {
		super();
		this.element = element;
		add(new Label(label));
		add((Widget)element);
		errorLabel = new Label();
		errorLabel.addStyleName("errorMessage");
		add(errorLabel);
	}

	public boolean validate() {
		clearError();
		if(element.validate()){
			return true;
		}
		setErrorMessage(element.getErrorMessage());
		return false;
	}
	
	public void clearError() {
		removeStyleName("error");
		errorLabel.setText("");
	}

	public void setErrorMessage(String errorMessage) {
		addStyleName("error");
		errorLabel.setText(errorMessage);
	}

	public String getErrorMessage() {
		return errorLabel.getText();
	}
}
