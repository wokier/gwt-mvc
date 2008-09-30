package com.googlecode.gwtmvc.stm.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.SimplePanel;

public abstract class DomModelAdapter<T> extends SimplePanel implements Model<T> {
	protected List<Model.Listener<T>> listeners = new ArrayList<Listener<T>>();
	private T value;

	public DomModelAdapter(T initValue) {
		value = initValue;
	}

	public void addModelListener(Model.Listener<T> listener) {
		listeners.add(listener);
		Event<T> event = createEvent();
		listener.onChange(event);
	}

	public void removeModelListener(Model.Listener<T> listener) {
		listeners.remove(listener);
	}

	protected void fireChangeEvent() {
		Event<T> event = createEvent();
		for (Model.Listener<T> listener : new ArrayList<Model.Listener<T>>(
				listeners))
			listener.onChange(event);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		if (this.value.equals(value))
			return;
		this.value = value;
		fireChangeEvent();
	}

	protected Event<T> createEvent() {
		return (Event<T>) new Event<T>() {
			public Model<T> getSource() {
				return DomModelAdapter.this;
			}
		};
	}

}
