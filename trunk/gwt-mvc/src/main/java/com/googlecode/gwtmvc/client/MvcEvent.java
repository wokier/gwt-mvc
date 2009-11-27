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
 */
public class MvcEvent<V> {

	private V value;
	private Enum action;

	private Maskable maskable;

	/**
	 * Builds an simple event
	 * 
	 * @param action
	 */
	public MvcEvent(Enum action) {
		super();
		this.action = action;
	}

	/**
	 * Builds an event with a value
	 * 
	 * @param action
	 * @param value
	 */
	public MvcEvent(Enum action, V value) {
		this(action);
		this.value = value;
	}

	/**
	 * Builds an event with a maskable
	 * 
	 * @param action
	 * @param maskable
	 */
	public MvcEvent(Enum action, Maskable maskable) {
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
	public MvcEvent(Enum action, V value, Maskable maskable) {
		this(action, value);
		this.maskable = maskable;
	}

	/**
	 * Give the event action
	 * 
	 * @return
	 */
	public Enum getAction() {
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
