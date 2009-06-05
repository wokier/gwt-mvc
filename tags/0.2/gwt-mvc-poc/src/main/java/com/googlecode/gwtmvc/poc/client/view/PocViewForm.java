package com.googlecode.gwtmvc.poc.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.ModelForView;
import com.googlecode.gwtmvc.client.form.Form;
import com.googlecode.gwtmvc.client.form.FormValidationBuilder;
import com.googlecode.gwtmvc.client.form.FormValidationResult;
import com.googlecode.gwtmvc.poc.client.controller.PocControllerForm.FormAction;
import com.googlecode.gwtmvc.poc.client.model.PocModel;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerListBox;
import com.googlecode.gwtmvc.poc.client.view.components.PocIntegerTextBox;

public class PocViewForm extends Form<Integer, VerticalPanel> {

	private PocIntegerTextBox textBox= new PocIntegerTextBox("text");
	private PocIntegerListBox listBox= new PocIntegerListBox("list",5,10);

	public PocViewForm(Controller controller, PocModel model) {
		super("form", controller, model);
	}

	@Override
	public VerticalPanel createWidget() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.add(textBox);
		verticalPanel.add(listBox);
		verticalPanel.add(new Button(" = ",new ClickListener(){
			public void onClick(Widget sender) {
				FormValidationResult<Integer> result = getValidationResult();
				if(result.isValid()){
					controller.call(new Event<Integer,FormAction>(FormAction.DO_ADDITION,result.getValue(),textBox));
				}
			}
		}));
		return verticalPanel;
	}

	@Override
	public void onModelChange(ModelForView model) {
		if(model instanceof PocModel){
			initForm(((PocModel)model).getValue());
		}
	}

	@Override
	public void initForm(Integer value) {
		textBox.setValue(value);
		listBox.clearSelection();
	}

	@Override
	protected boolean validateForm() {
		boolean formValidation = new FormValidationBuilder(false).append(textBox).append(listBox).getResult();
		Log.debug("Form validation is "+formValidation);
		return formValidation;
	}

	@Override
	protected Integer getFormValue() {
		int formValue = textBox.getValue() + listBox.getValue();
		Log.debug("form Value is "+formValue);
		return formValue;
	}
}
