package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.ui.Label;

public class PocComponent extends Label {

	public PocComponent() {
		super("waiting for initialization by PocModel");
	}

	public void setValue(Integer integer) {
		setText(String.valueOf(integer));
	}

	public Integer getValue() {
		return new Integer(getText());
	}

}
