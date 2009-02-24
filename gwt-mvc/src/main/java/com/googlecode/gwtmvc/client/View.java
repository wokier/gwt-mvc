package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.ui.Composite;

/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system
 * 
 * USAGE: The view could be implemented by a component or a group of components
 * The contructor must be call by the controller of the view.
 * @param <T> type
 */
public abstract class View<T> extends Composite implements IView<T> {

	protected String key;

	protected Controller controller;

	/**
	 * Build an abstract view. The view listen to his controller changes. The
	 * view listen to his models changes.
	 * 
	 * @param key
	 *            Unique id for this view
	 * @param controller
	 *            the controler which manage the view
	 * @param models The different models on which the view could get the value.
	 * 
	 * USAGE: just pass Model instance
	 */
	public View(String key, Controller controller, Model... models) {
		super();
		this.key = key;
		this.controller = controller;
		controller.addView(this);
		for (Model model : models) {
			model.addListener(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.googlecode.gwtmvc.client.IModelListener#onModelChange(com.googlecode.gwtmvc.client.ModelForView)
	 */
	public abstract void onModelChange(ModelForView<T> model) ;
	
	/**
	 * @see com.googlecode.gwtmvc.client.IView#init()
	 */
	public abstract void init();

	/**
	 * @see com.googlecode.gwtmvc.client.IView#getKey()
	 */
	public String getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		return key;
	}

}