package com.googlecode.gwtmvc.client;

/**
 * Allow to mask an element.<br />
 * For exemple during a loading action.<br />
 * A maskable element will show a loading picture or change its style when it
 * 'mask'
 */
public interface Maskable {

	/**
	 * mask an element, or display an animation, to indicate the begin of an
	 * asynchronous call
	 */
	public void mask();

	/**
	 * make the opposite action of mask, to indicate the end of the call
	 */
	public void unmask();

}
