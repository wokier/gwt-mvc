package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.Button;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class ButtonView extends ViewAdapter<Void, Button> {

	public ButtonView(Button radioButton) {
		super(null, radioButton);
	}

	public ButtonView() {
		super(null, new Button());
	}

	@Override
	protected void createControllerRole() {
		widget.addClickListener(this);
		widget.addKeyboardListener(this);
	}

	@Override
	protected void updateModel() {
	}

	@Override
	protected void updateView(Event<Void> event) {
	}

	@Override
	protected void enable(Boolean value) {
		widget.setEnabled(value);
	}
}
