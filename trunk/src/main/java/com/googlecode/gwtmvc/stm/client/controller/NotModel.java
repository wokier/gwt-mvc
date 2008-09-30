package com.googlecode.gwtmvc.stm.client.controller;

import java.util.ArrayList;

import com.googlecode.gwtmvc.stm.client.model.BBoolean;
import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.DomModelAdapter;
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
public class NotModel extends DomModelAdapter<Boolean> implements
		Listener<Boolean> {

	private final Model<Boolean> text;

	public NotModel(DomModelAdapter<Boolean> text) {
		super(false);
		this.text = text;
		setWidget(text);
	}

	public void onChange(Event<Boolean> event) {
		super.setValue(!event.getSource().getValue());
	}

	protected void fireChangeEvent() {
		Event<Boolean> event = createEvent();
		for (Model.Listener<Boolean> listener : new ArrayList<Model.Listener<Boolean>>(
				listeners))
			listener.onChange(event);
	}

	@Override
	protected void onLoad() {
		this.text.addModelListener(this);
	}

	@Override
	protected void onUnload() {
		this.text.removeModelListener(this);
	}

	public void setValue(Boolean value) {
		throw new UnsupportedOperationException();
	}
}