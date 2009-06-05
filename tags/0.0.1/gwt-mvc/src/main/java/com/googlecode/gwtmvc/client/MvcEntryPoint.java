package com.googlecode.gwtmvc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
/**
 * implements GWT entry point
 * USAGE : configure your module with a concrete class extending this one 
 */
public abstract class MvcEntryPoint implements EntryPoint, HistoryListener {

	Controller rootController;

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
		rootController.handleBrowserEvent(new BrowserEvent(historyToken));
	}

}