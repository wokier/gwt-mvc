package com.googlecode.gwtmvc.client;

/**
 * Event send by the browser to signal a new URL or historyToken
 */
public class BrowserEvent {

	private String historyToken;
	
	/**
	 * Build a browser event
	 * @param historyToken
	 */
	public BrowserEvent(String historyToken) {
		super();
		this.historyToken = historyToken;
	}
	
	/**
	 * Give the history token 
	 * @return
	 */
	public String getHistoryToken() {
		return historyToken.toUpperCase();
	}
	
	@Override
	public String toString() {
		return getHistoryToken();
	}
}
