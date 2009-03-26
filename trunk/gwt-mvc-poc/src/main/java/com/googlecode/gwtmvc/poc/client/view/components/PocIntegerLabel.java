package com.googlecode.gwtmvc.poc.client.view.components;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Maskable;

public class PocIntegerLabel extends Label implements Maskable {

	private static final String MASK_STYLE_NAME = "mask";

	public PocIntegerLabel() {
		super("Waiting for initialization by model");
		addStyleName("maskable");
	}
	
	public void mask() {
		Log.debug("maskable mask");
		addStyleName(MASK_STYLE_NAME);
	}
	
	public void unmask() {
		Log.debug("maskable unmask");
		removeStyleName(MASK_STYLE_NAME);
	}

	public void setValue(Integer integer) {
		setText(String.valueOf(integer));
	}

	public Integer getValue() {
		return new Integer(getText());
	}

}
