package com.googlecode.gwtmvc.client;

/**
 * ModelForView allows view to call getValue and only getValue on a model.<br />
 * The error field is available to notify an exception to the view, but you could also handle the error in the model directly. 
 * 
 * @param <D>
 *            data type
 */
public interface ModelForView<D> {

	/**
	 * Give the value of this model
	 * 
	 * @return
	 */
	public abstract D getValue();
	
	/**
	 * Give the last server call error if exists.
	 * @return
	 */
	public Throwable getError();

	/**
	 * Allows to check if the last server call had thrown an error
	 * @return
	 */
	public boolean hasError();
	
}