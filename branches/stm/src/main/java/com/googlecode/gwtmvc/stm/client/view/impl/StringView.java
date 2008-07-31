package com.googlecode.gwtmvc.stm.client.view.impl;

import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.view.View;

public class StringView implements View<String> {

	private final TextBox widget;

	public StringView(TextBox widget, Model<String> model) {
		this.widget = widget;
		widget.setText(model.getValue());
		model.addModelListener(this);
	}

	public void onChange(Event<String> event) {
		widget.setText(event.getSource().getValue());
	}

}
