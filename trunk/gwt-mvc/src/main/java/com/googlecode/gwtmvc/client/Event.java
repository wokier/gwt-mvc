package com.googlecode.gwtmvc.client;


/**
 * Represents an event on the gui
 * 
 * USAGE: create an event to notify a user gesture to the controller
 * @param <V> action
 * @param <A> value
 */
public class Event<V, A extends Enum> {
	
	private V value;
	private A action;

	
	private Maskable maskable;
	
	/**
	 * Specify an action which comes from the browser 
	 */
	protected enum BROWSER_ACTION { BROWSER_ACTION};
	
	/**
	 * Builds an event
	 * 
	 * @param action
	 */
	public Event(A action) {
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
	 * @param action
	 * @param maskable
	 */
	public Event(A action,Maskable maskable) {
		this(action);
		this.maskable = maskable;
	}
	
	/**
	 * Builds an event with a value, and a maskable
	 * @param action
	 * @param value
	 * @param maskable
	 */
	public Event(A action, V value, Maskable maskable) {
		this(action,value);
		this.maskable = maskable;
	}

	/**
	 * Give the event action
	 * @return 
	 */
	public A getAction() {
		return action;
	}

	/**
	 * Give the event value
	 * @return 
	 */
	public V getValue() {
		return value;
	}
	
	/**
	 * Give the optional maskable
	 * @return
	 */
	public Maskable getMaskable() {
		return maskable;
	}
	
	@Override
	public String toString() {
		return action +"-"+ value;
	}
}
