package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.core.client.EntryPoint;

public class PocEntryPoint implements EntryPoint {

	public PocEntryPoint() {
		super();
	}

	public void onModuleLoad() {
		new PocController().init();
	}

}
