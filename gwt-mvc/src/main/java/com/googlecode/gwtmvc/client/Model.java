package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a data (or a collection of data) on the client side.
 * 
 * USAGE: Your model should have methods to load his datas by a RPC call, and
 * call update method.
 * 
 * @param <T>
 *            data type
 */
public abstract class Model<T> implements ModelForView<T> {

	protected T value;

	private List<IModelListener<T>> listeners = new ArrayList<IModelListener<T>>();

	protected boolean initialised;

	/**
	 * Constructor
	 */
	public Model() {
		super();
	}

	/**
	 * Initialises the model. This initialisation must be made by a controller
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
	 * Update the model and notify the change to the views.
	 * 
	 * @param value
	 */
	protected void update(T value) {
		this.value = value;
		onChange();
	}

	/**
	 * @see Model#update(Object) Update as the update method, plus notify the
	 *      end of a asynchronous call by using the maskable in the causeEvent.
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
		if (causeEvent.getMaskable() != null) {
			causeEvent.getMaskable().unmask();
		}
	}

	/**
	 * Give wether the controller has been initialised or not
	 * 
	 * @return true if it had been initialised
	 */
	public boolean isInitialised() {
		return initialised;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}

}
