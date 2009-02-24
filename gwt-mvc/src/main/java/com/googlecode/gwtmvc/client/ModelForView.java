package com.googlecode.gwtmvc.client;

/**
 * ModelForView allows view to call getValue and only getValue
 * 
 * @param <D> data
 */
public interface ModelForView<D> {

	/**
	 * Give the value of this model
	 * @return 
	 */
	public abstract D getValue();

}