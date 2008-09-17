package com.googlecode.gwtmvc.client;
/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system.
 * 
 * This interface dont use any GWT class, but View did.
 */
public interface IView {

	/**
	 * Enable to initialise the view elsewhere than in the constructor. It could
	 * be used to REinitialise the view.
	 * 
	 */
	public abstract void init();

	/**
	 * Refresh the view with new datas from model
	 * 
	 * @param model
	 */
	public abstract void onModelChange(ModelForView model);

	/**
	 * @return key of this view
	 */
	public abstract String getKey();

}