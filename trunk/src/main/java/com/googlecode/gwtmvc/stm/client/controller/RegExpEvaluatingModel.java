package com.googlecode.gwtmvc.stm.client.controller;

import com.googlecode.gwtmvc.stm.client.model.BBoolean;
import com.googlecode.gwtmvc.stm.client.model.BString;
import com.googlecode.gwtmvc.stm.client.model.Disposable;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.ModelAdapter;
import com.googlecode.gwtmvc.stm.client.model.Model.Listener;

/**
 * This NotModel performs string validation based on RegExp. It sets
 * {@link BBoolean} to <code>TRUE</code> is string matches provided regular
 * expression.
 * 
 * NOTE: NotModel is a widget and is active only when attached to DOM. When
 * detached validator removes itself from observing target string delegate.
 * 
 * @author Igor
 * 
 */
public class RegExpEvaluatingModel extends ModelAdapter<Boolean> implements
		Listener<String>, Disposable {

	private final BString text;
	private final String regex;

	public RegExpEvaluatingModel(BString text, String regex) {
		super(false);
		this.text = text;
		this.regex = regex;
		this.text.addModelListener(this);
	}

	public void onChange(Model.Event<String> event) {
		super.setValue(event.getSource().getValue().matches(regex));
	}

	public void setValue(Boolean value) {
		throw new UnsupportedOperationException();
	}

	public void dispose() {
		this.text.removeModelListener(this);
	}
}
