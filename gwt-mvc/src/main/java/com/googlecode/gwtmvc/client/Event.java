package com.googlecode.gwtmvc.client;


/**
 * Represents an event on the gui
 * 
 * USAGE: create an event to notify a user gesture to the controller
 * @param <T>
 */
public class Event<T, V extends Enum> {

	private View sender;
	
	private V action;

	private T value;

	/**
	 * Builds an event
	 * 
	 * @param action
	 */
	public Event(View sender, V action) {
		this.sender = sender;
		this.action = action;
	}

	/**
	 * Builds an event with a value
	 * 
	 * @param action
	 * @param value
	 */
	public Event(View sender, V action, T value) {
		this(sender,action);
		this.value = value;
	}
	
	/**
	 * @return the origin of the event
	 */
	public View getSender() {
		return sender;
	}
	
	/**
	 * @return the event action
	 */
	public V getAction() {
		return action;
	}

	/**
	 * @return the event value
	 */
	public T getValue() {
		return value;
	}
}
