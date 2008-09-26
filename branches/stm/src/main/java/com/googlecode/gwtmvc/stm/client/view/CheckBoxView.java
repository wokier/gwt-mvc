package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.CheckBox;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class CheckBoxView extends ViewAdapter<Boolean, CheckBox> {

	public CheckBoxView() {
		this(new CheckBox());
	}

	public CheckBoxView(CheckBox checkBox) {
		super(new BooleanModel(), checkBox);
	}

	public CheckBoxView(BooleanModel model) {
		super(model, new CheckBox());
	}

	protected void createControllerRole() {
		widget.addClickListener(this);
		widget.addKeyboardListener(this);
	}

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
