package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.Element;

/**
 * The view is the graphical part of the application, get datas from model use
 * controler to action on the system.
 * 
 * This interface dont use any GWT class, but View did.
 * 
 * @param <D>
 *            data type
 */
public interface IView<D> extends IModelListener<D> {

	/**
	 * Give the Dom w3c Id of the view element
	 * 
	 * @see Element#getId()
	 * @return
	 */
	abstract String getId();

	/**
	 * Render the view after it has been placed.
	 * The default rendering is to just becoming visible.
	 * 
	 * @see Controller#renderView(IView)
	 */
	abstract void render();

	/**
	 * @see com.google.gwt.user.client.ui.UIObject#isVisible()
	 */
	boolean isVisible();

}