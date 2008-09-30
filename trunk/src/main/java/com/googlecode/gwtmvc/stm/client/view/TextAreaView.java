package com.googlecode.gwtmvc.stm.client.view;

import com.google.gwt.user.client.ui.TextArea;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;

public class TextAreaView extends ViewAdapter<String, TextArea> {

	public TextAreaView() {
		this(new TextArea());
	}

	public TextAreaView(BString string) {
		super(string, new TextArea());
	}

	public TextAreaView(TextArea textArea) {
		super(new BString(textArea.getText()), textArea);
	}

	public TextAreaView(BString text, TextArea textArea) {
		super(text, textArea);
	}

	protected void createControllerRole() {
		widget.addClickListener(this);
		widget.addKeyboardListener(this);
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
		widget.setEnabled(value);
	}
}
