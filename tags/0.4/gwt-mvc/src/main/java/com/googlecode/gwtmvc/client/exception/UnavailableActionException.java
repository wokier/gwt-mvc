package com.googlecode.gwtmvc.client.exception;

/**
 * Exception that notify an invalid call of a controller, with an action that is unavailable at this level of the controller's tree.<br>
 * The event could not be handled by the controller or by its children.
 * Maybe you would like to call a controller that is upper the current controller.
 * To do this, get the root Controller, and then do your call. 
 */
@SuppressWarnings("serial")
public class UnavailableActionException extends RuntimeException {

	/**
	 * Constructor with context message
	 * @param message
	 */
	public UnavailableActionException(String message) {
		super(message);
	}
	
	/**
	 * Constructor with context message and cause
	 * @param message
	 * @param cause
	 */
	public UnavailableActionException(String message, Throwable cause) {
		super(message, cause);
	}

}
