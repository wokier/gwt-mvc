package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a data on the system.
 * 
 * USAGE: Your model should have methods to load his datas by a RPC call, and
 * call update method
 * 
 * @param <T>
 */
public abstract class Model<T> implements ModelForView<T> {

	protected T value;

	private List<IView> listeners = new ArrayList<IView>();

	/**
	 * Constructor
	 */
	public Model() {
	}

	/**
	 * Notify a change to all listening views
	 */
	public void onChange() {
		for (IView view : listeners) {
			view.onModelChange(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.gwtmvc.client.ModelForView#getValue()
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Adds a listener which will be notified of modifications of this model
	 * 
	 * @param view
	 */
	public void addListener(IView view) {
		listeners.add(view);
	}

	/**
	 * Removes this listener
	 * 
	 * @param view
	 */
	public void removeListener(IView view) {
		listeners.remove(view);
	}

	/**
	 * Update the model without calling the server. This action can only be done
	 * by the controller
	 * 
	 * @param value
	 */
	protected void update(T value) {
		this.value = value;
		onChange();
	}

	/**
	 * Initialises the model
	 */
	protected abstract void init();

}
