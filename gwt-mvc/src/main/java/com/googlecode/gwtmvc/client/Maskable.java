package com.googlecode.gwtmvc.client;
/**
 * Allow to mask an element.
 * For exemple during a loading action
 */
public interface Maskable {

	/**
	 * mask
	 */
	public void mask();
	
	/**
	 * unmask
	 */
	public void unmask();
	
}
