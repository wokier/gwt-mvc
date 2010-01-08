package com.googlecode.gwtmvc.client;

/**
 * Model listener. Use Observer/ observable pattern.
 * 
 * @see Model
 * 
 * @param <D>
 *            data
 */
public interface IModelListener<D> {

	/**
	 * Refresh the view with new datas from model
	 * 
	 * @param model
	 */
	abstract void onModelChange(ModelForView<D> model);

}
