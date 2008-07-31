package com.googlecode.gwtmvc.stm.client.model;

public interface Model<T> {
	T getValue();

	void setValue(T value);

	void addModelListener(Listener<T> listener);

	void removeModelListener(Listener<T> listener);

	interface Listener<T> {
		void onChange(Event<T> event);
	}
	
	interface Event<T> {
		Model<T> getSource();
	}
		

}
