package com.googlecode.gwtmvc.poc.client.view.components;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtmvc.client.Maskable;
import com.googlecode.gwtmvc.poc.client.PocStyleMasker;

public class PocIntegerLabel extends Label implements Maskable {


	public PocIntegerLabel() {
		super("Waiting for initialization by model");
		addStyleName("maskable");
	}
	
	public PocIntegerLabel(String id) {
		this();
		getElement().setId(id);
	}
	

	public void setValue(Integer integer) {
		setText(String.valueOf(integer));
	}

	public Integer getValue() {
		return new Integer(getText());
	}

	public void mask() {
		Log.debug("maskable mask");
		addStyleName(PocStyleMasker.MASK_STYLE_NAME);
	}
	
	public void unmask() {
		Log.debug("maskable unmask");
		removeStyleName(PocStyleMasker.MASK_STYLE_NAME);
	}
}
