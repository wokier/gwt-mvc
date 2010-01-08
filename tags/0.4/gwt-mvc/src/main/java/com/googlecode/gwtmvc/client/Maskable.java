package com.googlecode.gwtmvc.client;

/**
 * Allow to 'mask' an element during a loading action.<br>
 * A maskable element will show a loading indicator picture or change its style when it
 * 'mask'
 */
public interface Maskable {

	/**
	 * Mask an element, or display an animation, to indicate to the user the begin of an
	 * asynchronous call
	 */
	void mask();

	/**
	 * Do the opposite action of mask, to indicate to the user the end of the call
	 */
	void unmask();

}
