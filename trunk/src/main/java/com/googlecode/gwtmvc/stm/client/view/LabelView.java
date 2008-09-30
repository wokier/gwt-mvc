package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class LabelView extends ViewAdapter<String, Label> {

	public LabelView(Label textBox) {
		super(new BString(textBox.getText()), textBox);
	}

	public LabelView() {
		this(new Label());
	}

	public LabelView(BString text) {
		super(text, new Label());
	}

	public LabelView(String string) {
		this(new BString(string));
	}

	protected void createControllerRole() {
	}

	protected void updateModel() {
		model.setValue(widget.getText());
	}

	@Override
	protected void updateView(Event<String> event) {
		if (!model.getValue().equals(widget.getText()))
			widget.setText(model.getValue());
	}

	@Override
	protected void enable(Boolean value) {
	}
}
