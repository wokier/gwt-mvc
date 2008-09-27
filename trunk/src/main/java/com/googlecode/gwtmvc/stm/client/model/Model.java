package com.googlecode.gwtmvc.stm.client.model;

/**
 * Model represents a application specific data needed for the applicationto do
 * it's job.
 * 
 * This interface defines a contract put on all the model implementations. Model
 * represents a "Subject" role in Observer Pattern. It provides means to
 * read/write value, add observer (Listener) and defines an Event that is fired
 * in case a change in a model occurs.
 * 
 * @author Igor Mihalik
 * 
 * @param <T>
 *            Data type the model holds
 */
public interface Model<T> {
	/**
	 * @return model data
	 */
	T getValue();

	/**
	 * sets model data. Model should fire events only and only if new value
	 * changes. i.e. (oldValue.equals(value)==false)
	 * 
	 * @param value
	 */
	void setValue(T value);

	/**
	 * add listener to be notified about changes in model. Also all the
	 * implementations have to fire "initial" event after the registration. The
	 * event is fired only to the listener being added.
	 * 
	 * @param listener
	 */
	void addModelListener(Listener<T> listener);

	/**
	 * removed listener from the collection of listeners.
	 * 
	 * @param listener
	 */
	void removeModelListener(Listener<T> listener);

	interface Listener<T> {
		void onChange(Event<T> event);
	}

	interface Event<T> {
		Model<T> getSource();
	}

}
