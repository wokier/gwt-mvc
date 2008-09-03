package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.ui.Composite;

/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system
 * 
 * USAGE: The view could be implemented by a component or a group of components
 * The contructor must be call by the controller of the view.
 */
public abstract class View extends Composite {

	private String key;

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
	public String getKey() {
		return key;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

}
