package com.googlecode.gwtmvc.client.place;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.View;
/**
 * A DivWrapperPlacer is a DomPlacer based on the initial html file.<br>
 * This html file must contain some div with unique id. <br>
 * The html file acts as a decorator. It first place all static content, then different views are placed in the page.
 * @see RootPanel  
 */
public class DivWrapperPlacer implements DomPlacer {

	private static final String EMPTY_STRING = "";
	private RootPanel divContainer;

	/**
	 * Builds a DomPlacer
	 * @param divContainerId this id MUST exists on the initial html file.
	 */
	public DivWrapperPlacer(String divContainerId) {
		super();
		divContainer = RootPanel.get(divContainerId);
	}

	/**
	 * @see com.googlecode.gwtmvc.client.place.DomPlacer#clear()
	 */
	public void clear() {
		divContainer.clear();
		divContainer.getElement().setInnerText(EMPTY_STRING);
	}

	/**
	 * @see com.googlecode.gwtmvc.client.place.DomPlacer#add(com.googlecode.gwtmvc.client.IView)
	 */
	public void add(IView view) {
		divContainer.add((View)view);
		view.render();
	}
	
	/**
	 * @see com.googlecode.gwtmvc.client.place.DomPlacer#remove(com.googlecode.gwtmvc.client.IView)
	 */
	public void remove(IView view) {
		divContainer.remove((View)view);
	}

	/**
	 * @see com.googlecode.gwtmvc.client.place.DomPlacer#clearAndAdd(com.googlecode.gwtmvc.client.IView)
	 */
	public void clearAndAdd(IView view) {
		clear();
		add(view);
	}
	
	/**
	 * Get the container to access to all the object capabilities
	 * @see RootPanel
	 * @return
	 */
	public RootPanel getDivContainer() {
		return divContainer;
	}
	
	@Override
	public String toString() {
		return divContainer.getElement().getId();
	}
	
}
