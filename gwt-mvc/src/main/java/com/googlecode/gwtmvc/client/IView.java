package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.Element;

/**
 * The view is the graphical part of the application get datas from model use
 * controler to action on the system.
 * 
 * This interface dont use any GWT class, but View did.
 * 
 * @param <D>
 *            data type
 */
public interface IView<D> extends IModelListener<D> {

	/**
	 * Enable to initialise the view elsewhere than in the constructor. It could
	 * be used to REinitialise the view.
	 * 
	 * @deprecated replaced by lazyPanel in View
	 */
	public abstract void init();

	/**
	 * @return key of this view
	 * @deprecated
	 */
	@Deprecated
	public abstract String getKey();

	/**
	 * Give the Dom w3c Id of the view element
	 * 
	 * @see Element#getId()
	 * @return
	 */
	public abstract String getId();

	/**
	 * Render the view. The positioning could be defined by the controller, or
	 * the view itself. But the rendering is always defined by the view itself.
	 * 
	 * @see Controller#renderView(IView)
	 */
	public abstract void render();

	/**
	 * @see com.google.gwt.user.client.ui.UIObject#isVisible()
	 */
	public boolean isVisible();

}