package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system. <br />A LazyPanel allows to lazy-build the view
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
 *            typex
 * @param <W>
 *            content widget
 */
public abstract class View<T, W extends Widget> extends LazyPanel implements IView<T> {

	protected String id;

	protected Controller controller;

	/**
	 * Build an abstract view. The view listen to his controller changes. The
	 * view listen to his models changes.
	 * 
	 * @param id
	 *            Unique id for this view
	 * @param controller
	 *            the controler which manage the view
	 * @param models
	 *            The different models on which the view could get the value.
	 * 
	 * USAGE: just pass Model instance
	 */
	public View(String id, Controller controller, Model... models) {
		super();
		this.id = id;
		getElement().setId(id);
		this.controller = controller;
		for (Model model : models) {
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
	 * Update the view with one of the models it listen.<br />
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
	}

	/**
	 * @see com.google.gwt.user.client.ui.UIObject#toString()
	 */
	@Override
	public String toString() {
		return id;
	}

}
