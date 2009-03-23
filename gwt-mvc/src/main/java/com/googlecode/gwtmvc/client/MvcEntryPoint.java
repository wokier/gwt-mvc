package com.googlecode.gwtmvc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
/**
 * implements GWT entry point
 * USAGE : configure your module with a concrete class extending this one 
 */
public abstract class MvcEntryPoint implements EntryPoint, HistoryListener {

	protected Controller rootController;

	/**
	 * Build an EntryPoint with the specified controller as entry
	 * @param rootController
	 */
	public MvcEntryPoint(Controller rootController) {
		super();
		this.rootController = rootController;
	}

	/**
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		History.addHistoryListener(this);
		rootController.init();
		String historyToken = History.getToken();
		if (historyToken != null && !historyToken.equals("")) {
			onHistoryChanged(historyToken);
		} else {
			rootController.showHomeView();
		}
	}

	/**
	 * @see com.google.gwt.user.client.HistoryListener#onHistoryChanged(java.lang.String)
	 */
	public void onHistoryChanged(String historyToken) {
		if(!rootController.handleBrowserEvent(new BrowserEvent(historyToken))){
			handle404Error(historyToken);
		}
	}
	
	/**
	 * Alert the user about a mistake in the url.<br />
	 * This behavior could be overriden
	 * @param historyToken
	 */
	protected void handle404Error(String historyToken) {
		Window.alert("404 This history token "+ historyToken +" is unknown. This is the home page.");
		rootController.showHomeView();
	}

}
