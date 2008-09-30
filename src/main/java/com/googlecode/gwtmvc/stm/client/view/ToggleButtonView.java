package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.ToggleButton;
import com.googlecode.gwtmvc.stm.client.model.BBoolean;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class ToggleButtonView extends ViewAdapter<Boolean, ToggleButton> {

	public ToggleButtonView(ToggleButton radioButton) {
		super(new BBoolean(), radioButton);
	}

	public ToggleButtonView(Model<Boolean> model, ToggleButton radioButton) {
		super(model, radioButton);
	}

	public ToggleButtonView(Model<Boolean> model) {
		super(model, new ToggleButton());
	}

	@Override
	protected void createControllerRole() {
		widget.addClickListener(this);
		widget.addKeyboardListener(this);
	}

	@Override
	protected void updateModel() {
		model.setValue(widget.isDown());
	}

	@Override
	protected void updateView(Event<Boolean> event) {
		widget.setDown(model.getValue());
	}

	@Override
	protected void enable(Boolean value) {
		widget.setEnabled(value);
	}
}
