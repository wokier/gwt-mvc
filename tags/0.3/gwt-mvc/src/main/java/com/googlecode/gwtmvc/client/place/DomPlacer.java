package com.googlecode.gwtmvc.client.place;

import com.google.gwt.user.client.ui.Panel;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;
/**
 * A DomPlacer is a container that allows to attach a view to the html page dom. 
 * You could use a simple DivWrapperPlacer, or implement your own DomPlacer, eventually based on a Panel.
 * @see Panel
 */
public interface DomPlacer {

	/**
	 * Clears the container content
	 */
	void clear();

	/**
	 * Add a view and render it
	 * @see View#render()
	 * @param view
	 */
	void add(IView view);
	
	/**
	 * remove a view
	 * @param view
	 */
	void remove(IView view);
	
	/**
	 * Clear the container content and replace it with the view
	 * @param view
	 */
	void clearAndAdd(IView view);
	
}
