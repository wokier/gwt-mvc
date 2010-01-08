package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.client.form.Form;
import com.googlecode.gwtmvc.client.form.FormValidationBuilder;
import com.googlecode.gwtmvc.client.form.FormValidationResult;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerForm.FormAction;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;
import com.googlecode.gwtmvc.poc.client.view.components.PocFormElement;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerListBox;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerTextBox;

public class PocViewFormWithMessages extends Form<Integer, VerticalPanel> {

	private PocIntegerTextBox textBox;
	private PocIntegerListBox listBox;

	private Label errorLabel;
	private PocFormElement textBoxElement;
	private PocFormElement listBoxElement;
	
	public PocViewFormWithMessages(Controller controller, PocModelProxy model) {
		super("form", controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel verticalPanel = new VerticalPanel();
		textBox = new PocIntegerTextBox("text");
		textBoxElement = new PocFormElement(" ", textBox);
		verticalPanel.add(textBoxElement);
		listBox= new PocIntegerListBox("list",5,10);
		listBoxElement = new PocFormElement(" ",listBox);
		verticalPanel.add(listBoxElement);
		errorLabel = new Label();
		errorLabel.addStyleName("errorMessage");
		verticalPanel.add(errorLabel);
		verticalPanel.add(new Button(" = ",new ClickHandler(){
			public void onClick(ClickEvent event) {
				FormValidationResult<Integer> result = getValidationResult();
				if(result.isValid()){
					controller.call(new MvcEvent<Integer>(FormAction.DO_ADDITION,result.getValue(),textBox));
				}
			}
		}));
		return verticalPanel;
	}

	@Override
	public void onModelChange(ModelForView model) {
		if(model instanceof PocModelProxy){
			initForm(((PocModelProxy)model).getValue());
		}
	}

	@Override
	public void initForm(Integer value) {
		ensureWidget();
		textBox.setValue(value);
		listBox.clearSelection();
	}

	@Override
	protected boolean validateForm() {
		clearFormErrorMessage();
		boolean formValidation = new FormValidationBuilder(false).append(textBoxElement).append(listBoxElement).getResult();
		Log.debug("Form validation is "+formValidation);
		if(!formValidation){
			setFormErrorMessage("Error");
		}
		return formValidation;
	}

	@Override
	protected Integer getFormValue() {
		int formValue = textBox.getIntegerValue() + listBox.getIntegerValue();
		Log.debug("form Value is "+formValue);
		return formValue;
	}
	
	@Override
	public void onRender() {
		Log.debug(toString()+" render");
	}
	
	@Override
	public void setFormErrorMessage(String text) {
		errorLabel.setText(text);
	}
	
	@Override
	public void clearFormErrorMessage() {
		errorLabel.setText("");
	}
	
	
}
