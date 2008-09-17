package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.ui.Composite;

/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system
 * 
 * USAGE: The view could be implemented by a component or a group of components
 * The contructor must be call by the controller of the view.
 */
public abstract class View extends Composite implements IView {

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
	 * USAGE: pass Model instance, not ModelForView Instance.
	 */
	public View(String key, Controller controller, ModelForView... models) {
		this.key = key;
		this.controller = controller;
		controller.addView(this);
		for (ModelForView modelForView : models) {
			((Model) modelForView).addListener(this);
		}
	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtmvc.client.IView#init()
	 */
	public abstract void init();

	/* (non-Javadoc)
	 * @see com.googlecode.gwtmvc.client.IView#onModelChange(com.googlecode.gwtmvc.client.ModelForView)
	 */
	public abstract void onModelChange(ModelForView model);

	/* (non-Javadoc)
	 * @see com.googlecode.gwtmvc.client.IView#getKey()
	 */
	public String getKey() {
		return key;
	}

}
