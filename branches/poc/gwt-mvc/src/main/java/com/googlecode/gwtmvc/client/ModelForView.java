package com.googlecode.gwtmvc.client;

/**
 * ModelForView allows view to call getValue and only getValue
 * 
 * @param <T>
 */
public interface ModelForView<T> {

	/**
	 * @return value of this model
	 */
	public abstract T getValue();

}