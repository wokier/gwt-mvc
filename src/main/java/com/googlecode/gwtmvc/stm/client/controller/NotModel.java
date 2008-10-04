package com.googlecode.gwtmvc.stm.client.controller;

import java.util.ArrayList;

import com.googlecode.gwtmvc.stm.client.model.BBoolean;
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
public class NotModel extends ModelAdapter<Boolean> implements
		Listener<Boolean>, Disposable {

	private final Model<Boolean> text;

	public NotModel(Model<Boolean> text) {
		super(false);
		this.text = text;
		this.text.addModelListener(this);
	}

	public void onChange(Model.Event<Boolean> event) {
		super.setValue(!event.getSource().getValue());
	}

	protected void fireChangeEvent() {
		Model.Event<Boolean> event = createEvent();
		for (Model.Listener<Boolean> listener : new ArrayList<Model.Listener<Boolean>>(
				listeners))
			listener.onChange(event);
	}

	public void setValue(Boolean value) {
		throw new UnsupportedOperationException();
	}

	public void dispose() {
		this.text.removeModelListener(this);
	}
}
