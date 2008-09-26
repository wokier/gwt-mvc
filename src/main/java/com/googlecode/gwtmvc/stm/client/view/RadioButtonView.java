package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.RadioButton;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class RadioButtonView extends ViewAdapter<Boolean, RadioButton> {

	public RadioButtonView(RadioButton radioButton) {
		super(new BooleanModel(), radioButton);
	}

	public RadioButtonView(BooleanModel model, RadioButton radioButton) {
		super(model, radioButton);
	}

	@Override
	protected void createControllerRole() {
		widget.addClickListener(this);
		widget.addKeyboardListener(this);
	}

	@Override
	protected void updateModel() {
		model.setValue(widget.isChecked());
	}

	@Override
	protected void updateView(Event<Boolean> event) {
		widget.setChecked(model.getValue());
	}

	@Override
	protected void enable(Boolean value) {
		widget.setEnabled(value);
	}
}
