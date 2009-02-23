package com.googlecode.gwtmvc.client;
/**
 * Model listener
 *
 * @param <D>
 */
public interface IModelListener<D> {

	/**
	 * Refresh the view with new datas from model
	 * 
	 * @param model
	 */
	public abstract void onModelChange(ModelForView<D> model);
	
}
