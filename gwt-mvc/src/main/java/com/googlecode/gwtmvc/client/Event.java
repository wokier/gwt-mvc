package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.Element;

/**
 * Represents an event on the gui
 * 
 * USAGE: create an event to notify a user gesture to the controller
 * @param <T>
 */
public class Event<T, V extends Enum> {
	
	private V action;

	private T value;
	
	private Element elementToMask;
	
	/**
	 * Specify an action which comes from the browser 
	 */
	protected enum BROWSER_ACTION { BROWSER_ACTION};
	
	/**
	 * Builds an event
	 * 
	 * @param action
	 */
	public Event(V action) {
		this.action = action;
	}

	/**
	 * Builds an event with a value
	 * 
	 * @param action
	 * @param value
	 */
	public Event(V action, T value) {
		this(action);
		this.value = value;
	}

	
	public Event(V action, T value, Element elementToMask) {
		this(action,value);
		this.elementToMask = elementToMask;
		
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
	
	/**
	 * @return the showWaitScreen value
	 */
	public boolean showWaitScreen() {
		return elementToMask!=null;
	}
	
	/**
	 * @return the elementToMask value
	 */
	public Element getElementToMask() {
		return elementToMask;
	}
	
	@Override
	public String toString() {
		return action +"-"+ value;
	}
}
