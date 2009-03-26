package com.googlecode.gwtmvc.client;

import com.google.gwt.user.client.HistoryListener;

/**
 * Event send by the browser to signal a new URL or historyToken
 * 
 * @see HistoryListener
 */
public class BrowserEvent {

	private String historyToken;

	/**
	 * Build a browser event
	 * 
	 * @param historyToken
	 */
	public BrowserEvent(String historyToken) {
		super();
		this.historyToken = historyToken;
	}

	/**
	 * Give the history token
	 * 
	 * @return
	 */
	public String getHistoryToken() {
		return historyToken.toUpperCase();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getHistoryToken();
	}
}
