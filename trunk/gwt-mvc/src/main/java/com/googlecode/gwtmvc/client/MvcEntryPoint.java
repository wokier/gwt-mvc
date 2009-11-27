package com.googlecode.gwtmvc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;

/**
 * Implements GWT entry point.<br>
 * 
 * USAGE : configure your module with a concrete class extending this one
 * 
 * @see EntryPoint
 */
public abstract class MvcEntryPoint implements EntryPoint, HistoryListener, UncaughtExceptionHandler {

	protected Controller rootController;
	
	/**
	 * Build an EntryPoint with the specified controller as entry
	 * 
	 * @param rootController
	 */
	public MvcEntryPoint(Controller rootController) {
		super();
		this.rootController = rootController;
		GWT.setUncaughtExceptionHandler(this);
	}

	/**
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		showPeripherals();
		rootController.init();
		History.addHistoryListener(this);
		String historyToken = History.getToken();
		if (historyToken != null && !historyToken.equals("")) {
			onHistoryChanged(historyToken);
		} else {
			rootController.showHomeView();
		}
		hideLoadingIndicator();
	}

	/**
	 * @see com.google.gwt.user.client.HistoryListener#onHistoryChanged(java.lang.String)
	 */
	public void onHistoryChanged(String historyToken) {
		if (!rootController.handleBrowserEvent(new BrowserEvent(historyToken))) {
			handle404Error(historyToken);
		}
	}

	/**
	 * Alert the user about a mistake in the url.<br>
	 * It implies that the url page is correct, but with an unknown token.<br>
	 * This behavior should be overriden.
	 * 
	 * @param historyToken
	 */
	protected void handle404Error(String historyToken) {
		Window.alert("404 This history token " + historyToken
				+ " is unknown. This is the home page.");
		rootController.showHomeView();
	}

	/**
	 * Show peripheral elements as header and menu.<br>
	 * This will always be called, wether the home page or a specific page is requested.
	 */
	protected abstract void showPeripherals();
	
	/**
	 * Hide the loading indicator, text or image placed in the initial html file
	 */
	protected abstract void hideLoadingIndicator();

}
