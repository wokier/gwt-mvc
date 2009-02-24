package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a data (or a collection of data) on the client side.
 * 
 * USAGE: Your model should have methods to load his datas by a RPC call, and
 * call update method
 * 
 * @param <T> data
 */
public abstract class Model<T> implements ModelForView<T> {

	protected T value;

	private List<IModelListener<T>> listeners = new ArrayList<IModelListener<T>>();

	/**
	 * Constructor
	 */
	public Model() {
		super();
	}

	/**
	 * Initialises the model
	 */
	protected abstract void init();
	
	/**
	 * Notify a change to all listening views
	 */
	public void onChange() {
		for (IModelListener<T> modelListener : listeners) {
			modelListener.onModelChange(this);
		}
	}

	/**
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
	public void addListener(IModelListener<T> view) {
		listeners.add(view);
	}

	/**
	 * Removes this listener
	 * 
	 * @param view
	 */
	public void removeListener(IModelListener<T> view) {
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
	 * Update the model without calling the server. This action can only be done
	 * by the controller
	 * 
	 * @param value
	 * @param causeEvent
	 */
	protected void update(T value, Event causeEvent) {
		this.value = value;
		endWait(causeEvent);
		onChange();
	}
	
	private void endWait(Event causeEvent) {
		if(causeEvent.getMaskable() != null){
			causeEvent.getMaskable().unmask();
		}
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
