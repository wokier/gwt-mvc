package com.googlecode.gwtmvc.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.History;

/**
 * Event sent by the browser to signal a new URL or historyToken.<br>
 * The GWT historyToken system allows to follow navigation history and to have
 * bookmarkable pages.<br>
 * The historyToken in gwt-mvc could be decomposed into action and params.<br>
 * Ex: url#action?param1=value1&param2=value2<br>
 * You could also use the action only.
 * 
 * @see History
 */
public class BrowserEvent {

	private String action;
	private Map<String, String> params;

	private static final String URL_PARAMS_START = "?";
	private static final String URL_PARAMS_EQUAL = "=";
	private static final String URL_PARAMS_SEPARATOR = "&";

	/**
	 * Build a browser event
	 * 
	 * @param historyToken
	 */
	public BrowserEvent(String historyToken) {
		super();
		if (historyToken.contains(URL_PARAMS_START)) {
			action = historyToken.substring(0, historyToken.indexOf(URL_PARAMS_START)).trim();
			params = toMap(historyToken.substring(historyToken.indexOf(URL_PARAMS_START) + 1).trim());
		} else {
			action = historyToken.trim();
			params = new HashMap<String, String>();
		}
	}

	private Map<String, String> toMap(String params) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		String[] paramsarray = params.split(URL_PARAMS_SEPARATOR);
		for (String param : paramsarray) {
			if (param.contains(URL_PARAMS_EQUAL)) {
				paramsMap.put(param.substring(0, param.indexOf(URL_PARAMS_EQUAL)), param.substring(param
						.indexOf(URL_PARAMS_EQUAL) + 1));
			}
		}
		return paramsMap;
	}

	/**
	 * Give the history token action
	 * 
	 * @return
	 */
	public String getAction() {
		return action.toUpperCase();
	}

	/**
	 * Give the history token params
	 * 
	 * @return
	 */
	public Map<String, String> getParams() {
		return params;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getAction() + "-" +params;
	}
}
