package com.googlecode.gwtmvc.client;

/**
 * ModelForView allows view to call getValue and only getValue
 * 
 * @param <D> data
 */
public interface ModelForView<D> {

	/**
	 * @return value of this model
	 */
	public abstract D getValue();

}