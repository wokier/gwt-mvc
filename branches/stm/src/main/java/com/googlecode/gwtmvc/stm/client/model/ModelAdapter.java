package com.googlecode.gwtmvc.stm.client.model;

import java.util.ArrayList;
import java.util.List;

abstract class ModelAdapter<T> implements Model<T> {
	protected List<Model.Listener<T>> listeners = new ArrayList<Listener<T>>();
	private T value;

	public ModelAdapter(T initValue) {
		value = initValue;
	}

	public void addModelListener(Model.Listener<T> listener) {
		listeners.add(listener);
		Event<T> event = createEvent();
		listener.onChange(event);
	}

	// protected abstract Event<T> createEvent();

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
				return ModelAdapter.this;
			}
		};
	}

}