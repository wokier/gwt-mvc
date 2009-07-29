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
public class MvcEvent<V> extends Event {
	
	/**
	 * Builds an simple event
	 * 
	 * @param action
	 */
	public MvcEvent(Enum action) {
		super(action);
	}

	/**
	 * Builds an event with a value
	 * 
	 * @param action
	 * @param value
	 */
	public MvcEvent(Enum action, V value) {
		super(action, value);
	}

	/**
	 * Builds an event with a maskable
	 * 
	 * @param action
	 * @param maskable
	 */
	public MvcEvent(Enum action, Maskable maskable) {
		super(action, maskable);
	}

	/**
	 * Builds an event with a value, and a maskable
	 * 
	 * @param action
	 * @param value
	 * @param maskable
	 */
	public MvcEvent(Enum action, V value, Maskable maskable) {
		super(action, value, maskable);
	}

	
}
