package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The view is the graphical part of the application, get datas from model use
 * controler to action on the system. <br>A LazyPanel allows to lazy-build the view
 * only when the view is rendered.
 * There could be multiple Vew on the same page.
 * 
 * USAGE: The view is implemented by a widget.
 * The contructor must be call by the controller of the view.
 * 
 * @see LazyPanel
 * @see Controller
 * 
 * @param <T>
 *            type of the main object rendered by the view
 * @param <W>
 *            content widget
 */
public abstract class View<T, W extends Widget> extends LazyPanel implements IView<T> {

	protected String id;

	protected Controller controller;

	/**
	 * Build a view. The view has a controller to call and listen to his models changes.
	 * 
	 * @param id
	 *            Unique id for this view
	 * @param controller
	 *            the controler which manage the view
	 * @param models
	 *            The different models on which the view could get the value.
	 */
	public View(String id, Controller controller, ModelProxy... models) {
		super();
		this.id = id;
		getElement().setId(id);
		this.controller = controller;
		for (ModelProxy model : models) {
			model.addListener(this);
		}
	}

	/**
	 * @see com.googlecode.gwtmvc.client.IView#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * @see com.google.gwt.widgetideas.client.LazyPanel#createWidget()
	 */
	@Override
	public abstract W createWidget();

	/**
	 * Update the view with one of the models it listen.<br>
	 * use ensureWidget to force the lazy panel to build up
	 * 
	 * @see com.googlecode.gwtmvc.client.IModelListener#onModelChange(com.googlecode.gwtmvc.client.ModelForView)
	 */
	public abstract void onModelChange(ModelForView<T> model);

	/**
	 * @see com.googlecode.gwtmvc.client.IView#render()
	 */
	public void render() {
		setVisible(true);
		onRender();
	}
	
	/**
	 * Allows to add a specific behavior when the view is rendered
	 */
	public abstract void onRender();

	/**
	 * @see com.google.gwt.user.client.ui.UIObject#toString()
	 */
	@Override
	public String toString() {
		return id;
	}

}
