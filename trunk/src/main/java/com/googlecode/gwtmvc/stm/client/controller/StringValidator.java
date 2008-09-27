package com.googlecode.gwtmvc.stm.client.controller;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtmvc.stm.client.model.BooleanModel;
import com.googlecode.gwtmvc.stm.client.model.StringModel;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.model.Model.Listener;

/**
 * This StringValidator performs string validation based on RegExp. It sets
 * {@link BooleanModel} to <code>TRUE</code> is string matches provided regular
 * expression.
 * 
 * NOTE: StringValidator is a widget and is active only when attached to DOM.
 * When detached validator removes itself from observing target string model.
 * 
 * @author Igor
 * 
 */
public class StringValidator extends Widget implements Listener<String>,
		Validator {

	private final BooleanModel valid;
	private final StringModel text;
	private final String regex;

	public StringValidator(BooleanModel valid, StringModel text, String regex) {
		setElement(DOM.createDiv());
		this.valid = valid;
		this.text = text;
		this.regex = regex;
	}

	public StringValidator(StringModel text, String regex) {
		setElement(DOM.createDiv());
		this.valid = new BooleanModel();
		this.text = text;
		this.regex = regex;
	}

	public void onChange(Event<String> event) {
		valid.setValue(event.getSource().getValue().matches(regex));
	}

	@Override
	protected void onLoad() {
		this.text.addModelListener(this);
	}

	@Override
	protected void onUnload() {
		this.text.removeModelListener(this);
	}

	public BooleanModel getValid() {
		return valid;
	}
}
