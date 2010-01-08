package com.googlecode.gwtmvc.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a data (or a collection of data) on the client side.
 * 
 * USAGE: Your model should have his own methods to load his datas by a RPC
 * call, and then call update method.
 * 
 * @param <T>
 *            data type
 * @deprecated Use ModelProxy instead
 */
@Deprecated
public abstract class Model<T> implements ModelForView<T> {

	protected T value;

	private List<IModelListener<T>> listeners = new ArrayList<IModelListener<T>>();

	protected boolean initialised;

	private Throwable error;

	/**
	 * Constructor
	 */
	public Model() {
		super();
	}

	/**
	 * Constructor with an initial value
	 */
	public Model(T value) {
		super();
		this.value = value;
	}

	/**
	 * Initialises the model. This initialisation must be made by a controller.
	 * 
	 * @see Controller#initModel(Model)
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
	 * @deprecated
	 * @see Model#update(Object, MvcEvent)
	 */
	@Deprecated
	protected void update(T value) {
		this.value = value;
		this.error = null;
		onChange();
	}

	/**
	 * @see Model#update(Object) Update as the update method, plus notify the
	 *      end of a asynchronous call by using the maskable in the causeEvent.
	 * 
	 * @param value
	 * @param causeEvent
	 */
	protected void update(T value, MvcEvent causeEvent) {
		this.value = value;
		this.error = null;
		endWait(causeEvent);
		onChange();
	}

	/**
	 * Update the model and notify the change to the views.
	 * 
	 * @param error
	 */
	protected void update(Throwable error) {
		update(error, true);
	}

	/**
	 * @see Model#update(Object) Update as the update method, plus notify the
	 *      end of the asynchronous call by using the maskable in the causeEvent.
	 * 
	 * @param error
	 * @param causeEvent
	 */
	protected void update(Throwable error, MvcEvent causeEvent) {
		update(error, causeEvent, true);
	}

	/**
	 * Update the model and notify the error to the views.
	 * 
	 * @param error
	 * @param resetValue
	 *            if the value is set to null (default is true)
	 * @deprecated
	 * @see Model#update(Throwable, MvcEvent, boolean)
	 */
	protected void update(Throwable error, boolean resetValue) {
		if (resetValue) {
			this.value = null;
		}
		this.error = error;
		onChange();
	}

	/**
	 * @see Model#update(Object) Update as the update method, plus notify the
	 *      end of the asynchronous call by using the maskable in the causeEvent.
	 * 
	 * @param error
	 * @param causeEvent
	 * @param resetValue
	 *            if the value is set to null (default is true)
	 */
	protected void update(Throwable error, MvcEvent causeEvent, boolean resetValue) {
		if (resetValue) {
			this.value = null;
		}
		this.error = error;
		endWait(causeEvent);
		onChange();
	}

	private void endWait(MvcEvent causeEvent) {
		if (causeEvent.getMaskable() != null) {
			causeEvent.getMaskable().unmask();
		}
	}

	/**
	 * Give wether the controller has been initialised or not.<br>
	 * The controller is initialised when it handle an event, or when the method
	 * doInitIfNecessary is called.
	 * 
	 * @return true if it had been initialised
	 */
	public boolean isInitialised() {
		return initialised;
	}

	/**
	 * @see com.googlecode.gwtmvc.client.ModelForView#getError()
	 */
	public Throwable getError() {
		return error;
	}

	/**
	 * @see com.googlecode.gwtmvc.client.ModelForView#hasError()
	 */
	public boolean hasError() {
		return error != null;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}

}
