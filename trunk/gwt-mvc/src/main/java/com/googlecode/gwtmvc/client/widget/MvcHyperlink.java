package com.googlecode.gwtmvc.client.widget;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Hyperlink for gwt-mvc, allows to explicitly bind a hyperlink to a controller
 * action, and to pass values
 * 
 * @see Hyperlink
 */
public class MvcHyperlink extends Hyperlink {

	private static final String AND = "&";
	private static final String EQUAL = "=";
	private static final String EMPTY_STRING = "";
	private static final String QUESTION_MARK = "?";

	/**
	 * Build a Mvc Hyperlink
	 * 
	 * @param text
	 * @param targetAction
	 */
	public MvcHyperlink(String text, Enum targetAction) {
		super(text, targetAction.name());
	}

	/**
	 * Build a Mvc Hyperlink with values passed by url.
	 * 
	 * @param text
	 * @param targetAction
	 * @param values
	 */
	public MvcHyperlink(String text, Enum targetAction, Map<String, String> values) {
		super(text, targetAction.name() + QUESTION_MARK
				+ convertValues(values.entrySet().toArray(new Entry[values.size()])));
	}

	/**
	 * Build a Mvc Hyperlink with values passed by url.
	 * 
	 * @param text
	 * @param targetAction
	 * @param values
	 *            must be passed pay pair key, value
	 */
	public MvcHyperlink(String text, Enum targetAction, MvcHyperlinkEntry... values) {
		super(text, targetAction.name() + QUESTION_MARK + convertValues(values));
	}

	private static String convertValues(Entry<String, String>[] values) {
		String res = EMPTY_STRING;
		for (int i = 0; i < values.length - 1; i++) {
			res = values[i].getKey() + EQUAL + values[i].getValue() + AND;
		}
		return res + values[values.length - 1].getKey() + EQUAL + values[values.length - 1].getValue();
	}

}
