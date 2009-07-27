package com.googlecode.gwtmvc.client;

/**
 * Represents an event on the gui.
 * 
 * Lexical note: It is different from the gwt 1.6 handler/event
 * system, But a gwt-mvc Event will generally be created by a listener/handler
 * of user gestures.
 * 
 * USAGE: create an event to notify a user gesture to the controller.
 * 
 * @param <V>
 *            value
 * @param <A>
 *            action
 */
public class Event<V, A extends Enum> {

	private V value;
	private A action;

	private Maskable maskable;

	/**
	 * Builds an event
	 * 
	 * @param action
	 */
	public Event(A action) {
		super();
		this.action = action;
	}

	/**
	 * Builds an event with a value
	 * 
	 * @param action
	 * @param value
	 */
	public Event(A action, V value) {
		this(action);
		this.value = value;
	}

	/**
	 * Builds an event with a value, and a maskable
	 * 
	 * @param action
	 * @param maskable
	 */
	public Event(A action, Maskable maskable) {
		this(action);
		this.maskable = maskable;
	}

	/**
	 * Builds an event with a value, and a maskable
	 * 
	 * @param action
	 * @param value
	 * @param maskable
	 */
	public Event(A action, V value, Maskable maskable) {
		this(action, value);
		this.maskable = maskable;
	}

	/**
	 * Give the event action
	 * 
	 * @return
	 */
	public A getAction() {
		return action;
	}

	/**
	 * Give the event value
	 * 
	 * @return
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Give the optional maskable
	 * 
	 * @return
	 */
	public Maskable getMaskable() {
		return maskable;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return action + "-" + value;
	}
}
