package com.googlecode.gwtmvc.client;

/**
 * Exception that notify an invalid call of a controller, with an action that is anavailable at this level of the controller's tree.
 * The event could not be handled by the controller or by its children.
 * Maybe you would like to call a controller that is upper the current controller.
 * To do this, get the root Controller, and then do your call. 
 */
public class UnavailableActionException extends RuntimeException {

	public UnavailableActionException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnavailableActionException(String message) {
		super(message);
	}

}
