package com.googlecode.gwtmvc.stm.client.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.gwtmvc.stm.client.model.Model;
import com.googlecode.gwtmvc.stm.client.model.Model.Event;
import com.googlecode.gwtmvc.stm.client.model.Model.Listener;

public class StringModel implements Model<String> {

	private String value = "";

	private List<Model.Listener<String>> listeners = new ArrayList<Listener<String>>();

	public void addModelListener(Model.Listener<String> listener) {
		listeners.add(listener);
	}

	public String getValue() {
		return value;
	}

	public void removeModelListener(Model.Listener<String> listener) {
		listeners.remove(listener);
	}

	public void setValue(String value) {
		if (this.value.equals(value))
			return;
		this.value = value;
		fireChangeEvent();
	}

	private void fireChangeEvent() {
		Event<String> event = (Event<String>) new Event<String>() {
			public Model<String> getSource() {
				return StringModel.this;
			}
		};
		for (Model.Listener<String> listener : listeners)
			listener.onChange(event);
	}

	private Event<String> event() {
		return new Event<String>() {
			public Model<String> getSource() {
				return StringModel.this;
			}
		};
	}

}
